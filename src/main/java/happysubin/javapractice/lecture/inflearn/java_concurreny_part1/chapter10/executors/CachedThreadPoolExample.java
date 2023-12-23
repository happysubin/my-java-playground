package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter10.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 동기 큐, 60초 동안 사용되지 않은 스레드는 자동 종료되고 캐시에서 제거
 * 스레드 풀의 갯수가 요청에 따라 왔다리갔다
 */
public class CachedThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 20; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println("Task " + taskId + " is executing on " + Thread.currentThread().getName());
            });
        }

        // 60초 동안 아무 작업도 수행 하지 않음
        try {
            Thread.sleep(70000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 60초 이상 동안 사용 되지 않은 스레드는 자동 종료됨

        executor.shutdown();
    }
}
