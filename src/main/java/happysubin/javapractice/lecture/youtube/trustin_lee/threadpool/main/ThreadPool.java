package happysubin.javapractice.lecture.youtube.trustin_lee.threadpool.main;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPool implements Executor {

    private static final Runnable SHUTDOWN_TASK = () -> {};
    private static final Thread[] EMPTY_THREADS_ARRAY = new Thread[0];

    private final int maxNumThreads;

    private final BlockingQueue<Runnable> queue = new LinkedTransferQueue<>();
    private final AtomicBoolean shutdown = new AtomicBoolean();
    private final Set<Thread> threads = new HashSet<>();
    private final AtomicInteger numThreads = new AtomicInteger();
    private final AtomicInteger numActiveThreads = new AtomicInteger();
    private final Lock threadsLock = new ReentrantLock();

    public ThreadPool(int maxNumThreads) {
        this.maxNumThreads = maxNumThreads;
    }

    @NotNull
    private Thread newThread() {
        numThreads.incrementAndGet();
        return new Thread(() -> {
            boolean isActive = false; //내가 일을하고 있냐 기억하는 용도
            try {
                for (; ; ) {
                    try {
                        /**
                         * 최적화 시도
                         * 현재는 태스크를 넣고 뺗때 increment, decrement
                         * 최적화는 다른 태스크가 존재해야 increment, decrement
                         */
                        Runnable task = queue.poll();
                        if(task == null) {
                            if(isActive) {
                                isActive = false; //task가 null인데, active가 true라면 처리할 작없이 없으면 false
                                numActiveThreads.decrementAndGet();
                            }
                            task = queue.take(); //블록킹 대기
                        } else {
                            if(!isActive) {
                                isActive = true;
                                numActiveThreads.incrementAndGet(); //작업이 생기면 ++
                            }
                        }
                        /**
                         * 아래는 태스크가 항상 널이 아님
                         */
                        if (task == SHUTDOWN_TASK) {
                            break;
                        } else {
                            task.run();
//                            보통은 작업이 있을 때마다 numActiveThreads++, 작업이 끝나면 -- 하는 식으로 처리. 비효율적
//                            numActiveThreads.incrementAndGet();
//                            try {
//                                task.run();
//                            } finally {
//                                numActiveThreads.decrementAndGet();
//                            }
                        }
                    } catch (Throwable t) {
                        if (!(t instanceof InterruptedException)) { //자바 스펙상 안돼서 always true 라고 나오지만 실제로 발생할 수 있다.
                            System.err.println("Unexpected exception: ");
                            t.printStackTrace();
                        }
                    }
                }
            } finally {
                numThreads.decrementAndGet();
            }
            System.err.println("Shutting thread '" + Thread.currentThread().getName() + '\'');
        });
    }

    @Override
    public void execute(@NotNull Runnable command) {
//        필요 없어짐
//        if(started.compareAndSet(false, true)) {
//            for (Thread thread : threads) {
//                thread.start();
//            }
//        }

        if(shutdown.get()) {
            throw new RejectedExecutionException();
        }

        queue.add(command);

        addThreadIfNecessary();

        /**
         * add되고 shutdown 될 수 있으므로 한번 더 체크
         */
        if(shutdown.get()) {
            queue.remove(command);
            throw new RejectedExecutionException();
        }
    }

    private void addThreadIfNecessary() {
        if(needsMoreThreads()) {
            threadsLock.lock();
            Thread newThread = null;
            try {
                /**
                 * 동시에 여러스레드가 위 if문을 통과할 수 있으므로, 한번 더 체크
                 */

                if(needsMoreThreads()) {
                    newThread = newThread();
                    threads.add(newThread);
                }

            } finally {
                threadsLock.unlock();
            }

            if(newThread != null) {
                newThread.start();
            }
        }
    }

    private boolean needsMoreThreads() {
        final int numActiveThreads = this.numActiveThreads.get();
        return numActiveThreads < maxNumThreads && numActiveThreads >= numThreads.get();
//        threads.size() 메서드 호출이 꽤 무거운 호출이다. 따라서 numThreads 도입
//        return numActiveThreads < maxNumThreads && numActiveThreads >= threads.size();
    }

    public void shutdown() {

        if(shutdown.compareAndSet(false, true)) {
            for (int i = 0; i < maxNumThreads; i++) { //maxNum으로 해도 사소한 낭비
                queue.add(SHUTDOWN_TASK);
            }
        }

        //FIXME: Fix the race condition where a new thread is added by execute() during shutdown.
        //레이스 컨디션 문제가 있을 수 있으므로 루프로 감싼다. 여전히 문제는 존재
        for(;;) {
            final Thread[] threads;
            threadsLock.lock();
            try {
                /**
                 * toArray() 호출시에는 락을 잡았고,
                 * 이렇게 만들어진 배열은 현재 스코프에서만 접근 가능하므로 (다른 누구도 접근할 수 없으르모) 락을 잡을 필요가 없다.
                 */
                threads = this.threads.toArray(EMPTY_THREADS_ARRAY);
            } finally {
                threadsLock.unlock();
            }

            if(threads.length == 0) {
                break;
            }

            for (Thread thread : threads) {
                do {
                    try {
                        thread.join(); //스레드가 종료될때까지 기다려준다. 무한 루프는 cpu 소모가 많으므로 해당 방식을 채택
                    } catch (InterruptedException e) {
                        // Do not propagate to prevent incomplete shutdown.
                    }
                } while (thread.isAlive());
            }
        }
    }
}

/**
 *
 */