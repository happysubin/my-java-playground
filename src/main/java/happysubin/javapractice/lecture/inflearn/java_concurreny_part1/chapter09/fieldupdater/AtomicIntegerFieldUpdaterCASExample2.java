package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter09.fieldupdater;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicIntegerFieldUpdaterCASExample2 {
    private static AtomicReferenceFieldUpdater<AtomicIntegerFieldUpdaterCASExample2, String> messageUpdater =
            AtomicReferenceFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterCASExample2.class, String.class, "message");

    private volatile String message = "";

    public void doSomething() {
        if (messageUpdater.compareAndSet(this, "", "Hello World!")) {
            for (int i = 0; i < 10; i++) {
                System.out.println(messageUpdater.get(this)); //헬로 월드 10번 출력
            }
            messageUpdater.set(this, "");
        } else {
            System.out.println("This thread will not enter the loop"); //1번 출력
        }
    }

    public static void main(String[] args) {
        AtomicIntegerFieldUpdaterCASExample2 example1 = new AtomicIntegerFieldUpdaterCASExample2();
        new Thread(example1::doSomething).start();
        new Thread(example1::doSomething).start();
    }
}