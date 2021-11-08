
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Stack {
	static int[] arr=new int[10000];
	static int top=-1;
	
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
			else if (str[0].equals("top")) {
				int n=top();
				System.out.println(n);
			}
		}
		
	}
	
	public static void push(int n) {
		arr[++top]=n;
	};
	
	public static int pop() {
		if(top==-1)return -1;
		return arr[top--];
	};
	
	public static int size() {
		 return top+1;
	};
	
	
	public static int empty() {
		if(top==-1)return 1;
		else return 0;
	};
	
	public static int top() {
		if(top==-1)return -1;
		return arr[top];
	};
}
