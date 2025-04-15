package happysubin.javapractice.lecture.youtube.trustin_lee.threadpool.main;

import happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter12.completablefuture_start_api.RunAsyncExample;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executor;


class ThreadPoolTest {


    @Test
    public void submitTasksAreExecuted() {
        final Executor executor = new ThreadPool(2);


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
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " executes a task " + finalI);
            });
        }
    }
}