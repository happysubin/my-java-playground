package happysubin.javapractice.lecture.multi_thread;

public class ThreadEnd {

    //private volatile static boolean toggle = false;
    private  static boolean toggle = false; // 이 경우는 무한루프가 종료되지 않는다. cpu 캐시를 읽기 때문인 것 같다.

    public static void main(String[] args) throws InterruptedException {

        // start, join이 중요
        System.out.println("start");

        Thread thread1 = new Thread(runnable());

        //시작
        thread1.start(); //컨텍스트 스위칭 발생

        Thread.sleep(1000);

        toggle = true;
        //종료 대기
        thread1.join(); //쓰레드가 종료될때까지 대기(Blocking)한다

        System.out.println("all done");
    }

    private static Runnable runnable() {
        return () -> {
            toggle = false;
            while(!toggle) {
                //toggle = true;
                try {
                    //Thread.sleep(1000); //이건 컨텍스트 스위칭이 발생해서 cpu 캐시를 지우므로, volatile 키워드를 사용하지 않아도 된다. 놀랍다.
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
