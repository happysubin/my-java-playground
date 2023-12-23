package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter11;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PreStartThreadsExample {
    public static void main(String[] args) {

        int corePoolSize = 2;
        int maxPoolSize = 4;
        long keepAliveTime = 0L;
        BlockingQueue<Runnable> workQueue =  new LinkedBlockingQueue<>();
        int taskNum = 9;

        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue);

        //스레드풀 execute는 태스크가 오지 않으면 스레드를 생성하지 않음. 그래서 미리 prestart를 시킨다.
//        executor.prestartCoreThread(); 1개의 코어 스레드만 생성
//        executor.prestartCoreThread();

        executor.prestartAllCoreThreads(); // 코어 스레드 전부 생성

        for (int i = 0; i < taskNum; i++) {
            final int taskId = i;
            executor.execute(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " 가 태스크" + taskId + " 를 실행하고 있습니다.");
            });
        }

        executor.shutdown();

    }
}
