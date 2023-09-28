package happysubin.javapractice.lecture.toby_spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics {

    /**
     * 타입 파라미터 추가
     * @param <T>
     */
    static class Hello<T> { //type parameter
        T t;
        T method(T val) {
            return null;
        }
    }

    public static void main(String[] args) {
        new Hello<String>(); //type argument


        List list = Arrays.asList("1,2");
        list.add(1);
    }

}
