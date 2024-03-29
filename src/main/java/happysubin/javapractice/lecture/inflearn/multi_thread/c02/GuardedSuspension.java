package happysubin.javapractice.lecture.inflearn.multi_thread.c02;

import java.util.LinkedList;
import java.util.Queue;

public class GuardedSuspension {

    private volatile static boolean shouldStop;
    private static Queue<String> requests = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Process Start");

        Thread thread1 = new Thread(doClient());
        thread1.setName("Client");
        Thread thread2 = new Thread(doServer());
        thread2.setName("Server");

        thread1.start();
        thread2.start();

        System.out.println("Press any key to stop...");

        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        shouldStop = true;

        // thread2가 Wait 상태일 때, 아래 코드가 없으면 종료되지 않음
        synchronized (requests) {
            requests.notifyAll();
        }

        thread1.join();
        thread2.join();

        System.out.println("All Done");
    }

    private static Runnable doClient() { // 요청을 넣는다.
        return () -> {
            while (!shouldStop) {
                synchronized (requests) {
                    String request = String.valueOf(System.currentTimeMillis());
                    requests.add(request);
                    requests.notifyAll(); // 모든 스레드를 깨운다
                    System.out.println(Thread.currentThread().getName() + " : " + request);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }


    private static Runnable doServer() { //요청 처리
        return () -> {
            while (!shouldStop) {
                synchronized (requests) {
                    if (!requests.isEmpty()) {
                        String request = requests.poll();
                        System.out.println(Thread.currentThread().getName() + " : " + request);
                    }
                    else {
                        System.out.println(Thread.currentThread().getName() + " : Wait");
                        try {
                            requests.wait(); // 일 없으니까 쉴래요. 별도의 작업 불가능
                            System.out.println(Thread.currentThread().getName() + " : Awake");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
    }
}
