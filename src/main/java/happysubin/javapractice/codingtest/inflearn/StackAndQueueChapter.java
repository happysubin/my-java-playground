package happysubin.javapractice.codingtest.inflearn;


import java.io.*;
import java.util.*;

// 올바른 괄호

/**
 * public class StackAndQueueChapter {
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *
 *         String[] arr = br.readLine().split("");
 *         Stack<String > stack = new Stack();
 *
 *         for (int i = 0; i < arr.length; i++) {
 *             if(arr[i].equals(")")){
 *
 *                 if(stack.size() >= 1) stack.pop();
 *                 else {
 *                     bw.write("NO");
 *                     bw.flush();
 *                     return;
 *                 }
 *
 *             }
 *             else{
 *                 stack.push(arr[i]);
 *             }
 *         }
 *
 *         if(stack.size() != 0) bw.write("NO");
 *         else bw.write("YES");
 *         bw.flush();
 *     }
 * }
 */

//괄호 문자 제거

/**
 * public class StackAndQueueChapter {
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *
 *         String[] arr = br.readLine().split("");
 *         Stack<String > stack = new Stack();
 *
 *         List<String> answer = new ArrayList<>();
 *
 *         for (int i = 0; i < arr.length; i++) {
 *
 *             if(arr[i].equals("(")){
 *                 stack.push(arr[i]);
 *             }
 *
 *             else if(arr[i].equals(")")){
 *                 while(!stack.peek().equals("(")){
 *                     stack.pop();
 *                 }
 *                 stack.pop();
 *             }
 *
 *             else if(stack.size() == 0){
 *                 answer.add(arr[i]);
 *             }
 *             else {
 *                 stack.push(arr[i]);
 *             }
 *         }
 *
 *         for (String s : answer) {
 *             bw.write(s);
 *         }
 *         bw.flush();
 *     }
 * }
 */

// 후위식 연산

/**
 * public class StackAndQueueChapter {
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *         String[] arr = br.readLine().split("");
 *         Stack<Integer> stack = new Stack();
 *         int answer = 0;
 *         for (int i = 0; i < arr.length; i++) {
 *
 *             if(Character.isDigit(arr[i].charAt(0))){
 *                 stack.add(Integer.parseInt(arr[i]));
 *             }
 *             else if(arr[i].equals("+")){
 *                 Integer num1 = stack.pop();
 *                 Integer num2 = stack.pop();
 *                 stack.push(num1 + num2);
 *             }
 *             else if(arr[i].equals("*")){
 *                 Integer num1 = stack.pop();
 *                 Integer num2 = stack.pop();
 *                 stack.push(num1 * num2);
 *             }
 *             else if(arr[i].equals("-")){
 *                 Integer num1 = stack.pop();
 *                 Integer num2 = stack.pop();
 *                 stack.push(num2 - num1);
 *             }
 *             else if(arr[i].equals("/")){
 *                 Integer num1 = stack.pop();
 *                 Integer num2 = stack.pop();
 *                 stack.push(num2 / num1);
 *             }
 *         }
 *         bw.write(stack.pop() + "\n");
 *         bw.flush();
 *     }
 * }
 */

// 쇠막대기

/**
 * public class StackAndQueueChapter {
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *         String[] arr = br.readLine().split("");
 *         Stack<String> stack = new Stack();
 *         int answer = 0;
 *         for (int i = 0; i < arr.length; i++) {
 *             if(arr[i].equals("(")){
 *                 stack.push(arr[i]);
 *             }
 *             else {
 *                 stack.pop();
 *                 if(arr[i - 1].equals("(")){
 *                     answer += stack.size();
 *
 *                 }
 *                 else {
 *                     answer++;
 *                 }
 *             }
 *         }
 *
 *         bw.write(answer+ "\n");
 *         bw.flush();
 *     }
 * }
 */

//공주 구하기

/**
 * public class StackAndQueueChapter {
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *         String[] arr = br.readLine().split(" ");
 *         Integer len = Integer.parseInt(arr[0]);
 *         Integer turn = Integer.parseInt(arr[1]);
 *         Queue<Integer> queue = new LinkedList<>();
 *
 *
 *         for (int i = 1; i <= len; i++) {
 *             queue.add(i);
 *         }
 *
 *         int cnt = 0;
 *
 *         while(queue.size() != 1){
 *             cnt++;
 *             Integer ele = queue.poll();
 *             if(cnt != turn){
 *                 queue.add(ele);
 *             }
 *             else{
 *                 cnt = 0;
 *             }
 *         }
 *
 *         bw.write(queue.poll() + "");
 *         bw.flush();
 *     }
 * }
 */

// 교육과정 설계

/**
 * public class StackAndQueueChapter {
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *         String[] eProcess = br.readLine().split("");
 *         String[] arr = br.readLine().split("");
 *         String answer = "YES";
 *
 *         Queue<String> queue = new LinkedList<>();
 *
 *         for (String process : eProcess) {
 *             queue.add(process);
 *         }
 *
 *         for (int i = 0; i < arr.length; i++) {
 *             if(arr[i].equals(queue.peek())){
 *                 queue.poll();
 *             }
 *         }
 *
 *         if(queue.size() == 0){
 *             bw.write("YES");
 *         }
 *         else{
 *             bw.write("NO");
 *         }
 *         bw.flush();
 *     }
 * }
 */

public class StackAndQueueChapter {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split(" ");
        
        int len = Integer.parseInt(arr[0]);
        int idx = Integer.parseInt(arr[1]);

        String[] temp = br.readLine().split(" ");
        Queue<Rank> queue = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            queue.add(new Rank(i, Integer.parseInt(temp[i])));
        }

        int cnt = 0; //순서
        boolean flag = false;

        while(queue.size()  > 0 ){
            Rank ele = queue.poll();
            for (int i = 0; i < queue.size(); i++) {
                Rank v = queue.poll();
                queue.add(v);
                if(ele.score < v.score){
                    flag = true;
                }

            }

            if(flag == true){
                queue.add(ele);
            }
            else{
                cnt++;
                if(ele.idx == idx){
                    bw.write(cnt + "");
                    break;
                }
            }

            flag = false;

        }

        bw.flush();
    }
}

class Rank{
    int idx;
    int score;

    public Rank(int idx, int score) {
        this.idx = idx;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "idx=" + idx +
                ", score=" + score +
                '}';
    }
}

