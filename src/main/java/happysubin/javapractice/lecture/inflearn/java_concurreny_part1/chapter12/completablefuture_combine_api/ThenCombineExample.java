package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter12.completablefuture_combine_api;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThenCombineExample {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyService myService = new MyService();
        CompletableFuture<String> cf1 = myService.getData1();
        CompletableFuture<String> cf2 = myService.getData2();

        /**
         * thenCombine
         * 두 개의 CompletableFuture 가 모두 완료되었을 때 특정 함수를 실행하고 그 결과를 새로운 CompletableFuture 에 저장하고 반환한다
         */
        CompletableFuture<String> cf3 = cf1.thenCombine(cf2, (r1, r2) -> r1 + r2);

        CompletableFuture<String> cf4 = cf3.thenCompose(result -> CompletableFuture.supplyAsync(() -> result + " Java"));

        System.out.println("final result: " + cf4.get());
    }

    static class MyService {

        public CompletableFuture<String> getData1() {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(500); // 2초 동안 대기
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return "Hello ";
            });
        }

        public CompletableFuture<String> getData2() {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(500); // 2초 동안 대기
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return "World";
            });
        }
    }
}
