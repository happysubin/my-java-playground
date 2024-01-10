package happysubin.javapractice.lecture.youtube.toby_spring;

import java.util.List;
import java.util.function.Function;

public class Lambda {

    public static void main(String[] args) {

        //Function

        DataA dataA = new DataA(10);
        DataB dataB = new DataB(11);

    }


    static class Calculator {

        private Calculator() {}

        static <T> Result calculate(List<T> list, Function<T, Result> f) {
//            return list
//                    .stream()
//                    .map()
            return null;
        }

    }

    static class DataA {
        int data;

        public DataA(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }


    }

    static class DataB {
        int data;

        public DataB(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }
    }

    static class Result {

    }

}
