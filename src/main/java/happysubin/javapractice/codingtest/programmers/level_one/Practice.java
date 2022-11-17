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

//2016년

public class Practice{

    public String solution(int a, int b) {
        int month = a - 1;
        int date = b;
        int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};

        for (int i = 0; i < month; i++) {
            date += months[i];
        }

        return day[date  % 7];
    }

    public static void main(String[] args) {
        Practice practice = new Practice();
        String solution = practice.solution(1, 14);
        System.out.println("solution = " + solution);
    }
}
