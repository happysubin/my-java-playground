package happysubin.javapractice.lecture.youtube.trustin_lee.threadpool.main;

import happysubin.javapractice.lecture.youtube.trustin_lee.threadpool.history.day1.Day1ThreadPool;
import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;


class ThreadPoolTest {


    @Test
    public void submitTasksAreExecutedAtDay1() throws InterruptedException {
        final Day1ThreadPool executor = new Day1ThreadPool(2);
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

//            latch.await();
        } finally {
            executor.shutdown();
        }
    }


    @Test
    public void submitTasksAreExecutedAtDay2() throws InterruptedException {
        final ThreadPool executor = new ThreadPool(100);
        final int numTasks = 100;
        final CountDownLatch latch = new CountDownLatch(numTasks);

        try {

            /**
             * 1. Thread.sleep()을 지우면 maxNumThreads 로 100개로 할당해도 1개 스레드가 모두 해결한다. lazy 하게 해결
             * 2. Thread.sleep()을 반영해도 maxNumThreads 100개까지 안올라간다. (강의는 스레드 2개, 본인 컴은 스레드 4개)
             */
            for (int i = 0; i < numTasks; i++) {
                final int finalI = i;
                executor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " executes a task " + finalI);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                    latch.countDown();
                });
            }
        } finally {
            executor.shutdown();
        }
    }
}