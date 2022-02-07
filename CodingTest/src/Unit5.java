

/*
import java.io.*;
import java.util.Stack;

public class Unit5 {
    public static String solution(String str){
        Stack<String> stack= new Stack<String>();
        String[] arr=str.split("");
        for(String x:arr){
            if(x.equals("(")){
                stack.push(x);
            }
            else if(x.equals(")")){
                if(stack.empty())return "NO";
                else stack.pop();
            }
        }

        if(stack.size()!=0)return "NO";
        return "YES";

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        System.out.print(solution(str));

    }
}

5-1 올바른 괄호 판단
 */

import java.io.*;
import java.util.Stack;


public class Unit5 {
    public static String solution(String[] arr){
        Stack<String> stack = new Stack<>();
        String answer="";

        for(String s:arr){
            if(s.equals(")")){
                while(!stack.pop().equals("("));
            }
            else stack.push(s);
        }

        for (String s : stack) {
            answer+=s;
        }

        return answer;

    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr=br.readLine().split("");


        System.out.println(solution(arr));

    }
}

//5 -2 괄호 문자 제거

/*

import java.io.*;
import java.util.Stack;


public class Unit5 {
    public static int solution(int size, int[][] board, int num, int[] seq){
        Stack<Integer> stack = new Stack<>();
        int cnt=0;

        for( int se:seq){
            int s=se-1;
            int i=0;
            while( board[i][s]==0){
                if(i<size-1)i++;
                else break;
            }

            if(!stack.empty()&&board[i][s]==stack.peek()){
                stack.pop();
                cnt=cnt+2;
            }
            else stack.push(board[i][s]);
            board[i][s]=0;
        }

        return cnt;

    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size=Integer.parseInt(br.readLine());
        int[][] arr=new int[size][size];
        for(int i=0;i<size;i++){
            String[] str=br.readLine().split(" ");
            for(int j=0;j<size;j++){
                arr[i][j]=Integer.parseInt(str[j]);
            }
        }

        int num=Integer.parseInt(br.readLine());
        String[] str=br.readLine().split(" ");
        int[] arr2=new int[num];
        int i=0;
        for(String s:str){
            arr2[i++]=Integer.parseInt(s);
        }


        System.out.println(solution(size,arr,num,arr2));

    }
}

5-3 인형 뽑기 카카오
 */

/*
import java.io.*;
import java.util.Stack;

public class Unit5 {
    public static int solution(String str){
        Stack<Integer> stack=new Stack<>();

       for(String s:str.split("")){

           if(!s.equals("+")&!s.equals("-")&!s.equals("*")&!s.equals("/")){
               stack.push(Integer.parseInt(s));
           }
           else {
               int num1 = stack.pop();
               int num2 = stack.pop();
               if (s.equals("+")) {
                   stack.push(num1 + num2);
               } else if (s.equals("-")) {
                   stack.push(num2 - num1);
               } else if (s.equals("*")) {
                   stack.push(num1 * num2);
               } else if (s.equals("/")) {
                   stack.push(num2 / num1);
               }

           }

       }
        return stack.pop();

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        System.out.print(solution(str));

    }
}

5-4 후위식 연산
 */