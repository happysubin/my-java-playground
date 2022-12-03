package happysubin.javapractice.codingtest.inflearn;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//학급 회장

/**
 * public class HashMapChapter {
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *         int num = Integer.parseInt(br.readLine());
 *         String[] arr = br.readLine().split("");
 *         Map<String, Integer> map = new HashMap<>();
 *
 *
 *         for (String s : arr) {
 *             map.put(s, map.getOrDefault(s, 0) + 1);
 *         }
 *
 *
 *         int max = 0 ;
 *         String answer = "";
 *         for (String s : map.keySet()) {
 *             if(max <map.get(s)){
 *                 answer = s;
 *                 max = map.get(s);
 *             }
 *         }
 *
 *         bw.write(answer);
 *         bw.flush();
 *     }
 * }
 */

public class HashMapChapter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr1 = br.readLine().split("");
        Map<String, Integer> map1 = new HashMap<>();

        String[] arr2 = br.readLine().split("");
        Map<String, Integer> map2 = new HashMap<>();

        for (String s : arr1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }

        for (String s : arr2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }

        String answer = "YES";
        for (String s : map2.keySet()) {
            if(map2.get(s) != map1.get(s)) answer = "NO";
        }


        bw.write(answer);
        bw.flush();
    }
}
