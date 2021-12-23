
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


/*
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

*/

/*
import java.util.*;
class Main {	
	public int[] solution(int n){
		int[] answer=new int[n];
		answer[0]=1;
		answer[1]=1;
		for(int i=2; i<n; i++){
			answer[i]=answer[i-2]+answer[i-1];
		}
		return answer;
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		for(int x :T.solution(n)) System.out.print(x+" ");
	}
}



import java.util.*;
class Main {	
	public void solution(int n){
		int a=1, b=1, c;
		System.out.print(a+" "+b+" ");
		for(int i=2; i<n; i++){
			c=a+b;
			System.out.print(c+" ");
			a=b;
			b=c;
		}
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		T.solution(n);
	}
}

*/

/*

import java.io.*;

public class SecondChapter{
	public int solution(int num){
		int cnt=0;
		int[] arr=new int[num];
		for(int i=0;i<num;i++){
			arr[i]=i+1; //0번 째 인덱스부터 1,2,3.. 순서대로 들어감
		}
		

		for(int i=1;i<num;i++){ //1로 시작하면 어차피 다 나뉘므로 2부터 시작
			if(arr[i]==-1)continue; //-1은 제낀다
			if(arr[i]*arr[i]<num){ //숫자의 제곱이 최고 숫자보다 작다면 실행
				for(int j=i+1;j<num;j++){
					if(arr[j]%arr[i]==0)arr[j]=-1; //만약 검사하는게 기준 arr[i]로 나누어지면 숫자 0을 넣는다.
				}
			}else{ 	//숫자의 제곱이 최고 숫자 이상이면 정지
				break;
			}
		}

		for(int i=0;i<num;i++){
			if(arr[i]>0)cnt++;
		}

		return cnt-1;
	}
	public static void main(String[] args)throws IOException{
		SecondChapter T=new SecondChapter();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		System.out.println(T.solution(num));
		
	}
}

*/

/*
import java.io.*;


public class SecondChapter{

	public int solution(int n){
		int cnt=0;
		int[] ch=new int[n+1]; //num+1을 해야 num 까지 인덱스가 생긴다.

		for(int i=2;i<=n;i++){ //i는 2부터 n까지
			if(ch[i]==0){ //아직 검사하지 않은 수
				cnt++;
				for(int j=i;j<=n;j=j+i)ch[j]=1; //i의 배수들을 모두 체크
			}
		}

		return cnt;
	}
	public static void main(String[] args)throws IOException{
		SecondChapter T=new SecondChapter();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		System.out.print(T.solution(num));

	}
}
*/


import java.io.*;


public class SecondChapter{

	public String solution(int n,String s){
		String answer="";
		String [] arr=s.split(" ");
		for(int i=0;i<n;i++){
			StringBuffer sb=new StringBuffer(arr[i]);
			String str=String.valueOf(sb.reverse());
			int num=Integer.parseInt(str);
			
			for(int j=2;j<=num;j++){
				if(num%j==0){
					if(j!=num){ // 소수란 1과 자기 자신만으로 나눌 수 있는 수. 고로 2부터 시작해서 자신말고 나뉘는 수가 있으면 멈춤. 만약 이걸 이기면 소수라는 뜻
						break;
					}
					answer+=String.valueOf(num)+" ";
				}

			}
		}
		return answer;
	}
	public static void main(String[] args)throws IOException{
		SecondChapter T=new SecondChapter();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		String s=br.readLine();
		System.out.print(T.solution(num,s));

	}
}