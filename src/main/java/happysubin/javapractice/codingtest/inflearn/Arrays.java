package happysubin.javapractice.codingtest.inflearn;

import java.io.*;
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

public class Arrays {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        int cnt = 2;

        while( Math.pow(cnt, 2) < num){
            cnt++;
        }

        cnt --;

        int[] arr = new int[num + 1];

        for (int i = 2; i < cnt; i++) {
            for (int j = i + i; j <= num; j += i) {
                arr[j] = 1;
            }
        }

        int answer = 0;
        for (int i = 2; i < arr.length - 1; i++) {
            if(arr[i] == 0) ++answer;
        }

        bw.write(answer + " ");
        bw.flush();
    }
}