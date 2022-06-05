package happysubin.javapractice.codingtest.baekjoon;

import java.io.*;
import java.util.*;


class Size{
    int weight;
    int height;

    public Size(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
}

public class Implementation {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Size> arr = new ArrayList<>();
        int num = Integer.parseInt(br.readLine());
        int[] answer = new int[num];

        for(int i = 0; i < num; i++){
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            arr.add(new Size(Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken()))); 
        }


        for(int i = 0; i < num; i++){
            int rank = 1;
            Size criteria = arr.get(i);
            for(int j = 0; j < num; j++){
                Size comparison = arr.get(j);
                if(criteria.weight < comparison.weight & criteria.height < comparison.height  ) rank++;
            }
            answer[i] = rank;

        }

        for (int i : answer) {
            System.out.println(i);
        }

    }
}
