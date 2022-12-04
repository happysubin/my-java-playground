package happysubin.javapractice.codingtest.inflearn;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

//큰 수 출력하기


/**
 * public class Arrays {
 *
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *
 *         int num = Integer.parseInt(br.readLine());
 *         String[] arr = br.readLine().split(" ");
 *         String answer = arr[0];
 *         for (int i = 1; i < num; i++) {
 *             if(Integer.parseInt(arr[i - 1]) < Integer.parseInt(arr[i])){
 *                 answer = answer + " " +  arr[i];
 *             }
 *         }
 *
 *         bw.write(answer);
 *         bw.flush();
 *     }
 * }
 */

//보이는 학생

/**
 * public class Arrays {
 *
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *
 *         int num = Integer.parseInt(br.readLine());
 *         String[] arr = br.readLine().split(" ");
 *         int answer = 1;
 *         int max = Integer.parseInt(arr[0]);
 *         for (int i = 1; i < num; i++) {
 *             if(max < Integer.parseInt(arr[i])){
 *                 max = Integer.parseInt(arr[i]);
 *                 answer++;
 *             }
 *         }
 *
 *         bw.write(answer + "\n");
 *         bw.flush();
 *     }
 * }
 */

//가위바위보

/**
 * public class Arrays {
 *
 *     public static void main(String[] args) throws IOException {
 *
 *         Scanner sc = new Scanner(System.in);
 *
 *         int num = sc.nextInt();
 *
 *         int[][] arr = new int[2][num];
 *         for (int i = 0; i < 2; i++) {
 *             for (int j = 0; j < num; j++) {
 *                 arr[i][j] = sc.nextInt();
 *             }
 *         }
 *
 *         for (int i = 0; i < num; i++) {
 *             if((arr[0][i] == 1 & arr[1][i] == 3) | (arr[0][i] == 2 & arr[1][i] == 1) | (arr[0][i] == 3 & arr[1][i] == 2)){
 *                 System.out.println("A");
 *             }
 *             else if((arr[1][i] == 1 & arr[0][i] == 3) | (arr[1][i] == 2 & arr[0][i] == 1) | (arr[1][i] == 3 & arr[0][i] == 2)){
 *                 System.out.println("B");
 *             }
 *             else {
 *                 System.out.println("D");
 *             }
 *         }
 *     }
 * }
 */

//가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.





//피보나치 수열

/**
 * public class Arrays {
 *
 *     public static void main(String[] args) throws IOException {
 *
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *
 *         int len = Integer.parseInt(br.readLine());
 *
 *         int[] arr = new int[len];
 *
 *         arr[0] = 1;
 *         arr[1] = 1;
 *         for (int i = 2; i < len; i++) {
 *             arr[i] = arr[i - 1] + arr[i - 2];
 *         }
 *
 *         for (int i : arr) {
 *             bw.write(i + " ");
 *         }
 *
 *         bw.flush();
 *
 *     }
 * }
 */


//에라토스테네스의 체

/**
 * public class Arrays {
 *
 *     public static void main(String[] args) throws IOException {
 *
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *         int num = Integer.parseInt(br.readLine());
 *
 *         int cnt = 2;
 *
 *         while( Math.pow(cnt, 2) < num){
 *             cnt++;
 *         }
 *
 *         cnt --;
 *
 *         int[] arr = new int[num + 1];
 *
 *         for (int i = 2; i < cnt; i++) {
 *             for (int j = i + i; j <= num; j += i) {
 *                 arr[j] = 1;
 *             }
 *         }
 *
 *         int answer = 0;
 *         for (int i = 2; i < arr.length - 1; i++) {
 *             if(arr[i] == 0) ++answer;
 *         }
 *
 *         bw.write(answer + " ");
 *         bw.flush();
 *     }
 * }
 */


// 뒤집은 소수


/**
 * public class Arrays {
 *
 *     public static void main(String[] args) throws IOException {
 *
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *
 *         int num = Integer.parseInt(br.readLine());
 *         String[] arr = br.readLine().split(" ");
 *         int[] nums = new int[arr.length];
 *
 *         for (int i = 0; i < arr.length; i++) {
 *             StringBuffer sf = new StringBuffer(arr[i]);
 *             nums[i] = Integer.parseInt(sf.reverse().toString());
 *         }
 *
 *         for (int i = 0; i < nums.length; i++) {
 *             for (int j = 2; j <= nums[i]; j++) {
 *                 if(nums[i] % j == 0 & j != nums[i]){
 *                     break;
 *                 }
 *                 else if(nums[i] == j ){
 *                      bw.write(nums[i] + " ");
 *                 }
 *             }
 *         }
 *         bw.flush();
 *     }
 * }
 */

//점수 계산

/**
 * public class Arrays {
 *
 *     public static void main(String[] args) throws IOException {
 *
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *
 *         int num = Integer.parseInt(br.readLine());
 *         String s = br.readLine() + " 0";
 *         String[] arr2 = s.split(" ");
 *
 *         int score = 0;
 *         int answer = 0 ;
 *         for (int i = 0; i < arr2.length - 1; i++) {
 *             if(arr2[i].equals("1")){
 *                 ++score;
 *                 answer += score;
 *             }
 *             else{
 *                 score = 0;
 *             }
 *         }
 *         bw.write(answer + "\n");
 *         bw.flush();
 *     }
 * }
 */


