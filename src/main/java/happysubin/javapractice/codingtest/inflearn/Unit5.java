

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

/*
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

 */
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

/*
import java.io.*;
import java.util.Stack;


public class Unit5 {
    public static int solution(String str) {
        Stack<Character> stack = new Stack<>();
        int cnt=0;

        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)=='('){
                stack.push(str.charAt(i));
            }
            else { //c가 )일 때
                stack.pop();
                if(str.charAt(i-1)=='(')cnt+=stack.size();
                else cnt++;
            }
        }

        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();

        System.out.println(solution(str));

    }
}

*/

/*

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


public class Unit5 {
    public static int solution(int len, int sec){
        Queue<Integer> queue=new LinkedList();
        for(int i=1;i<=len;i++){
            queue.offer(i);
        }
        while(queue.size()!=1){
            for(int i=1;i<sec;i++) queue.offer(queue.poll());
            queue.poll();
        }
        return queue.poll();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr=br.readLine().split(" ");
        int len=Integer.parseInt(arr[0]);
        int sec=Integer.parseInt(arr[1]);
        System.out.print(solution(len,sec));

    }
}

 5 - 6 공주 구하기 큐
 */

/*
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


public class Unit5 {
    public static String solution(String keyword, String str){
        Queue<Character> queueA=new LinkedList();
        Queue<Character> queueB=new LinkedList<>();

        for(char c: str.toCharArray()){
            queueA.offer(c);
        }

        for(char c: keyword.toCharArray()){
            queueB.offer(c);
        }

        while(!queueA.isEmpty()){
            if(queueA.peek()==queueB.peek()){
                    queueA.poll();queueB.poll();
            }
            else queueA.poll();
        }

        if(!queueB.isEmpty())return "NO";

        return "YES";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String keyword=br.readLine();
        String str=br.readLine();

        System.out.println(solution(keyword,str));

    }
}
5 - 7 교육과정 설계
 */




import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


class Person {
    int seq;
    int danger;

    Person(int seq, int danger) {
        this.seq = seq;
        this.danger= danger;
    }
}

public class Unit5 {
    public static int solution(int len,int rank,int[] line) {
        Queue<Person> queue=new LinkedList<>();
        int cnt=0;

        for(int i=0;i<len;i++){
            queue.offer(new Person(i,line[i]));
        }

        while(!queue.isEmpty()){
            Person person=queue.poll();
            for(Person temp:queue){
                if(person.danger<temp.danger){
                    queue.offer(person);
                    person=null;
                    break;
                }
            }
            if(person!=null){
                cnt++;
                if(person.seq==rank)return cnt;
            }
        }

        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr=br.readLine().split(" ");
        int len=Integer.parseInt(arr[0]);
        int rank=Integer.parseInt(arr[1]),j=0;
        String[] arr2=br.readLine().split(" ");
        int[] line=new int[len];
        for(String s:arr2){
            line[j++]=Integer.parseInt(s);
        }

        System.out.println(solution(len,rank,line));

    }
}