package happysubin.javapractice.codingtest.inflearn;

import java.io.*;

// 선택 정렬

/**
 * public class SortAndSearchChapter {
 *
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *         int len = Integer.parseInt(br.readLine());
 *         String[] s = br.readLine().split(" ");
 *         int[] arr= new int[len];
 *
 *
 *         for (int i = 0; i < len; i++) {
 *             arr[i] = Integer.parseInt(s[i]);
 *         }
 *
 *         for (int i = 0; i < len; i++) {
 *             int idx = i;
 *             for (int j = i + 1; j < len; j++) {
 *                 if(arr[i] > arr[j]) idx = j;
 *             }
 *             int temp = arr[idx];
 *             arr[idx] = arr[i];
 *             arr[i] = temp;
 *         }
 *
 *         for (int i : arr) {
 *             bw.write(i + " ");
 *         }
 *         bw.flush();
 *     }
 * }
 */

//버블 정렬

/**
 * public class SortAndSearchChapter {
 *
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *         int len = Integer.parseInt(br.readLine());
 *         String[] s = br.readLine().split(" ");
 *         int[] arr= new int[len];
 *
 *
 *         for (int i = 0; i < len; i++) {
 *             arr[i] = Integer.parseInt(s[i]);
 *         }
 *
 *         for (int i = 0; i < arr.length - 1; i++) {
 *             for (int j = 0; j < arr.length - i - 1; j++) {
 *                 if(arr[j] > arr[j + 1]){
 *                     int temp = arr[j + 1];
 *                     arr[j + 1] = arr[j];
 *                     arr[j] = temp;
 *                 }
 *             }
 *         }
 *
 *         for (int i : arr) {
 *             bw.write(i +" ");
 *         }
 *         bw.flush();
 *     }
 * }
 */

public class SortAndSearchChapter {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int len = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr= new int[len];


        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        for (int i = 1; i < len; i++) {
            int temp = arr[i], j;
            for (j = i - 1 ; j >= 0 ; j--) {
                if(arr[j] > temp ) arr[j+1] = arr[j];
                else break;
            }
            arr[j + 1] = temp;
        }

        for (int i : arr) {
            bw.write(i +" ");
        }
        bw.flush();
    }
}

