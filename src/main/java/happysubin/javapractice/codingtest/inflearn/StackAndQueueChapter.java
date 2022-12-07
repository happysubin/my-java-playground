package happysubin.javapractice.codingtest.inflearn;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

public class StackAndQueueChapter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split("");
        Stack<String> stack = new Stack();
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals("(")){
                stack.push(arr[i]);
            }
            else {
                stack.pop();
                if(arr[i - 1].equals("(")){
                    answer += stack.size();

                }
                else {
                    answer++;
                }
            }
        }

        bw.write(answer+ "\n");
        bw.flush();
    }
}