//등수 구하기

/**
 * public class Arrays {
 *
 *     public static void main(String[] args) throws IOException {
 *
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *
 *         int num = Integer.parseInt(br.readLine());
 *         String[] split = br.readLine().split(" ");
 *
 *         int[] arr = new int[split.length];
 *
 *         int rank = 1;
 *         for (int i = 0; i < split.length; i++) {
 *             for (int j = 0; j < split.length; j++) {
 *                 if(Integer.parseInt(split[i]) < Integer.parseInt(split[j])){
 *                     rank++;
 *                 }
 *             }
 *             arr[i] = rank;
 *             rank = 1 ;
 *         }
 *
 *         for (int i : arr) {
 *             bw.write(i + " ");
 *         }
 *         bw.flush();
 *     }
 * }
 */

//격자판 최대합

/**
 * public class Arrays {
 *
 *     public static void main(String[] args) throws IOException {
 *         Scanner sc = new Scanner(System.in);
 *         int num = sc.nextInt();
 *         int[][] arr = new int[num][num];
 *
 *         for (int i = 0; i < num; i++) {
 *             for (int j = 0; j < num; j++) {
 *                 arr[i][j] = sc.nextInt();
 *             }
 *         }
 *
 *         int max = 0;
 *         int score1 = 0;
 *         int score2 = 0;
 *         for (int i = 0; i < num; i++) {
 *             for (int j = 0; j < num; j++) {
 *                 score1 += arr[i][j];
 *                 score2 += arr[j][i];
 *             }
 *             max = Math.max(score1, max);
 *             max = Math.max(score2, max);
 *             score1 = 0;
 *             score2 = 0;
 *         }
 *
 *
 *         for (int i = 0; i < num; i++) {
 *             score1 += arr[i][i];
 *             score2 += arr[num - 1 -i][i];
 *         }
 *         max = Math.max(score1, max);
 *         max = Math.max(score2, max);
 *
 *
 *         System.out.println(max);
 *     }
 * }
 */


//봉우리

/**
 * public class Arrays {
 *
 *     public static void main(String[] args) throws IOException {
 *         Scanner sc = new Scanner(System.in);
 *         int num = sc.nextInt();
 *         int[][] arr = new int[num + 2][num + 2];
 *
 *         for (int i = 1; i <= num; i++) {
 *             for (int j = 1; j <= num; j++) {
 *                 arr[i][j] = sc.nextInt();
 *             }
 *         }
 *
 *
 *         int answer = 0;
 *         for (int i = 1; i <= num; i++) {
 *              for (int j = 1; j <= num; j++) {
 *                  int point = arr[i][j];
 *                  if((point > arr[i -1][j] ) & (point > arr[i][j -1]) & (point > arr[i + 1][j]) & (point > arr[i][j + 1])) answer++;
 *             }
 *         }
 *         System.out.println(answer);
 *     }
 * }
 */

//임시 반장 정하기

/**
 * public class Arrays {
 *
 *     public static void main(String[] args) {
 *         Scanner sc = new Scanner(System.in);
 *         int num = sc.nextInt();
 *         int[][] arr = new int[num][5];
 *         int[][] students = new int[num][num];
 *
 *         for (int i = 0; i < num; i++) {
 *             for (int j = 0; j < 5; j++) {
 *                 arr[i][j] = sc.nextInt();
 *             }
 *         }
 *
 *
 *         for (int i = 0; i < 5; i++) {
 *             for (int j = 0; j < num; j++) {
 *                 int standard = arr[j][i];
 *                 for (int k = 0; k < num; k++) {
 *                     if (standard == arr[k][i]) students[j][k] = 1;
 *                 }
 *             }
 *         }
 *
 *         int idx = 0;
 *         int max = 0;
 *         int score = 0;
 *         for (int i = 0; i < num; i++) {
 *             for (int j = 0; j < num; j++) {
 *                 if(students[i][j] == 1){
 *                     score++;
 *                 }
 *             }
 *             if(max < score){
 *                 idx = i + 1;
 *                 max = score;
 *             }
 *             score = 0;
 *         }
 *         System.out.println(idx);
 *     }
 * }
 */

 public class ArraysChapter {

     public static void main(String[] args) throws IOException {

         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

         String[] arr = br.readLine().split("");
         String[] word = br.readLine().split("");
         int answer = arr.length - word.length + 1;

         Map<String, Integer> standard = new HashMap<>();
         for (String s : word) {
             standard.put(s, standard.getOrDefault(s, 0) + 1);
         }

         Map<String, Integer> map = new HashMap<>();
         //처음 윈도우 슬라이딩을 위한 설정
         for (int i = 0; i < word.length; i++) {
             map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
         }

         for (String s : map.keySet()) {
             if(map.get(s) != standard.get(s)){
                 answer--;
                 break;
             }
         }
         int j = 0;
         for (int i = word.length; i < arr.length; i++) {

             if(map.get(arr[j]) <= 1){ //이 부분을 놓쳐서 첫 시도에서 틀림
                 map.remove(arr[j]);
                 j++;
             }
             else{
                 map.put(arr[j], map.get(arr[j]) - 1 );
                 j++;
             }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
             for (String s : map.keySet()) {
                 if(map.get(s) != standard.get(s)) {
                     answer--;
                     break;
                 }
             }
         }
         bw.write(answer + "\n");
         bw.flush();
     }
 }