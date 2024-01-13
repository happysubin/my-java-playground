package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter07;

import java.util.Arrays;

public class MathArrayUtils {

    private MathArrayUtils() {};
    static int sum(int[] array) {
        return Arrays.stream(array).sum();
    }

    static int average(int[] array) {
        return Arrays.stream(array).sum() / array.length;
    }

    static int min (int[] array) {
        return Arrays
                .stream(array)
                .min()
                .orElseThrow(() -> new IllegalArgumentException("Array is empty"));
    }

    static int max (int[] array) {
        return Arrays
                .stream(array)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("Array is empty"));
    }

}