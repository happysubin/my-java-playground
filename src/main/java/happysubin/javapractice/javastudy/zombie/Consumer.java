package happysubin.javapractice.javastudy.zombie;

import java.util.logging.Logger;

public class Consumer extends Thread {

    private Logger log = Logger.getLogger(Consumer.class.getName());

    @Override
    public void run() {
        while(App.list.size() > 0) {
            int x = App.list.get(0);
            App.list.remove(0);
            log.info("Consumer " + Thread.currentThread().getName() + " removed value " + x);
        }
    }
}
