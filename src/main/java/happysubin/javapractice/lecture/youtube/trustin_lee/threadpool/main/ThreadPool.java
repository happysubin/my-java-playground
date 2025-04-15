package happysubin.javapractice.lecture.youtube.trustin_lee.threadpool.main;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

public class ThreadPool implements Executor {

    /**
     * 현재 로직은 큐가 언제 초기화될지 모르므로 모호한 로직,
     *
     * 자바 초기화 순서
     * 1. 필드가 선언된 순서대로 초기화(기본 값 할당 후 명시적 초기화 실행)
     * 2. 초기화 블록 실행
     * 3. 마지막으로 생성자 호출
     *
     * 같은 스레드 내에서 this의 참조를 넘기게 되면 말씀하신 내용이 맞음,
     * 생성자의 호출이 완전히 끝나기 전에 다른 스레드에 this의 참조를 넘기게 되면 JVM 스펙상 보장이 되지 않는다.
     * 따라서 생성자의 호출이 완전히 완료된 뒤에 넘겨줘야한다
     */
    private final BlockingQueue<Runnable> queue = new LinkedTransferQueue<>();
    private final Thread[] threads;

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
