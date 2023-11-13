package happysubin.javapractice.lecture.inflearn.multi_thread.c02;


public class ThreadSpecificStorage {


    /**
     * 쓰레드 로컬 사용.
     */


    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public void startUp() {
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                int value = threadLocal.get();
                threadLocal.set(value + 1);
                System.out.println("Thread A : " + threadLocal.get());
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                int value = threadLocal.get();
                threadLocal.set(value + 1);
                System.out.println("Thread B : " + threadLocal.get());
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();

        System.out.println("Press any key to exit...");

        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadSpecificStorage app = new ThreadSpecificStorage();
        app.startUp();
    }
}
