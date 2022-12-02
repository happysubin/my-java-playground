package happysubin.javapractice.codingtest.inflearn;

import java.io.*;
import java.util.regex.Pattern;

public class TwoPointers {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num1 = Integer.parseInt(br.readLine());
        String[] arr1 = br.readLine().split(" ");
        int num2 = Integer.parseInt(br.readLine());
        String[] arr2 = br.readLine().split(" ");
        int[] answer = new int [num1 + num2];

        int lt = 0;
        int rt = 0;
        int i = 0;
        while(lt < num1 && rt < num2 ){
            if(Integer.parseInt(arr1[lt]) < Integer.parseInt(arr2[rt])){
                answer[i++] = Integer.parseInt(arr1[lt++]);
            }

            else {
                answer[i++] = Integer.parseInt(arr2[rt++]);
            }
        }

        for (int j = rt; j < num2; j++) {
            answer[i++] = Integer.parseInt(arr2[j]);
        }

        for (int j = lt; j < num1; j++) {
            answer[i++] = Integer.parseInt(arr1[j]);
        }


        for (int i1 : answer) {
            bw.write(i1 + " ");
        }
        bw.flush();
    }
}
