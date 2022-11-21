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

/** 문자열 내 p와 y의 개수
 *public class Practice{
 *
 *     boolean solution(String s) {
 *         String string = s.toLowerCase();
 *         int yCount = 0;
 *         int pCount = 0;
 *         for (int i = 0; i < string.length(); i++) {
 *             if (string.charAt(i) == 'y') {
 *                 ++yCount;
 *             } else if (string.charAt(i) == 'p') {
 *                 ++pCount;
 *             }
 *         }
 *
 *         if (pCount == yCount) return true;
 *         else if (pCount == 0 & yCount == 0) return true;
 *
 *         return false;
 *
 *     }
 *
 *     public static void main(String[] args) {
 *         String s = "pPoooyY";
 *
 *         Practice practice = new Practice();
 *         boolean solution = practice.solution(s);
 *         System.out.println("solution = " + solution);
 *
 *     }
 * }
 *
 */


/**
 * 문자열 내림차순으로 배치하기
 * public class Practice{
 *
 *     public String solution(String s) {
 *         String[] arr = s.split("");
 *         Arrays.sort(arr, Collections.reverseOrder());
 *         StringBuffer sb = new StringBuffer();
 *         for (String s1 : arr) {
 *             sb.append(s1);
 *         }
 *         return sb.toString();
 *     }
 *
 *     public static void main(String[] args) {
 *         String str = "Zbcdefg";
 *         Practice practice = new Practice();
 *         practice.solution(str);
 *     }
 * }
 */

/** 문자열 다루기 기본
 * public class Practice{
 *
 *     public boolean solution(String s) {
 *
 *         if(s.length() != 4 & s.length() != 6){
 *             return false;
 *         }
 *
 *         for (int i = 0; i < s.length(); i++) {
 *             if (!Character.isDigit(s.charAt(i))){
 *                 return false;
 *             }
 *         }
 *
 *         return true;
 *     }
 *
 *     public static void main(String[] args) {
 *         String str = "1234";
 *         Practice practice = new Practice();
 *         boolean solution = practice.solution(str);
 *         System.out.println("solution = " + solution);
 *     }
 * }
 */



//문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.

/** 서울에서 김서방 찾기
 * public class Practice{
 *
 *     public String solution(String[] seoul) {
 *
 *         int num = 0;
 *
 *         for (int i = 0; i < seoul.length; i++) {
 *             if(seoul[i].equals("Kim")){
 *                 num = i;
 *             }
 *         }
 *         return "김서방은 " + num +  "에 있다";
 *     }
 *
 *     public static void main(String[] args) {
 *         String[] arr = {"Jane", "Kim"};
 *         Practice practice = new Practice();
 *         String solution = practice.solution(arr);
 *         System.out.println("solution = " + solution);
 *     }
 * }
 */


/** 이상한 문자 만들기
 * public class Practice{
 *
 *     public String solution(String s) {
 * //        String[] arr = s.trim().split(" "); 해당 코드는 "abbbdd     " 뒤에 공백을 제거해버림. 따라서 에러가 발생함
 *         String[] arr = s.trim().split(" ", -1); //공백을 유지해주는 아이디어
 *
 *         StringBuilder sb = new StringBuilder();
 *
 *         for (int i = 0; i < arr.length; i++) {
 *
 *             for (int j = 0; j < arr[i].length(); j++) {
 *                 if(j % 2 == 0){
 *                     sb.append(Character.toUpperCase(arr[i].charAt(j)));
 *                 }
 *                 else{
 *                     sb.append(Character.toLowerCase(arr[i].charAt(j)));
 *                 }
 *             }
 *
 *             if(i != arr.length - 1){
 *                 sb.append(" ");
 *             }
 *         }
 *
 *         return sb.toString();
 *     }
 *
 *     public static void main(String[] args) {
 *         String s = "abc cde      ";
 *         Practice practice = new Practice();
 *         String solution = practice.solution(s);
 *         System.out.println(solution + "k");
 *     }
 * }
 *
 */



