package happysubin.javapractice.codingtest.baekjoon;

import java.util.*;
import java.io.*;

//숫자카드 2 구하기
public class Hash{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int totalNum = Integer.parseInt(br.readLine()); //n이 주어짐
        Map<Integer, Integer> map = new HashMap<>();
        String[] arr = br.readLine().split(" ");
        for(String s : arr){
            Integer temp = Integer.parseInt(s);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        int num = Integer.parseInt(br.readLine()); //m이 주어짐
        String[] arr2 = br.readLine().split(" ");
        int[] target = new int[num];
        for(int i = 0; i < num; i++){
            target[i] = Integer.parseInt(arr2[i]);
        }
        for(Integer i : target){
            if(map.keySet().contains(i)){
                bw.write(map.get(i) + " ");
            }
            else{
                bw.write(0 + " ");
            }
        }
        bw.flush();
    }
}


//포켓몬 마스터 이다솜.
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int total = Integer.parseInt(str[0]); //전체 포켓몬 수
        int problem = Integer.parseInt(str[1]); //맞춰야하는 문제 개수

        Map<String, String> numMap = new HashMap<>();
        Map<String, String> stringMap = new HashMap<>();

        //도감 초기화
        for(int i = 1; i <= total; i++){
            String pokemon = br.readLine();
            numMap.put(String.valueOf(i), pokemon);
            stringMap.put(pokemon, String.valueOf(i));
        }

        //문제가 들어와
        for(int i = 0; i < problem; i++){
            String s = br.readLine();
            if(numMap.keySet().contains(s)){
                bw.write(numMap.get(s) + "\n");
            }
            else{
                bw.write(stringMap.get(s) + "\n");
            }
        }
        bw.flush();
    }
}