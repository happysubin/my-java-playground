package happysubin.javapractice.codingtest.programmers;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] !=min) list.add(arr[i]);
        }

        if(list.size() == 0){
            return new int[]{-1};
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,1};

        solution(arr);

    }
}
