package happysubin.javapractice.codingtest.inflearn;

import java.io.*;
import java.util.Stack;

public class StackAndQueueChapter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split("");
        Stack<String > stack = new Stack();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(")")){

                if(stack.size() >= 1) stack.pop();
                else {
                    bw.write("NO");
                    bw.flush();
                    return;
                }

            }
            else{
                stack.push(arr[i]);
            }
        }

        if(stack.size() != 0) bw.write("NO");
        else bw.write("YES");
        bw.flush();
    }
}
