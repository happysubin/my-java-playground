package happysubin.javapractice.lecture.inflearn.multi_thread.c02;


import java.util.ArrayList;
import java.util.List;

public class ThreadPerMessage {

    public void startUp() {
        System.out.println("Process Start!");

        List<Thread> threads = new ArrayList<>();

        Thread thread1 = new Thread(() -> {
            doWork("Send email");
        });
        thread1.setName("Brown");
        thread1.start();

        Thread thread2 = new Thread(() -> {
            doWork("Write DB");
        });
        thread2.setName("Bob");
        thread2.start();

        Thread thread3 = new Thread(() -> {
            doWork("Massive Calculation");
        });
        thread3.setName("Alice");
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All done!");
    }

    private void doWork(String name) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " : " + name);
    }

    public static void main(String[] args) {
        ThreadPerMessage app = new ThreadPerMessage();
        app.startUp();
    }
}

