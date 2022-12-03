package happysubin.javapractice.codingtest.inflearn;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HashMapChapter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split("");
        Map<String, Integer> map = new HashMap<>();


        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }


        int max = 0 ;
        String answer = "";
        for (String s : map.keySet()) {
            if(max <map.get(s)){
                answer = s;
                max = map.get(s);
            }
        }

        bw.write(answer);
        bw.flush();
    }
}
