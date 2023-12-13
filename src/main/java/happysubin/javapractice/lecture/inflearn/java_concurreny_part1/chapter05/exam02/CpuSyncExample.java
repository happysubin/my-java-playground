package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter05.exam02;

public class CpuSyncExample {
    private static int count = 0;
    private static final int ITERATIONS = 100000;
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < ITERATIONS; i++) {
                synchronized(CpuSyncExample.class) { //lock도 가능
                    count++;
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < ITERATIONS; i++) {
                synchronized(CpuSyncExample.class) { //lock도 가능
                    count++;
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("예상 결과: " + (2 * ITERATIONS));
        System.out.println("실제 결과: " + count);
    }
}
