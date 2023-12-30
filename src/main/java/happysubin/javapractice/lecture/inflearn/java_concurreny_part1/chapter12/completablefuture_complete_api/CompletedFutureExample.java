package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter12.completablefuture_complete_api;

import java.util.concurrent.CompletableFuture;

public class CompletedFutureExample {
    public static void main(String[] args) {

        CompletableFuture<String> cf = CompletableFuture.completedFuture("Hello World");

        // 위나 아래나 동일
//        CompletableFuture<String> cf2 = new CompletableFuture<>();
//        cf2.complete("Hello World");

        CompletableFuture<Void> finalCf = cf.thenAccept(r -> {
            System.out.println("result: " + r);
        });
    }
}
