package happysubin.javapractice.lecture.youtube.trustin_lee.threadpool.main;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

public class ThreadPool implements Executor {

    private final BlockingQueue<Runnable> queue = new LinkedTransferQueue<>();
    private final Thread[]  threads;

    public ThreadPool(int numThreads) {
        this.threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                //queue.poll(); poll은 안됨. 없으면 바로 return하니까, timeout도 줄 필요 없다.
                try {
                    //계속 실행해야하니 무한 루프
                    for(;;) {
                        final Runnable task = queue.take(); //계속 기다림
                        task.run();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            threads[i].start();
        }
    }

    @Override
    public void execute(@NotNull Runnable command) {
        queue.add(command);
    }
}
