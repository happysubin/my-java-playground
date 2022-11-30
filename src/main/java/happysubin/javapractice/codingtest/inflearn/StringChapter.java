package happysubin.javapractice.codingtest.inflearn;

import java.io.*;



// 문자 넣기

/**
 * public class StringChapter {
 *
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *         String[] split = br.readLine().toLowerCase().split("");
 *         String s = br.readLine().toLowerCase();
 *         int answer = 0 ;
 *         for (int i = 0; i < split.length; i++) {
 *             if(split[i].equals(s)) answer ++;
 *         }
 *
 *         bw.write(answer+"\n");
 *         bw.flush();
 *         bw.close();
 *         br.close();
 *
 *
 *     }
 * }
 */

// 대소문자 변환

/**
 * public class StringChapter{
 *     public static void main(String[] args)throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *         String s = br.readLine();
 *         String answer = "";
 *
 *         for (int i = 0; i < s.length(); i++) {
 *             if(Character.isUpperCase(s.charAt(i))){
 *                 answer += Character.toLowerCase(s.charAt(i));
 *             }
 *             else{
 *                 answer += Character.toUpperCase(s.charAt(i));
 *             }
 *         }
 *
 *         bw.write(answer);
 *         bw.flush();
 *     }
 * }
 */

// 문장 속 단어

/**
 * public class StringChapter{
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *         String[] arr = br.readLine().split(" ");
 *         int max = arr[0].length();
 *         String answer = arr[0];
 *
 *         for (int i = 1; i < arr.length; i++) {
 *             if(max < arr[i].length()){
 *                 max = arr[i].length();
 *                 answer = arr[i];
 *             }
 *         }
 *
 *         bw.write(answer);
 *         bw.flush();
 *     }
 * }
 *
 */

// 단어 뒤집기

/**
 * public class StringChapter{
 *     public static void main(String[] args)throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *         int num = Integer.parseInt(br.readLine());
 *         String[] arr = new String[num];
 *         for (int i = 0; i < num; i++) {
 *             StringBuilder sb = new StringBuilder();
 *             arr[i] = sb.append(br.readLine()).reverse().toString();
 *         }
 *
 *         for (String s : arr) {
 *             bw.write(s + "\n");
 *         }
 *         bw.flush();
 *     }
 * }
 */

// 특정 문자 뒤집기


public class StringChapter{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] chars = br.readLine().toCharArray();
        int rt = chars.length - 1;
        int lt = 0;
        while(lt < rt){
            char c = chars[lt];
            char s = chars[rt];
            if(Character.isAlphabetic(c) & Character.isAlphabetic(s)){
                char temp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = temp;
                rt --;
                lt ++;
            }

            else if (!Character.isAlphabetic(c)){
                lt ++;
            }

            else if (!Character.isAlphabetic(s)){
                rt --;
            }
        }

        String s = String.valueOf(chars); //이렇게 하면 문자 배열이 문자열로 된다.
        bw.write(s);
        bw.flush();
    }
}

