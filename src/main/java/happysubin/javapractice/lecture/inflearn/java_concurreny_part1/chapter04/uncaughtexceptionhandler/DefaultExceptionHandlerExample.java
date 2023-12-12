package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter04.uncaughtexceptionhandler;

public class DefaultExceptionHandlerExample {

    public static void main(String[] args) {

        //DefaultUncaughtExceptionHandler는 모든 스레드에 적용됨
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + " 에서 예외 발생" + e);
            }
        });

        Thread thread1 = new Thread(() -> {
            throw new RuntimeException("스레드 1 예외");
        });

        Thread thread2 = new Thread(() -> {
            throw new RuntimeException("스레드 2 예외");
        });

        thread1.start();
        thread2.start();


    }
}
