package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter09;

public class App {

    public static void main(String[] args) {
        P c = new C();
        c.parent();
    }

    static class P {
        void parent() {
            System.out.println("p");
        }
    }

    static class C extends P {
        void parent() {
            System.out.println("c");
        }

    }
}
