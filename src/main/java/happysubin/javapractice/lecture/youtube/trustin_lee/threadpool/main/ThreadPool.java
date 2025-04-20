package happysubin.javapractice.lecture.youtube.trustin_lee.threadpool.main;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadPool implements Executor {

    private static final Runnable SHUTDOWN_TASK = () -> {};

    private final BlockingQueue<Runnable> queue = new LinkedTransferQueue<>();
    private final Thread[] threads;
    private final AtomicBoolean started = new AtomicBoolean(); //동시성 이슈가 있으므로 해당 클래스 사용
    private volatile boolean shutdown; //코어 캐시 사용 X

    public ThreadPool(int numThreads) {
        this.threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                //queue.poll(); poll은 안됨. 없으면 바로 return하니까, timeout도 줄 필요 없다.
                //계속 실행해야하니 무한 루프
                while(!shutdown || !queue.isEmpty()) { //큐가 끝날때까지 돈다
                    try {
                        final Runnable task = queue.take();

                        if(task == SHUTDOWN_TASK) {
                            break;
                        } else {
                            task.run();
                        }
                    } catch (Throwable t) {
                        if(!(t instanceof InterruptedException)) { //자바 스펙상 안돼서 always true 라고 나오지만 실제로 발생할 수 있다.
                            System.err.println("Unexpected exception: ");
                            t.printStackTrace();
                        }
                    }
                }

                System.err.println("Shutting thread '" + Thread.currentThread().getName() + '\'');
            });
        }
    }

    @Override
    public void execute(@NotNull Runnable command) {
        /**
         * CAS에 의해 동시성 이슈에서 안전하다.
         */
        if(started.compareAndSet(false, true)) {
            for (Thread thread : threads) {
                thread.start();
            }
        }

        if(shutdown) {
            throw new RejectedExecutionException();
        }

        queue.add(command);
    }

    public void shutdown() {
        this.shutdown = true;

        /**
         * 이렇게 해야 take에서 무한 대기하는 스레드가 없어진다.
         * 이걸 도입하면 interrupt()를 호출하지 않아도 된다.
         */
        for (int i = 0; i < threads.length; i++) {
            queue.add(SHUTDOWN_TASK);
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
