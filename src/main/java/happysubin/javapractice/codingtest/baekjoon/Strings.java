package happysubin.javapractice.codingtest.baekjoon;

import java.io.*;



/* 11720
public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num  = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split("");
        int sum = 0;
        for(int i=0 ; i < num; i++){
            sum += Integer.parseInt(arr[i]);
        }
        System.out.println(sum);
    }
}


 */


/*
//8958
public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num  = Integer.parseInt(br.readLine());

        for(int i=0 ; i < num; i++){
            int sum = 0;
            int point = 0;
            String str = br.readLine() + "X";
            String[] arr = str.split("");
            for(int j = 0; j < arr.length; j ++){
               if(arr[j].equals("O")){
                   point++;
                   sum += point;
               }
               else{
                   point = 0;
               }
            }
            System.out.println(sum);
        }

    }
}

 */

/*
//1152
public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        String[] arr = s.split(" ");
        if(arr[0].equals("")){
            System.out.println(0);
        }
        else{
            System.out.println(arr.length);
        }


    }
}


 */


/*
//10809
public class Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int[] arr = new int[26];

        for (int i = 0; i< arr.length ; i++) {
            arr[i] = -1;
        }

        for(int i = 0; i< chars.length; i++){
           if(arr[chars[i]-'a'] == -1){
               arr[chars[i]-'a'] = i;
           }
           else{
               continue;
           }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }


    }
}

 */