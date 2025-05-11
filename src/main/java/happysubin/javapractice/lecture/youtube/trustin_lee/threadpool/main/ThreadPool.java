package happysubin.javapractice.lecture.youtube.trustin_lee.threadpool.main;

import org.jetbrains.annotations.NotNull;

import java.time.Duration;
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
    private final long idleTimeoutNanos; //큐에 아무것도 없는 상태로 이 만큼 시간이 지나면 스레드가 스스로 종료

    private final BlockingQueue<Runnable> queue = new LinkedTransferQueue<>();
    private final AtomicBoolean shutdown = new AtomicBoolean();
    private final Set<Thread> threads = new HashSet<>();
    private final AtomicInteger numThreads = new AtomicInteger();
    private final AtomicInteger numActiveThreads = new AtomicInteger();
    private final Lock threadsLock = new ReentrantLock();

    public ThreadPool(int maxNumThreads, Duration idleTimeout) {
        this.maxNumThreads = maxNumThreads;
        this.idleTimeoutNanos = idleTimeout.toNanos();
    }

    @NotNull
    private Thread newThread() {
        numThreads.incrementAndGet();
        numActiveThreads.incrementAndGet();
        Runnable target = () -> {
            System.err.println("Started a new thread: " + Thread.currentThread().getName());
            boolean isActive = true; //내가 일을하고 있냐 기억하는 용도
            long lastRunTimeNanos = System.nanoTime();
            try {
                for (; ; ) {
                    try {
                        /**
                         * 최적화 시도
                         * 현재는 태스크를 넣고 뺗때 increment, decrement
                         * 최적화는 다른 태스크가 존재해야 increment, decrement
                         */
                        Runnable task = queue.poll();
                        if (task == null) {
                            if (isActive) {
                                isActive = false; //task가 null인데, active가 true라면 처리할 작없이 없으면 false
                                numActiveThreads.decrementAndGet();
                            }

                            final long waitTimeNanos = idleTimeoutNanos - (System.nanoTime() - lastRunTimeNanos);

                            // 스레드가 작업 없이 얼마나 "놀고 있었는지"를 체크해서, 일정 시간 이상 아무 일도 하지 않았으면 종료.
                            if(waitTimeNanos <= 0) {
                                break;
                            }

                            //큐에서 요소를 꺼내고(remove) 없으면 주어진 시간 동안 기다리며,
                            //그 시간 안에 요소가 생기면 반환하고, 아니면 null을 반환합니다.
                            //대기 중 인터럽트되면 예외가 발생합니다.

                            //race 컨디션 발생 가능. 기존에 스레드가 있네? 라고 생각하고 스레드를 안만들고 태스크를 추가한다. 알고보니 스레드들은 종료하는 중. 그럼 큐에 태스크는 처리가 안되는 문제 발생
                            //대기 시간이 10초 누가 1초마다 인터럽트를 한다고 가정하면 스스로 종료 불가능. 영원히 안끝나는문제
                            task = queue.poll(idleTimeoutNanos, TimeUnit.NANOSECONDS);
                            if(task == null) {
                                break; //멈추면 finally 구문으로 삭제
                            }
                            isActive = true;
                            numActiveThreads.incrementAndGet();

                        } else {
                            if (!isActive) {
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
                            try {
                                task.run();
                            } finally {
                                // task.run() 에서 예외 터지면 기록 못하므로 finally 에서 처리
                                lastRunTimeNanos = System.nanoTime();
                            }

                        }
                    } catch (Throwable t) {
                        if (!(t instanceof InterruptedException)) { //자바 스펙상 안돼서 always true 라고 나오지만 실제로 발생할 수 있다.
                            System.err.println("Unexpected exception: ");
                            t.printStackTrace();
                        }
                    }
                }
            } finally {
                threadsLock.lock();
                try {
                    threads.remove(Thread.currentThread());
                } finally {
                    threadsLock.unlock();
                }
                numThreads.decrementAndGet();
                if (isActive) {
                    numActiveThreads.decrementAndGet();
                    System.err.println(Thread.currentThread().getName() + "not active");
                }
                System.err.println("Shutting thread '" + Thread.currentThread().getName() + '\'');
            }
            System.err.println("Shutting thread '" + Thread.currentThread().getName() + '\'');
        };

        Thread thread = new Thread(target);
        threads.add(thread);
        return thread;
    }

    @Override
    public void execute(@NotNull Runnable command) {

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
                // Note that we check if the pool is shut down *after* acquiring the lock
                // because
                // - shutting down a pool doesn't occur very often;
                // and thus it's not worth checking whether the pool is shut down or not frequently.
                if(needsMoreThreads() && !shutdown.get()) {
                    newThread = newThread();
                    threads.add(newThread);
                }

            } finally {
                threadsLock.unlock();
            }

            // Call 'Thread.start()' call out of the lock window to minimize the contention.
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
//1.25.55 스레드 자동 종료 로직 추가