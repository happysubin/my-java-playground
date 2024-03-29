package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter06.mutex;

public class Mutex {

    private boolean lock = false;

    public synchronized void acquired() {
        while(lock) {
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock = true;
    }

    public synchronized void release() {
        this.lock = false;
        this.notify();
    }
}
