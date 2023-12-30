package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter12.completablefuture_complete_api;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class IsCompletedExceptionallyAndIsCancelledExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> {
            //eturn 20;
            throw new RuntimeException("error");
        });

//        cf2.cancel(true);

        CompletableFuture<Integer> combinedFuture =
                //예외 발생 시 15를 던진다.
                cf1.thenCombine(cf2.exceptionally(e -> 15), (result1, result2) -> {

                    if (cf2.isCancelled()) {
                        return 0; // 취소 완료
                    }
                    else if (cf2.isCompletedExceptionally()) {
                        return result2 + 1; // 예외 완료
                    }
                    else if(cf2.isDone()) {
                        return result1 + result2; // 정상 완료
                    }
                    else return -1;

                });

        int result = combinedFuture.join(); // 결과 가져오기
        System.out.println("최종 결과: " + result);
    }
}
