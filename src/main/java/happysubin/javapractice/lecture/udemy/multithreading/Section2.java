package happysubin.javapractice.lecture.udemy.multithreading;

public class Section2 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Hello World!");
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            System.out.println("Thread.currentThread().getPriority() = " + Thread.currentThread().getPriority());
            throw new RuntimeException("exception");
        });
        thread.setName("awesome-thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println(Thread.currentThread().getName());
        thread.start();
        System.out.println(Thread.currentThread().getName());

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("t.getName() + e.getMessage() = " + t.getName() + e.getMessage());
            }
        });

        Thread.sleep(3000);

        NewThread newThread = new NewThread();
        newThread.run();
    }


    static class NewThread extends Thread {
        @Override
        public void run() {
            System.out.println("HelloWorld = " + Thread.currentThread().getName());
        }
    }
}
