package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter03.exam01;

public class MultiThreadSleepExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("1초 후 메시지 출력");
                Thread.sleep(1000);
                System.out.println("스레드 1이 정신차림");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("2초 후 메시지 출력");
                Thread.sleep(2000);
                System.out.println("스레드 2이 정신차림");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.start();
        thread2.start();

        System.out.println("this is main");
    }
}
