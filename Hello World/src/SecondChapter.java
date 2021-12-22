

/*
import java.io.*;

public class SecondChapter {
    public void solution(String s,int num){
        s+=" 0";//i 범위를 위해 추가했다.
        String[] arr=s.split(" ");

        for(int i=0;i<arr.length-1;i++){
            if(i==0){
                System.out.print(arr[i]+" ");
            } 
            if(Integer.parseInt(arr[i])<=Integer.parseInt(arr[i+1]))System.out.print(arr[i+1]+" ");
            
        }
    }
    public static void main(String[] args)throws IOException{
        SecondChapter T=new SecondChapter();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        String str=br.readLine();
        T.solution(str,num);
    } 
}
*/

/*

import java.util.*;
class Main {	
	public ArrayList<Integer> solution(int n, int[] arr){
		ArrayList<Integer> answer = new ArrayList<>();
		answer.add(arr[0]);
		for(int i=1; i<n; i++){
			if(arr[i]>arr[i-1]) answer.add(arr[i]);
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
		}
		for(int x : T.solution(n, arr)){
			System.out.print(x+" ");
		}
	}
}


*/


/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecondChapter{
	public int solution(String s,int num){
		int answer=1;
		String[] arr=s.split(" ");
		int max=Integer.parseInt(arr[0]);
		for(int i=1;i<arr.length;i++){
			if(max<Integer.parseInt(arr[i])){
				max=Integer.parseInt(arr[i]);
				answer++;
			}
		}
		return answer;
	}
	public static void main(String[] args)throws IOException{
		SecondChapter T=new SecondChapter();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		String str=br.readLine();
		System.out.println(T.solution(str, num));
	}
}
*/

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecondChapter{
	public String[] solution(int num, String A, String B){
		String[] answer=new String[num];
		char[] a=A.replaceAll(" ","").toCharArray();
		char[] b=B.replaceAll(" ","").toCharArray();

		for(int i=0;i<num;i++){
			if(a[i]==b[i])answer[i]="D";
			else if((a[i]=='1'&b[i]=='3')||(a[i]=='2'&b[i]=='1')||(a[i]=='3'&b[i]=='2'))answer[i]="A";
			else answer[i]="B";
		}
		return answer;
	}
	public static void main(String[] args)throws IOException{
		SecondChapter T=new SecondChapter();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		String A=br.readLine();
		String B=br.readLine();
		for(String x:T.solution(num, A, B)){
			System.out.println(x);
		}		
	}
}

//1 가위 2 바위 3 보

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SecondChapter{

	public int[] solution(int num){
		int f=1;
		int s=1;
		int[] arr=new int[num];
		arr[0]=1;arr[1]=1;
		for(int i=2;i<num;i++){
			int tmp=s;
			s+=f;
			f=tmp;
			arr[i]=s;
		}
		return arr;
	}
	public static void main(String[] args)throws IOException{
		SecondChapter T=new SecondChapter();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		for(int x: T.solution(num)){
			System.out.print(x+" ");
		}
	}
}