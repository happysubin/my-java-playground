package happysubin.javapractice.lecture.multi_thread.c02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;


public class ProducerAndConsumer {

    private volatile boolean shouldStop = false;

    private ConcurrentLinkedQueue<String> requests = new ConcurrentLinkedQueue<>();

    public void startUp() {
        System.out.println("Process Start!");

        // Thread 오브젝트 만들기
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(this::produce);
            thread.setName("Producer" + i);
            threads.add(thread);
        }

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(this::consume);
            thread.setName("Consumer" + i);
            threads.add(thread);
        }

        // Thread 시작
        for (Thread thread : threads) {
            thread.start();
        }

        System.out.println("Press any key to stop...");

        try {
            System.in.read();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        shouldStop = true;

        // Thread 종료 대기
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All done!");
    }

    private void produce() {
        while (!shouldStop) {
            String request = Long.toString(System.currentTimeMillis());
            requests.add(request);
            System.out.println(Thread.currentThread().getName() + " : " + request);
        }
    }

    private void consume() {
        while (!shouldStop) {
            String request = requests.poll();
            if (request != null) {
                System.out.println(Thread.currentThread().getName() + " : " + request);
            }
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumer app = new ProducerAndConsumer();
        app.startUp();
    }
}
