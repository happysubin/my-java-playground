package happysubin.javapractice.codingtest.programmers;

import java.util.*;

public class Hashs {

    static public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for (String s : participant) {
            map.put(s, map.getOrDefault(s,0)+1);
        }

        for (String s : completion) {
            map.put(s, map.getOrDefault(s,0)-1);
        }

        for (String s : map.keySet()) {
            if(map.get(s) !=0){
                answer = s;
            }
        }


        return answer;
    }



    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println( solution(participant,completion));
    }
}
