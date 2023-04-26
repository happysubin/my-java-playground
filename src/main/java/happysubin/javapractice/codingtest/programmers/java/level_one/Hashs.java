package happysubin.javapractice.codingtest.programmers.java.level_one;

import java.util.HashSet;
import java.util.Set;

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
