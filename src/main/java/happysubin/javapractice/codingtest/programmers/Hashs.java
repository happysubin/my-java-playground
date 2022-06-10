package happysubin.javapractice.codingtest.programmers;

import java.util.*;


//완주하지 못한 선수

/*
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


 */

public class Hashs {

    static public boolean solution(String[] phone_book) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String number : phone_book) hashMap.put(number, 0);
        for (String key : hashMap.keySet())
            for (int j = 1; j <= key.length() - 1; j++)
                if (hashMap.containsKey(key.substring(0, j))) return false;
        return true;

    }



    public static void main(String[] args) {
        String[] arr1 = {"119", "97674223", "1195524421"};
        String[] arr2 = {"123", "456", "789"};
        System.out.println(solution(arr1));
    }
}