package happysubin.javapractice.javastudy.zombie;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        new Producer().start();
        new Producer().start();
        new Producer().start();
        new Producer().start();
    }
}
