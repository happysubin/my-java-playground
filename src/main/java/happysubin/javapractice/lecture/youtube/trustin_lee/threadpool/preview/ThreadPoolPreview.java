package happysubin.javapractice.lecture.youtube.trustin_lee.threadpool.preview;

import org.springframework.boot.actuate.management.ThreadDumpEndpoint;

import java.util.concurrent.*;

public class ThreadPoolPreview {

    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
        /**
         * NOT OK
         * 스레드 풀에서 스레드를 빌려온게 아님.
         * 스레드 풀안의 스레드는 함께 쓰는 자원인데, 실제 필요하지 않은 시점에 가져와서 5초 낭비.
         * 5초 동안 다른 친구들이 스레드를 못빌려감. 이러면 안됨
         */
        executor.execute(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("not ok");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        /**
         * OK
         *
         */
        executor.schedule(() -> {
            System.out.println("ok");
        }, 5, TimeUnit.SECONDS);



        //A 고정 비율로 실행
        executor.scheduleAtFixedRate(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("threadPoolExecutor = " + executor);
        }, 5, 4, TimeUnit.SECONDS);

        //B 지연되는것도 반영하고 싶다면 scheduleWithFixedDelay를 실행
        //실질적으로 리턴 값인 ScheduledFuture 완료 값이 없다.
        //반복적으로 실행되므로 Future가 완료되어서 종료되는 경우는 없다.
        // 종료되는 경우는 ScheduledFuture가 cancel 되었을 때
        executor.scheduleWithFixedDelay(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("threadPoolExecutor = " + executor);
        }, 5, 4, TimeUnit.SECONDS);

        /**
         *            A        B
         * t+0s   1회차 실행  2회차 실행
         * t+5s   2회차 실행  ...
         * t+6s   ...       2회차 실행
         * t+10s  3회차 실행  ...
         * t+12s  ...       3회차 실행
         */



    }
}
