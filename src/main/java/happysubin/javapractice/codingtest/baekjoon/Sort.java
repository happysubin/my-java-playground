package happysubin.javapractice.codingtest.baekjoon;


import java.util.*;

public class Sort{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<String> arr = new ArrayList<>();

        for(int i = 0; i <num; i++){
            arr.add(sc.next());
        }



        Collections.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.length() == s2.length()) return s1.compareTo(s2);
                else return s1.length() - s2.length();
            }
        });

        for(String s : arr){
            System.out.println(s);
        }
    }
}