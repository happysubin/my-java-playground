package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter12.completablefuture_complete_api;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompleteOnTimeoutExample {
    public static void main(String[] args) {

        getData().completeOnTimeout("Hello Java", 2, TimeUnit.SECONDS)
                .thenAccept(r -> {
                    System.out.println("r = " + r);
                }).join();
    }

    private static CompletableFuture<String> getData() {

        return CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(4000);
                return "Hello World";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
