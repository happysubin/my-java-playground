package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter12.completablefuture_operate_api;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ThenAcceptExample {

    public static void main(String[] args) {

        MyService myService = new MyService();
        CompletableFuture.supplyAsync(() -> {
                    System.out.println("thread1:" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return 40;
                })
                /**
                 * thenAcceptAsync()는 이전 작업 결과와 상관없이 무조건 풀 스레드에서 비동기 처리된다. 풀 스레드는 이전과 동일한 스레드 혹은 새롭게 생성된 스레드가 될 수 있다
                 * thenAccept() 는 이전 작업 결과가 완료 되었다면 메인 스레드에서 동기 처리되고 그렇지 않으면 이전과  동일한 스레드에서  비동기 처리된다
                 */
                .thenAccept(result -> {
                    System.out.println("thread2:" + Thread.currentThread().getName());
                    System.out.println("결과: " + result);
                    List<Integer> r = myService.getData1();
                    r.forEach(System.out::println);

                }).thenAcceptAsync(result -> {
                    System.out.println("thread3:" + Thread.currentThread().getName());
                    System.out.println("결과: " + result);
                    List<Integer> r = myService.getData2();
                    r.forEach(System.out::println);

                }).join();
    }

    static class MyService {

        public List<Integer> getData1(){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Arrays.asList(1,2,3);
        }

        public List<Integer> getData2(){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Arrays.asList(4,5,6);
        }
    }
}
