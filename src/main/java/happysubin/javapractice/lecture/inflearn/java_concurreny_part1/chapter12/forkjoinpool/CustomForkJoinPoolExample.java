package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter12.forkjoinpool;

import java.util.concurrent.ForkJoinPool;

public class CustomForkJoinPoolExample {

    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

        CustomRecursiveTask task = new CustomRecursiveTask(array, 0, array.length);



        long result = pool.invoke(task);

        System.out.println("result = " + result);
        System.out.println("pool = " + pool);
        System.out.println("stealing = " + pool.getStealCount());

        pool.shutdown();
    }
}
