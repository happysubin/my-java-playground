package happysubin.javapractice.codingtest.inflearn;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 두 배열 합치기

/**
 * public class TwoPointers {
 *
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *
 *         int num1 = Integer.parseInt(br.readLine());
 *         String[] arr1 = br.readLine().split(" ");
 *         int num2 = Integer.parseInt(br.readLine());
 *         String[] arr2 = br.readLine().split(" ");
 *         int[] answer = new int [num1 + num2];
 *
 *         int lt = 0;
 *         int rt = 0;
 *         int i = 0;
 *         while(lt < num1 && rt < num2 ){
 *             if(Integer.parseInt(arr1[lt]) < Integer.parseInt(arr2[rt])){
 *                 answer[i++] = Integer.parseInt(arr1[lt++]);
 *             }
 *
 *             else {
 *                 answer[i++] = Integer.parseInt(arr2[rt++]);
 *             }
 *         }
 *
 *         for (int j = rt; j < num2; j++) {
 *             answer[i++] = Integer.parseInt(arr2[j]);
 *         }
 *
 *         for (int j = lt; j < num1; j++) {
 *             answer[i++] = Integer.parseInt(arr1[j]);
 *         }
 *
 *
 *         for (int i1 : answer) {
 *             bw.write(i1 + " ");
 *         }
 *         bw.flush();
 *     }
 * }
 */


//공통원소 구하기

/**
 * public static void main(String[] args) throws IOException {
 *         Scanner sc = new Scanner(System.in);
 *         int num1 = sc.nextInt();
 *         int[] arr1 = new int[num1];
 *         for (int i = 0; i < num1; i++) {
 *             arr1[i] = sc.nextInt();
 *         }
 *         int num2 = sc.nextInt();
 *         int[] arr2 = new int[num2];
 *         for (int i = 0; i < num2; i++) {
 *             arr2[i] = sc.nextInt();
 *         }
 *
 *         Arrays.sort(arr1);
 *         Arrays.sort(arr2);
 *
 *         List<Integer> answer = new ArrayList<>();
 *
 *         int lt = 0;
 *         int rt = 0;
 *         while(lt < num1 && rt < num2){
 *             if(arr1[lt] < arr2[rt]){
 *                 lt++;
 *             }
 *             else if(arr1[lt] > arr2[rt]){
 *                 rt++;
 *             }
 *
 *             else{
 *                 answer.add(arr1[lt]);
 *                 lt++;
 *                 rt++;
 *             }
 *         }
 *
 *         for (Integer integer : answer) {
 *             System.out.print(integer + " ");
 *         }
 *     }
 */

// 연속 부분 수열

/**
 * public class TwoPointersChapter {
 *
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *
 *         String[] split = br.readLine().split(" ");
 *         int len = Integer.parseInt(split[0]);
 *         int window = Integer.parseInt(split[1]);
 *
 *         String[] s = br.readLine().split(" ");
 *         int[] arr = new int[len];
 *
 *         for (int i = 0; i < len; i++) {
 *             arr[i] = Integer.parseInt(s[i]);
 *         }
 *
 *         int sum = 0;
 *         for (int i = 0; i < window; i++) {
 *             sum += arr[i];
 *         }
 *         int max = sum;
 *         int j = 0;
 *         for (int i = window; i < len; i++) {
 *             sum += + arr[i] - arr[j++];
 *             if(max < sum){
 *                 max = sum;
 *             }
 *         }
 *
 *         bw.write(max + "\n");
 *         bw.flush();
 *     }
 * }
 */

//연속 부분 수열

/**
 * public class TwoPointersChapter {
 *
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *
 *         String[] split = br.readLine().split(" ");
 *         int len = Integer.parseInt(split[0]);
 *         int goal = Integer.parseInt(split[1]);
 *         String[] str = br.readLine().split(" ");
 *         int[] arr = new int[str.length];
 *
 *         for (int i = 0; i < str.length; i++) {
 *             arr[i] = Integer.parseInt(str[i]);
 *         }
 *
 *         int lt = 0, rt = 0;
 *         int sum = 0;
 *         int answer = 0;
 *         while (rt < len){
 *             if(sum < goal){
 *                 sum += arr[rt];
 *                 rt++;
 *             }
 *
 *             else if(sum > goal){
 *                 sum -= arr[lt];
 *                 lt++;
 *             }
 *
 *             if(sum == goal){
 *                 answer++;
 *                 sum -= arr[lt];
 *                 lt++;
 *             }
 *         }
 *
 *         bw.write(answer + "\n");
 *         bw.flush();
 *     }
 * }
 */

//연속된 자연수의 합

public class TwoPointersChapter {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int goal = Integer.parseInt(br.readLine());
        int[] arr = new int[goal];
        for (int i = 1; i < goal; i++) {
            arr[i] = i;
        }

        int lt = 1, rt = 1;
        int sum = 0;
        int answer = 0;
        while(arr[rt] < goal - 1 ) {
            if (sum < goal) {
                sum += arr[rt];
                rt++;
            }
            else if (sum > goal) {
                sum -= arr[lt];
                lt++;
            }

            if (sum == goal) {
                answer++;
                sum -= arr[lt]; //0에서 중복이 발생했었음.
                lt++;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }
}
