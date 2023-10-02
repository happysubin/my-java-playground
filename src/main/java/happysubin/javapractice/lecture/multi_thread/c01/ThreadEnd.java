package happysubin.javapractice.lecture.multi_thread.c01;

public class ThreadEnd {

    private volatile static boolean toggle1 = false;
    private static boolean toggle2 = false; // 이 경우는 무한루프가 종료되지 않는다. cpu 캐시를 읽기 때문인 것 같다.

    public static void main(String[] args) throws InterruptedException {
        //useVolatileKeywordExample();
        useContextSwitchingExample();
    }

    private static void useVolatileKeywordExample() throws InterruptedException {

        // start, join이 중요
        System.out.println("start");

        Thread thread1 = new Thread(runnable1());

        //시작
        thread1.start(); //컨텍스트 스위칭 발생

        Thread.sleep(1000);

        toggle1 = true;
        //종료 대기
        thread1.join(); //쓰레드가 종료될때까지 대기(Blocking)한다

        System.out.println("all done");
    }

    private static Runnable runnable1() {
        return () -> {
            toggle1 = false;
            while(!toggle1) {
                //toggle = true;
                try {
                    //Thread.sleep(1000); //이건 컨텍스트 스위칭이 발생해서 cpu 캐시를 지우므로, volatile 키워드를 사용하지 않아도 된다. 놀랍다.
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private static void useContextSwitchingExample() throws InterruptedException {
        // start, join이 중요
        System.out.println("start");

        Thread thread1 = new Thread(runnable2());

        //시작
        thread1.start(); //컨텍스트 스위칭 발생

        Thread.sleep(1000);

        toggle2 = true;
        //종료 대기
        thread1.join(); //쓰레드가 종료될때까지 대기(Blocking)한다

        System.out.println("all done");
    }

    private static Runnable runnable2() {
        return () -> {
            toggle2 = false;
            while(!toggle2) {
                //toggle = true;
                try {
                    Thread.sleep(1000); //이건 컨텍스트 스위칭이 발생해서 cpu 캐시를 지우므로, volatile 키워드를 사용하지 않아도 된다. 놀랍다.
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
