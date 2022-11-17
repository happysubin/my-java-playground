package happysubin.javapractice.codingtest.programmers.level_one;

/**
 * 가운데 글자 구하기
 * public class Practice {
 *
 *
 *     public String solution(String s) {
 *         String answer = "";
 *
 *         if(s.length() % 2 != 0){
 *             return s.substring(s.length() / 2, s.length() / 2 + 1);
 *         }
 *
 *         return s.substring(s.length() / 2 - 1, s.length() / 2 + 1 );
 *     }
 *
 *     public static void main(String[] args) {
 *         String s = "abcde";
 *         Practice practice = new Practice();
 *         String solution = practice.solution(s);
 *         System.out.println("solution = " + solution);
 *     }
 * }
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 2016년
 * public class Practice{
 *
 *     public String solution(int a, int b) {
 *         int month = a - 1;
 *         int date = b;
 *         int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
 *         String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
 *
 *         for (int i = 0; i < month; i++) {
 *             date += months[i];
 *         }
 *
 *         return day[date  % 7];
 *     }
 *
 *     public static void main(String[] args) {
 *         Practice practice = new Practice();
 *         String solution = practice.solution(1, 14);
 *         System.out.println("solution = " + solution);
 *     }
 * }
 */


/** 나누어 떨어지는 숫자 배열
 * public class Practice{
 *
 *     public int[] solution(int[] arr, int divisor) {
 *         List<Integer> list = new ArrayList<>();
 *         for (int i = 0; i < arr.length; i++) {
 *             if(arr[i] % divisor == 0){
 *                 list.add(arr[i]);
 *             }
 *         }
 *
 *         int[] answer = new int[list.size()];
 *
 *
 *         for (int i = 0; i < answer.length; i++) {
 *             answer[i] = list.get(i);
 *         }
 *
 *         Arrays.sort(answer);
 *
 *         return answer.length == 0 ? new int[]{-1} :  answer;
 *     }
 *
 *     public static void main(String[] args) {
 *         int[] arr = {5, 9, 7, 10};
 *         int divisor = 5;
 *         Practice practice = new Practice();
 *         int[] solution = practice.solution(arr, divisor);
 *         for (int i : solution) {
 *             System.out.println("i = " + i);
 *         }
 *     }
 * }
 */

public class Practice{

    public long solution(int a, int b) {

        if(a > b){
            int temp = b;
            b = a;
            a = temp;
        }

        long answer = 0;

        for (int i = a; i <= b ; i++) {
            answer += i;
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        Practice practice = new Practice();
        long solution = practice.solution(5, 3);
        System.out.println("solution = " + solution);
    }
}