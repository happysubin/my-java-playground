package happysubin.javapractice.lecture.inflearn.multi_thread.c01;

public class ThreadControl {
    public static void main(String[] args) throws InterruptedException { // 진입점, entry point. main method에서 실행된다.

        // start, join이 중요
        Thread thread1 = new Thread(runnable("start 1", "finish 1"));
        Thread thread2 = new Thread(runnable("start 2", "finish 2"));

        System.out.println("start");

        //시작
        thread1.start();
        thread2.start();

        //종료 대기
        thread1.join(); //쓰레드가 종료될때까지 대기(Blocking)한다
        thread2.join();

        System.out.println("all done");
    }

    private static Runnable runnable(String x, String x1) {
        return () -> {
            try {
                System.out.println(x);
                Thread.sleep(1000);
                //System.out.println("Thread.currentThread() = " + Thread.currentThread());
                System.out.println(x1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}

/**
 * 함수를 실행하고 모든 코드가 완료된 후 리턴되면 블럭킹
 * 실행한 함수의 코드가 완료되지 않고 리턴되면 논 블럭킹
 * 논블럭킹 함수를 실행하고 완료됨을 알 수 있는 방법은 폴링과 이벤트
 */