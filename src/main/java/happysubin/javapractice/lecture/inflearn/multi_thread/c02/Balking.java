package happysubin.javapractice.lecture.inflearn.multi_thread.c02;


public class Balking {

    private static boolean shouldStop = false;
    private static Object lockObj = new Object();
    private static String message = "";
    private static boolean changed = false;

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

        thread1.join();
        thread2.join();

        System.out.println("All Done");
    }

    private static Runnable doClient() { // 요청을 넣는다.
        return () -> {
            while (!shouldStop) {
                synchronized (lockObj) {
                    String oldMessage = message;
                    message = String.valueOf(System.currentTimeMillis());
                    changed = true;
                    System.out.println(Thread.currentThread().getName() + " : " + oldMessage + " -> " + message);
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
                synchronized (lockObj) {
                    if (changed)
                    {
                        System.out.println(Thread.currentThread().getName() + " : " + message);
                        changed = false;
                    }
                    else { // 뭐 별도의 작업이 가능
                        System.out.println(Thread.currentThread().getName() + " : " + "No Message");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
    }
}
