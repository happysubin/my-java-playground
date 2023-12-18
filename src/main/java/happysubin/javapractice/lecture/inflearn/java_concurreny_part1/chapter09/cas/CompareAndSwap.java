package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter09.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CompareAndSwap {

    static class Atomic{
        volatile int counter = 0;
        public void lock() {
            while(true) {
                int expected = this.counter;
                int newValue = expected + 1;
                if(compareAndSwap(expected, newValue)) return;
            }
        }
        public synchronized boolean compareAndSwap(int expectedValue, int newValue) {
            int oldValue = this.counter;
            if(oldValue == expectedValue) {
                this.counter = newValue;
                return true;
            }
            return false;
        }
    }

    static class NonAtomic{
        int counter = 0;
        AtomicInteger a = new AtomicInteger();
        public void lock() {
            for (int i = 0; i < 100; i++) {
                counter += 1;
                a.getAndIncrement();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Atomic a = new Atomic();
        NonAtomic n = new NonAtomic();

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    a.lock();
                }
                n.lock();
            }).start();

            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    a.lock();
                }
                n.lock();
            }).start();
        }

        Thread.sleep(10000);
        System.out.println(a.counter); //2000000
        System.out.println(n.counter); //199858
        System.out.println(n.a.get()); //200000
    }
}
