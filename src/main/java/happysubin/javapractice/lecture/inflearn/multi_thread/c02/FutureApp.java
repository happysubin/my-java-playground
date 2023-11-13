package happysubin.javapractice.lecture.inflearn.multi_thread.c02;

public class FutureApp {


    static class Future {

        private volatile String result = null;

        public String getResult()
        {
            while (result == null) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return result != null ? result : "";
        }

        public void startup(Runnable action) {
            Thread thread = new Thread(() -> {
                action.run();
                result = "Done";
            });
            thread.start();
        }
    }

    public void startup() {
        System.out.println("Process Start!");

        Future future1 = new Future();
        future1.startup(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Future future2 = new Future();
        future2.startup(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Future future3 = new Future();
        future3.startup(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("뭔가를 더 할수 있음 Start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("뭔가를 더 할수 있음 Finish");

        System.out.println(future1.getResult());
        System.out.println(future2.getResult());
        System.out.println(future3.getResult());
    }

    public static void main(String[] args) {
        FutureApp app = new FutureApp();
        app.startup();
    }
}
