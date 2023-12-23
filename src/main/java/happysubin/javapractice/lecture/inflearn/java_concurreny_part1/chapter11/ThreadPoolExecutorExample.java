package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter11;

import java.util.concurrent.*;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {

        int corePoolSize = 2;
        int maxPoolSize = 4;
        long keepAliveTime = 0L;
        //BlockingQueue<Runnable> workQueue =  new LinkedBlockingQueue<>(); //수용 가능한 태스크 개수 무한
        BlockingQueue<Runnable> workQueue =  new ArrayBlockingQueue<>(4); //개수 제한
        int taskNum = 9; //8은 성공

        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue);

        for (int i = 0; i < taskNum; i++) {
            final int taskId = i;
            executor.execute(()->{
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " 가 태스크" + taskId + " 를 실행하고 있습니다.");
            });
        }

        executor.shutdown();

    }
}
