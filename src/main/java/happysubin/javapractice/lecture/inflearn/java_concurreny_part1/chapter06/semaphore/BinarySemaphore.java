package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter06.semaphore;

public class BinarySemaphore implements CommonSemaphore {

    private int signal = 1;

    @Override
    public synchronized void acquired() {
        while (this.signal == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.signal = 0;

    }

    @Override
    public void release() {
        this.signal = 1;
        this.notify();
    }
}