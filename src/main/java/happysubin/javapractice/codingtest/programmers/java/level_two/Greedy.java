package happysubin.javapractice.codingtest.programmers.java.level_two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Greedy {

    public String solution(String number, int k) {

        String[] temp = number.split("");
        Arrays.sort(temp);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(temp[i]);
        }


        String[] arr = number.split("");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {

            if(list.size()> 0 && list.contains(arr[i])){
                list.remove(arr[i]);
            }
            else{
                sb.append(arr[i]);
            }
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "JEROEN";
        Greedy greedy = new Greedy();
        String solution = greedy.solution("1231234", 3);
        System.out.println(solution);
    }
}
