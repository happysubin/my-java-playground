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


import java.util.*;

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


/** 두 정수 사이의 합
 * public class Practice{
 *
 *     public long solution(int a, int b) {
 *
 *         if(a > b){
 *             int temp = b;
 *             b = a;
 *             a = temp;
 *         }
 *
 *         long answer = 0;
 *
 *         for (int i = a; i <= b ; i++) {
 *             answer += i;
 *         }
 *
 *         return answer;
 *     }
 *
 *     public static void main(String[] args) {
 *         Practice practice = new Practice();
 *         long solution = practice.solution(5, 3);
 *         System.out.println("solution = " + solution);
 *     }
 * }
 *
 */


/** 문자열 내 마음대로 정렬하기
 * public class Practice{
 *
 *
 *     class CustomString implements Comparable<CustomString>{
 *
 *         private String arr;
 *         private Integer idx;
 *
 *         public CustomString(String arr, Integer idx) {
 *             this.arr = arr;
 *             this.idx = idx;
 *         }
 *
 *         public String getArr() {
 *             return arr;
 *         }
 *
 *         public Integer getIdx() {
 *             return idx;
 *         }
 *
 *
 *         @Override
 *         public int compareTo(CustomString o) { //다음에 오는 객체
 *             char next = o.getArr().charAt(o.getIdx());
 *             char now = this.arr.charAt(idx);
 *             return now - next;
 *
 * //            return now  > next ? 1 : -1;
 *         }
 *     }
 *
 *     public String[] solution(String[] strings, int n) {
 *         List<CustomString> arr = new ArrayList<>();
 *
 *         Arrays.sort(strings);
 *
 *         for (String string : strings) {
 *             arr.add(new CustomString(string, n));
 *         }
 *         Collections.sort(arr);
 *
 *
 *         String[] answer = new String[arr.size()];
 *
 *         for (int i = 0; i < answer.length; i++) {
 *             answer[i] = arr.get(i).getArr();
 *         }
 *         return answer;
 *     }
 *
 *     public static void main(String[] args) {
 *         String[] arr = {"abce", "abcd", "cdx"};
 *         Practice practice = new Practice();
 *         String[] solution = practice.solution(arr, 2);
 *         for (String s : solution) {
 *             System.out.println("s = " + s);
 *         }
 *     }
 * }
 */


public class Practice{

    boolean solution(String s) {
        String string = s.toLowerCase();
        int yCount = 0;
        int pCount = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'y') {
                ++yCount;
            } else if (string.charAt(i) == 'p') {
                ++pCount;
            }
        }

        if (pCount == yCount) return true;
        else if (pCount == 0 & yCount == 0) return true;

        return false;

    }

    public static void main(String[] args) {
        String s = "pPoooyY";

        Practice practice = new Practice();
        boolean solution = practice.solution(s);
        System.out.println("solution = " + solution);

    }
}