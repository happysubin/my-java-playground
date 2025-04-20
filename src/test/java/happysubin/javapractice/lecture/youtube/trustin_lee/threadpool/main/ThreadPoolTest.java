package happysubin.javapractice.lecture.youtube.trustin_lee.threadpool.main;

import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;


class ThreadPoolTest {


    @Test
    public void submitTasksAreExecuted() throws InterruptedException {
        final ThreadPool executor = new ThreadPool(2);
        final int numTasks = 100;
        final CountDownLatch latch = new CountDownLatch(numTasks);

        try {

            /**
             * 한 스레드 안에서 순서는 맞다
             * Thread-4 executes a task 1
             * Thread-3 executes a task 0
             * Thread-3 executes a task 3
             * Thread-3 executes a task 4
             * Thread-3 executes a task 5
             * Thread-3 executes a task 6
             * Thread-4 executes a task 2
             * Thread-4 executes a task 8
             * Thread-4 executes a task 9
             * Thread-3 executes a task 7
             */
            for (int i = 0; i < numTasks; i++) {
                final int finalI = i;
                executor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " executes a task " + finalI);

                    /**
                     * 아래 내용을 추가하면 다음과 같이 출력됨
                     * Thread-3 executes a task 0
                     * Thread-4 executes a task 1
                     *
                     * 테스트 메서드가 그냥 종료되버리기 때문.
                     *
                     * 따라서 CountDownLatch을 사용
                     */
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        /**
                         * shutdown해 InterruptedException가 발생해도 여기서 잡힘
                         *
                         * 따라서 정석대로라면 여기서 interrupt를 해줘야함.
                         */
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                    latch.countDown();
                });
            }

            latch.await();
        } finally {
            executor.shutdown();
        }
    }
}