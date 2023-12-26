package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter12.exam02;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Integer result = CompletableFuture.supplyAsync(() -> {
            System.out.println("Service 1 시작");
            System.out.println(Thread.currentThread().getName()); //ForkJoinPool.commonPool-worker-3
            return 1;
        }).thenApplyAsync(result1 -> {
            System.out.println("Service 2 시작");
            System.out.println(Thread.currentThread().getName()); //ForkJoinPool.commonPool-worker-5
            return result1 + 2;
        }).thenApplyAsync(result2 -> {
            System.out.println("Service 3 시작");
            System.out.println(Thread.currentThread().getName());
            return result2 * 3;
        }).thenApplyAsync(result3 -> {
            System.out.println("Service 4 시작");
            System.out.println(Thread.currentThread().getName());
            return result3 - 4;
        }).thenApplyAsync(result4 -> {
            System.out.println("Service 5 시작");
            System.out.println(Thread.currentThread().getName());
            return result4 + 5;
        }).get();

        System.out.println(result);
    }
}
