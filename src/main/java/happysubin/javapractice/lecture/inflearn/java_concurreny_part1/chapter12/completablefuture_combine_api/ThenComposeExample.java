package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter12.completablefuture_combine_api;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThenComposeExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyService myService = new MyService();

        CompletableFuture<Integer> asyncTask1 = myService.getData(5);


        /** thenCompose()
         * 인스턴스 메서드로서 (비)동기적으로 하나의 CompletableFuture 가 완료되면 그 결과를 다음 작업으로 전달하고 이어서 다음 작업을 수행할 수 있도록 해 준다.
         * 를 통해 여러 비동기 작업을 연속적으로 실행하고 조합할 수 있다.
         */
        CompletableFuture<Integer> asyncTask2 = asyncTask1.thenCompose(result -> myService.getData(result));

        Integer result = asyncTask2.get();

        System.out.println("result = " + result);
    }


    static class MyService {

        public CompletableFuture<Integer> getData(int input) {
            return CompletableFuture.supplyAsync(() -> {
               try {
                   Thread.sleep(2000);
               } catch (InterruptedException e) {
                   Thread.currentThread().interrupt();
               }
               return input * 2;
            });
        }

        public CompletableFuture<Integer> getDate2(int input) {
            return CompletableFuture.supplyAsync(() -> {
               try {
                   Thread.sleep(2000);
               } catch (InterruptedException e) {
                   Thread.currentThread().interrupt();
               }
               return input * 2;
            });
        }
    }
}