/**시저 암호
 * public class Practice{
 *
 *     public String solution(String s, int n) {
 *
 *         StringBuilder sb = new StringBuilder();
 *         for (int i = 0; i < s.length(); i++) {
 *             char c = s.charAt(i);
 *             if(Character.isLowerCase(c)){
 *                 if(c + n > 122 ){ //z 아스키 코드 122, a는 97
 *                      char c1 = (char) (c + n - 122 + 96);
 *                      sb.append(c1);
 *                 }
 *                 else{
 *                     char c1 = (char)(c + n);
 *                     sb.append(c1);
 *                 }
 *             }
 *             else if(Character.isUpperCase(c)){ //Z 아스키 코드
 *                 if(c + n > 90 ){ //Z 아스키 코드 90, A는 65
 *                     char c1 = (char) (c + n - 90 + 64);
 *                     sb.append(c1);
 *                 }
 *                 else{
 *                     char c1 = (char)(c + n);
 *                     sb.append(c1);
 *                 }
 *             }
 *             else {
 *                 sb.append(" ");
 *             }
 *         }
 *
 *         return sb.toString();
 *     }
 *
 *     public static void main(String[] args) {
 *         String s = "Z";
 *         int n =  4;
 *
 *         Practice practice = new Practice();
 *         String solution = practice.solution(s, n);
 *         System.out.println("solution = " + solution);
 *         char c1 = (char) (1 + 3 - 122 + 97);
 *     }
 * }
 *
 */

//자릿수 더하기
//public class Practice{
//    public int solution(int n) {
//        String s = String.valueOf(n);
//
//        int sum = 0;
//        String[] split = s.split("");
//        for (String s1 : split) {
//            sum += Integer.valueOf(s1);
//        }
//
//        return sum;
//    }
//
//    public static void main(String[] args) {
//        int n = 987;
//        Practice practice = new Practice();
//        int solution = practice.solution(n);
//        System.out.println("solution = " + solution);
//    }
//}


//자연수 뒤집어 배열로 만들기
//public class Practice{
//
//
//    public int[] solution(long n) {
//        String s = String.valueOf(n);
//        String[] split = s.split("");
//        int[] arr = new int [s.length()];
//        int j = 0;
//        for (int i = arr.length - 1; i >= 0 ; i--) {
//            arr[j++] = Integer.valueOf(split[i]);
//        }
//
//        return arr;
//    }
//
//    public static void main(String[] args) {
//        long n = 12345;
//        Practice practice = new Practice();
//        int[] solution = practice.solution(n);
//        for (int i : solution) {
//            System.out.println("i = " + i);
//        }
//    }
//}

//정수 내림차순으로 배치하기
//public class Practice{
//
//    public long solution(long n) {
//        String s = String.valueOf(n);
//        List<String> strings = Arrays.asList(s.split(""));
//        Collections.sort(strings, Collections.reverseOrder());
//        StringBuilder stringBuilder = new StringBuilder();
//        for (String string : strings) {
//            stringBuilder.append(string);
//        }
//        return Long.valueOf(stringBuilder.toString());
//    }
//
//    public static void main(String[] args) {
//        long n = 118372;
//        Practice practice = new Practice();
//        long solution = practice.solution(n);
//        System.out.println("solution = " + solution);
//    }
//}

//정수 제곱근 판별
//public class Practice{
//
//    public long solution(long n) {
//        double sqrt = Math.sqrt(n); //루트 씌우기
//        if(sqrt % 1 != 0 ){
//            return -1;
//        }
//        return (long) Math.pow(sqrt + 1, 2);
//    }
//
//    public static void main(String[] args) {
//        long n = 121;
//        Practice practice = new Practice();
//        long solution = practice.solution(n);
//        System.out.println("solution = " + solution);
//    }
//}