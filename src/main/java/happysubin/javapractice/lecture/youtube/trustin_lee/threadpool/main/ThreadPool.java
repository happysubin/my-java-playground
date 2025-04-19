package happysubin.javapractice.lecture.youtube.trustin_lee.threadpool.main;

import happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter09.atomiclass.AtomicBooleanExample;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadPool implements Executor {

    private final BlockingQueue<Runnable> queue = new LinkedTransferQueue<>();
    private final Thread[] threads;
    private final AtomicBoolean started = new AtomicBoolean(); //동시성 이슈가 있으므로 해당 클래스 사용
    private boolean shutdown;

    public ThreadPool(int numThreads) {
        this.threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                //queue.poll(); poll은 안됨. 없으면 바로 return하니까, timeout도 줄 필요 없다.
                try {
                    //계속 실행해야하니 무한 루프
                    while(!shutdown) {
                        final Runnable task = queue.take(); //계속 기다림
                        task.run();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
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
        queue.add(command);
    }

    public void shutdown() {
        this.shutdown = true;
        for (Thread thread : threads) {
            thread.interrupt(); //이걸 걸면 InterruptedException이 발생한다. stop()은 deprecated 됨
        }
    }

}
