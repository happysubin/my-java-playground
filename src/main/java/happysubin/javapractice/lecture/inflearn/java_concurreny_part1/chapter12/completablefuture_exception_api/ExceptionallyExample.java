package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter12.completablefuture_exception_api;

import java.util.concurrent.CompletableFuture;

public class ExceptionallyExample {

    public static void main(String[] args) {
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return 10 / 0;
        }).exceptionally(e -> {
            System.out.println("Exception " + e.getMessage());
            return -1; //대체 결과를 반환
        }).thenApplyAsync(result -> {
            return result + 5;  //여기에서 예외가 터져도 위 exceptionally 구문이 동작하지 않는다.
        });

        System.out.println("cf.join() = " + cf.join());
    }
}
