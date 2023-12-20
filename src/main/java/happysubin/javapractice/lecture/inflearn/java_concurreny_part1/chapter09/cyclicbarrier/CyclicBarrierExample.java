package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter09.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    static int[] parallelSum = new int[2];

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numThreads = 2;
        CyclicBarrier barrier = new CyclicBarrier(numThreads, new BarrierAction(parallelSum));

        for (int i = 0; i < numThreads; i++) {
            new Thread(new Worker(i, numbers, barrier, parallelSum)).start();
        }
    }
}

class BarrierAction implements Runnable {
    private final int[] parallelSum;

    public BarrierAction(int[] parallelSum) {
        this.parallelSum = parallelSum;
    }

    public void run() { // 모든 스레드가 장벽에 모인 시점에 실행된다
        int finalSum = 0;
        for (int sum : parallelSum) {
            finalSum += sum;
        }
        System.out.println("Final Sum: " + finalSum);
    }
}

class Worker implements Runnable {
    private final int id;
    private final int[] numbers;
    private final CyclicBarrier barrier;
    private final int[] parallelSum;

    public Worker(int id, int[] numbers, CyclicBarrier barrier, int[] parallelSum) {
        this.id = id;
        this.numbers = numbers;
        this.barrier = barrier;
        this.parallelSum = parallelSum;
    }

    public void run() {
        int start = id * (numbers.length / 2);
        int end = (id + 1) * (numbers.length / 2);
        int sum = 0;
        System.out.println(start + " " + end);
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        parallelSum[id] = sum; // //각 스레드는 병렬로 데이터를 나누어 연산한다

        try {
            barrier.await(); // 모든 스레드가 합산을 완료할 때까지 대기한다
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

/**
 * https://www.baeldung.com/java-cyclicbarrier-countdownlatch
 * CyclicBarrier는 스레드 수를 유지, CountDownLatch는 작업 수를 유지
 */