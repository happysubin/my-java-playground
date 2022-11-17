package happysubin.javapractice.codingtest.programmers.level_one;

public class Practice {

    public String solution(String s) {
        String answer = "";

        if(s.length() % 2 != 0){
            return s.substring(s.length() / 2, s.length() / 2 + 1);
        }

        return s.substring(s.length() / 2 - 1, s.length() / 2 + 1 );
    }

    public static void main(String[] args) {
        String s = "abcde";
        Practice practice = new Practice();
        String solution = practice.solution(s);
        System.out.println("solution = " + solution);
    }
}
