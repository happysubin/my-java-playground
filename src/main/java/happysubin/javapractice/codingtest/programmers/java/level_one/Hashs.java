package happysubin.javapractice.codingtest.programmers.java.level_one;

import java.util.*;

public class Hashs {

    public int solution(int[] nums) {
        Set set = new HashSet();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int num = nums.length / 2;
        

        if(set.size() > num){
            return num;
        }
        else{
            return set.size();
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2,3};
        Hashs hashs = new Hashs();
        hashs.solution(arr);
    }
}

//완주하지 못한 선수

/**
 */

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(String a : participant){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        String answer = "";
        for(String a : completion){
            Integer cnt = map.get(a);
            if(cnt >= 1){
                map.put(a, cnt - 1);
            }
        }

        for(String a : participant){
            if(map.get(a) > 0 ) answer = a;
        }


        return answer;
    }
}
