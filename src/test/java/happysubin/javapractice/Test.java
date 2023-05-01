package happysubin.javapractice;

import java.util.HashMap;

public class Test {

    @org.junit.jupiter.api.Test
    void test(){
        System.out.println("32".compareTo("3")); //크니까 1이 나옴?
        System.out.println("30".compareTo("3")); // 1
        System.out.println("3".compareTo("30")); // -1
        System.out.println("31".compareTo("3")); // 1
        System.out.println("60".compareTo("63")); // -3
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    }
}

/**
 * 기준 값과 비교대상이 동일한 값일 경우 0
 * 기준 값이 비교대상 보다 작은 경우 -1
 * 기준 값이 비교대상 보다 큰 경우 1
 */
