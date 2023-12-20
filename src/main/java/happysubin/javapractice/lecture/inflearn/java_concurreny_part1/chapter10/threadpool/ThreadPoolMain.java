package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter10.threadpool;

public class ThreadPoolMain {

    public static void main(String[] args) {
        // 스레드 풀 생성 (3개의 스레드를 가진 스레드 풀)
        SimpleThreadPool threadPool = new SimpleThreadPool(30);

        // 작업을 스레드 풀에 제출
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            threadPool.submit(() -> {
                // 작업 내용
                System.out.println("작업 " + taskId + " 수행 중...");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("작업 " + taskId + " 완료.");
            });
        }

        // 스레드 풀 종료
        threadPool.shutdown();
    }
}
