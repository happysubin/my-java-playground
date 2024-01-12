package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter06;

public class App {

    public static void main(String[] args) {
        MaxCounter counter = new MaxCounter(3);
        counter.increment();
        counter.increment();
        counter.increment();
        counter.increment();
        int count = counter.getCount();
        System.out.println(count);
    }
}
