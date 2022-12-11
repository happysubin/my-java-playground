package happysubin.javapractice.codingtest.inflearn;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

//삽입 정렬

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
 *         for (int i = 1; i < len; i++) {
 *             int temp = arr[i], j;
 *             for (j = i - 1 ; j >= 0 ; j--) {
 *                 if(arr[j] > temp ) arr[j+1] = arr[j]; // 한칸 씩 뒤로 미룬다.
 *                 else break; //정렬이 된 부분 이후로는 더 진행하지 않는다.
 *             }
 *             arr[j + 1] = temp; //반복문을 한 바퀴 더 돌아서  + 1.
 *         }
 *
 *         for (int i : arr) {
 *             bw.write(i +" ");
 *         }
 *         bw.flush();
 *     }
 * }
 */

// LRU

/**
 * public class SortAndSearchChapter {
 *
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *         String[] str = br.readLine().split(" ");
 *         int size = Integer.parseInt(str[0]);
 *         int len = Integer.parseInt(str[1]);
 *
 *         String[] list = br.readLine().split(" ");
 *         int[] arr = new int[len];
 *         int[] answer = new int[size];
 *
 *         for (int i = 0; i < len; i++) {
 *             arr[i] = Integer.parseInt(list[i]);
 *         }
 *
 *         for (int i = 0; i < len; i++) {
 *             boolean has = false;
 *             for (int j = 0; j < size; j++) {
 *                 if(answer[j] == arr[i]){
 *                     for (int k = j - 1; k >= 0 ; k--) {
 *                         answer[k + 1] = answer[k];
 *                     }
 *                     answer[0] = arr[i];
 *                     has = true;
 *                 }
 *             }
 *
 *             if(has == false){
 *                 for (int j = size - 2; j >= 0; j--) {
 *                     answer[j + 1] = answer[j];
 *                 }
 *                 answer[0] = arr[i];
 *             }
 *         }
 *
 *         for (int i : answer) {
 *             bw.write(i + " ");
 *         }
 *
 *
 *         bw.flush();
 *     }
 * }
 */

//중복 확인

/**
 * public class SortAndSearchChapter {
 *
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *         int len = Integer.parseInt(br.readLine());
 *         String[] arr = br.readLine().split(" ");
 *         Map<String, Integer> map = new HashMap<>();
 *         for (String s : arr) {
 *             map.put(s, map.getOrDefault(s, 0) + 1);
 *         }
 *
 *         for (String s : map.keySet()) {
 *             if(map.get(s) > 1){
 *                 bw.write("D");
 *                 bw.flush();;
 *                 return ;
 *             }
 *         }
 *
 *         bw.write("U");
 *         bw.flush();;
 *         return ;
 *
 *     }
 * }
 */

//장난 꾸러기

public class SortAndSearchChapter {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int len = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split(" ");
        int[] intArr = new int[len];

        for (int i = 0; i < len; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }

        int[] clone = intArr.clone();
        Arrays.sort(intArr);


        int[] answer = new int[2];
        int j = 0;
        for (int i = 0; i < len; i++) {
            if(clone[i] != intArr[i]) answer[j++] = i + 1;
        }


        for (int i : answer) {
            bw.write(i + " ");
        }
        bw.flush();;
    }
}

