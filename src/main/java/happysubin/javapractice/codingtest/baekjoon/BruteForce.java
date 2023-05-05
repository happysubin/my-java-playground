package happysubin.javapractice.codingtest.baekjoon;

import java.io.*;
import java.util.*;

public class Main{
    static boolean[] visited;
    static int[] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int num = Integer.parseInt(str[0]); //배열의 크기
        int goal = Integer.parseInt(str[1]); //목표로 하는 숫자
        arr = new int[num]; //요소들을 담을 배열
        String[] nums = br.readLine().split(" "); //요소들을 넣음.

        for(int i = 0; i < nums.length; i++){
            arr[i] = Integer.parseInt(nums[i]);
        }

        dfs(goal, 0, 0);
        if(goal == 0)bw.write(String.valueOf(answer - 1));
        else bw.write(String.valueOf(answer));
        bw.flush();
    }

    static void dfs(int goal, int num, int i){
        if(i == arr.length){
            if(goal == num) answer++;
            return;
        }

        dfs(goal, num + arr[i], i + 1);
        dfs(goal, num, i + 1);
    }
}