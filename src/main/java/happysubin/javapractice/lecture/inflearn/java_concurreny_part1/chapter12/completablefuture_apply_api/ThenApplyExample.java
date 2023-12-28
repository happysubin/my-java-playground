package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter12.completablefuture_apply_api;

import java.util.concurrent.CompletableFuture;

public class ThenApplyExample {

    public static void main(String[] args) {
        MyService myService = new MyService();
        long started = System.currentTimeMillis();

        CompletableFuture<Integer> asyncFuture = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("thread1:" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return 40;
                })
                /**
                 * thenApply() 는 작업을 실행하는 시점에서 이전 작업 결과가 완료 되었다면 메인 스레드에서 처리되고 그렇지 않으면 이전과 동일한 스레드에서 처리
                 * thenApply() 는 작업을 실행하는 시점에서 이전 작업 결과가 완료 되지 않았다면 이전과 동일한 스레드에서 처리
                 */
                .thenApply(result -> {
                    System.out.println("thread2:" + Thread.currentThread().getName());
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                    int r = myService.getData1();
                    return r + result;
                })
                .thenApplyAsync(result -> {
                    System.out.println("thread3:" + Thread.currentThread().getName());
                    int r = myService.getData2();
                    return r + result;
                });
        int asyncResult = asyncFuture.join();
        System.out.println("final result: " + asyncResult);
        System.out.println("총 소요 시간: " + (System.currentTimeMillis() - started));
    }

    static class MyService {

        public int getData1(){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 50;
        }

        public int getData2(){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 60;
        }
    }
}
