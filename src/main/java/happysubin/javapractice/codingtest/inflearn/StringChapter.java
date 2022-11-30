package happysubin.javapractice.codingtest.inflearn;

import java.io.*;
import java.util.HashMap;
import java.util.*;


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

/**
 * public class StringChapter{
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *         char[] chars = br.readLine().toCharArray();
 *         int rt = chars.length - 1;
 *         int lt = 0;
 *         while(lt < rt){
 *             char c = chars[lt];
 *             char s = chars[rt];
 *             if(Character.isAlphabetic(c) & Character.isAlphabetic(s)){
 *                 char temp = chars[lt];
 *                 chars[lt] = chars[rt];
 *                 chars[rt] = temp;
 *                 rt --;
 *                 lt ++;
 *             }
 *
 *             else if (!Character.isAlphabetic(c)){
 *                 lt ++;
 *             }
 *
 *             else if (!Character.isAlphabetic(s)){
 *                 rt --;
 *             }
 *         }
 *
 *         String s = String.valueOf(chars); //이렇게 하면 문자 배열이 문자열로 된다.
 *         bw.write(s);
 *         bw.flush();
 *     }
 * }
 */

//중복 문자 제거

/**
 * public class StringChapter{
 *     public static void main(String[] args) throws IOException {
 *         Set<String> hashSet = new LinkedHashSet();
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *         String[] arr = br.readLine().split("");
 *
 *         for (String s : arr) {
 *             hashSet.add(s);
 *         }
 *
 *         StringBuffer sf = new StringBuffer();
 *         for (String s : hashSet) {
 *            sf.append(s);
 *         }
 *
 *         bw.write(sf.toString());
 *         bw.flush();
 *     }
 * }
 */

//회문 문자열 검사하기

/**
 * public class StringChapter{
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *         String s = br.readLine().toLowerCase();
 *         StringBuffer sf = new StringBuffer();
 *
 *
 *         String r = sf.append(s).reverse().toString();
 *
 *         if(r.equals(s)){
 *             bw.write("YES");
 *         }
 *         else {
 *             bw.write("NO");
 *         }
 *
 *         bw.flush();
 *     }
 * }
 */

// 유효한 팰린드롬

/**
 * public class StringChapter {
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *         String s = br.readLine().replaceAll("[^a-zA-Z]","").toLowerCase(Locale.ROOT);
 *         StringBuffer sf = new StringBuffer();
 *         String reverse = sf.append(s).reverse().toString();
 *
 *         if(s.equals(reverse)){
 *             bw.write("YES");
 *         }
 *         else{
 *             bw.write("NO");
 *         }
 *
 *         bw.flush();
 *     }
 * }
 */

//숫자만 추출

/**
 * public class StringChapter {
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *         char[] chars = br.readLine().toCharArray();
 *         StringBuffer sf = new StringBuffer();
 *         for (int i = 0; i < chars.length; i++) {
 *             if(Character.isDigit(chars[i])){
 *                 sf.append(chars[i]);
 *             }
 *         }
 *
 *         bw.write(Integer.parseInt(sf.toString()) + "\n");
 *         bw.flush();
 *
 *     }
 * }
 */


//문자열 압축

/**
 * public class StringChapter{
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *         String[] s = br.readLine().split(" ");
 *         String[] arr = s[0].split("");
 *         String word = s[1];
 *
 *         int d = 999;
 *         int[] scores = new int[arr.length];
 *
 *         //앞에서 부터 측정함.
 *         for (int i = 0; i < arr.length; i++) {
 *             if(!arr[i].equals(word)){
 *                 scores[i] = d;
 *                 d++;
 *             }
 *             else if(arr[i].equals(word)){
 *                 d = 0;
 *                 scores[i] = 0;
 *                 d++;
 *             }
 *         }
 *
 *         //이제 뒤에서부터도 측정해야함.
 *         d = 1000;
 *         for (int i = arr.length - 1; i >= 0 ; i--) {
 *             if(!arr[i].equals(word)){
 *                 if(scores[i] > d){
 *                     scores[i] = d;
 *                 }
 *                 d++;
 *             }
 *             else if(arr[i].equals(word)){
 *                 d = 0;
 *                 scores[i] = 0;
 *                 d++;
 *             }
 *         }
 *
 *         for (int score : scores) {
 *             bw.write(score + " ");
 *         }
 *         bw.flush();
 *     }
 * }
 */

// 문자열 압축


/**
 * public class StringChapter{
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *         String s1 = br.readLine() + "!";
 *         String[] str = s1.split("");
 *
 *         int cnt = 1;
 *         StringBuffer sf = new StringBuffer();
 *         for (int i = 0; i < str.length - 1; i++) {
 *            if(str[i].equals(str[i + 1])){
 *                 cnt ++;
 *            }
 *            else{
 *                if(cnt == 1){
 *                     sf.append(str[i]);
 *                }
 *                else {
 *                    sf.append(str[i] + cnt);
 *                    cnt = 1;
 *                }
 *            }
 *         }
 *
 *         bw.write(sf.toString());
 *         bw.flush();
 *     }
 * }
 *
 */

public class StringChapter{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String replace = str.replaceAll("#", "1");
        String replace1 = replace.replaceAll("\\*", "0");
        String[] arr = new String[num];
        int[] arr2 = new int[num];
        int j = 0;
        for (int i = 0; i < num; i++) {
            arr2[i] = Integer.parseInt(replace1.substring(j, j + 7), 2);
            j += 7;
        }


        StringBuffer stringBuffer = new StringBuffer();
        for (int i : arr2) {
            stringBuffer.append((char)i);
        }

        bw.write(stringBuffer.toString());
        bw.flush();
    }
}

