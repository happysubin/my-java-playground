package happysubin.javapractice.lecture.youtube.toby_spring;

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

    static <T extends Comparable<T>> long countGreaterThan(T[] arr, T elem) {
        return Arrays.stream(arr).filter(s -> s.compareTo(elem) > 0).count();
    }

    <S> void print(S t) {
        System.out.println(t.toString());
    }

    public static void main(String[] args) {
        new Hello<String>(); //type argument
        List l1 = new ArrayList<>(); //raw type


        List list = Arrays.asList("1,2");

        List<Integer> l2 = new ArrayList<>();
        //List<Number> l3 = l2; 오류 발생. 공변성과 불공변성.

        new Generics().print(1);
        new Generics().print("111");

        Integer[] arr = new Integer[]{1,2,3,4,5,6,7};
        String[] arr2 = new String[]{"a", "b", "c", "d", "e", "f"};

        System.out.println(countGreaterThan(arr, 3));
        System.out.println(countGreaterThan(arr2, "c"));
     }

}
