package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter10.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShutDownExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> {
                try {
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + ": 작업 종료");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("인터럽트");
                    throw new RuntimeException("인터럽트 걸림");
                }
                return 42;
            });
        }

        executorService.shutdown();


        try {
            //awaitTermination : 종료가 완료되면 true를 반환하고 종료가 타임아웃 발생 전에 완료되지 않으면 false 를 반환한다
            if(!executorService.awaitTermination(1, TimeUnit.SECONDS)){//time 시간이 너무 짧으면 강제 종료 시작.
                executorService.shutdownNow();
                System.out.println("스레드 풀 강제 종료 수행");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

        if(executorService.isShutdown()){
            System.out.println("스레드 풀 종료 여부: " + executorService.isShutdown());
        }

        if(executorService.isTerminated()){
            System.out.println("스레드 풀 완전 종료 여부: " + executorService.isTerminated());
        }

        while(!executorService.isTerminated()){
            System.out.println("스레드 풀 종료 중..");
        }
        System.out.println("모든 작업이 종료되고 스레드 풀이 종료됨");
    }

}
