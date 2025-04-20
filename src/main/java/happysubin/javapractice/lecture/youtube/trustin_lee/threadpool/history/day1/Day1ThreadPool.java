package happysubin.javapractice.lecture.youtube.trustin_lee.threadpool.history.day1;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

public class Day1ThreadPool implements Executor {

    private static final Runnable SHUTDOWN_TASK = () -> {};

    private final BlockingQueue<Runnable> queue = new LinkedTransferQueue<>();
    private final Thread[] threads;
    private final AtomicBoolean started = new AtomicBoolean(); //동시성 이슈가 있으므로 해당 클래스 사용
    private final AtomicBoolean shutdown = new AtomicBoolean(); //동시성 이슈가 있으므로 해당 클래스 사용

    public Day1ThreadPool(int numThreads) {
        this.threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                //queue.poll(); poll은 안됨. 없으면 바로 return하니까, timeout도 줄 필요 없다.
                //계속 실행해야하니 무한 루프
                for(;;) { //큐가 끝날때까지 돈다
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

        if(shutdown.get()) {
            throw new RejectedExecutionException();
        }

        /**
         * 검증한 이후 이 라인에서 다른 스레드에 의해 shutdown이 진행될 수 있음.
         * 그럼 큐에 들어간 command는 처리가 안됨. (큐에 남아있게 된다)
         */
        queue.add(command);

        /**
         * 따라서 한번 더 체크
         * 아래는 자바 ThreadPoolExecutor 방어 로직과 유사
         */

        if(shutdown.get()) {
            queue.remove(command);
            throw new RejectedExecutionException();
        }
    }

    public void shutdown() {

        /**
         * 1번만 실행된다.
         */
        if(shutdown.compareAndSet(false, true)) {
            /**
             * 이렇게 해야 take에서 무한 대기하는 스레드가 없어진다.
             * 이걸 도입하면 interrupt()를 호출하지 않아도 된다.
             */
            for (int i = 0; i < threads.length; i++) {
                queue.add(SHUTDOWN_TASK);
            }
        }

        /**
         * 뒷부분은 실행하게 그대로 둔다.
         * 이 부분을 위 if문으로 넣으면 무슨일이 발생하는가
         *
         * 스레드 A가 shutdown()을 호출하고 아직 join 대기 중일 때, 스레드 B가 shutdown()을 호출하면 B는 아무것도 하지 않고 즉시 리턴하게 된다.
         * 이는 스레드 B가 스레드풀이 완전히 종료되기 전에 계속 진행하게 만들어 버린다.
         */
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
