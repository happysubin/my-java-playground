
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Queue {
	static int[] arr=new int[10000];
	static int front=0;
	static int back=0;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		
		for(int i=0;i<num;i++) {
			String[] str=br.readLine().split(" ");
			if(str[0].equals("push")) {
				int n=Integer.parseInt(str[1]);
				push(n);
			}
			else if(str[0].equals("pop")) {
				int n=pop();
				System.out.println(n);
			}
			else if (str[0].equals("size")) {
				int n=size();
				System.out.println(n);
			}
			else if (str[0].equals("empty")) {
				int n=empty();
				System.out.println(n);
			}
			else if (str[0].equals("front")) {
				int n=front();
				System.out.println(n);
			}
			else if (str[0].equals("back")) {
				int n=back();
				System.out.println(n);
			}
		}
		
	}
	
	public static void push(int n) {
		arr[back++]=n;
	};
	
	public static int pop() {
		if(front==back)return -1;
		return arr[front++];
	};
	
	public static int size() {
		 return back-front;
	};
	
	
	public static int empty() {
		if(front==back)return 1;
		else return 0;
	};
	
	public static int front() {
		if(front==back)return 1;
		return arr[front];
	};
	public static int back() {
		if(front==back)return 1;
		return arr[back-1];
	};
}
