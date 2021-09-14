//백준 문자열 문제들

//아스키 코드
/*
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        char a=sc.next().charAt(0);
        System.out.print((int)a);
    }
}
*/

/*숫자의 합
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        String[] str=sc.next().split("");
        int sum=0;
        for(int i=0;i<num;i++){
            sum=sum+Integer.parseInt(str[i]);
        }
        System.out.print(sum);
    }
}
*/
// 자바는 int 배열을 선언하면 초기값은 0이고 string 배열의 초기값은 null이다.

//백준 문자열반복 2675
/*
import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int cnt=0;
		
		for(int i=0;i<num;i++) {
			cnt=sc.nextInt();
			String[] arr=sc.next().split("");
			
			for(int j=0;j<arr.length;j++) {
				for(int z=0;z<cnt;z++) {
					System.out.print(arr[j]);
				}
			}
			System.out.println();
		}
		
	}
}
*/
/*
import java.util.Scanner;
//소문자만 처음에 사용된 인덱스를 표시
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String name=sc.next(); //이름을 받는다
        int[] cnt=new int[26]; // 알파벳을 위한 배열
        
        for(int i=0;i<cnt.length;i++){
            cnt[i]=-1; //사용하지 않은 알파벳은 -1을 출력하므로 -1로 초기화
        }
        for(int i=0;i<name.length();i++){
            char content=name.charAt(i); //이름 문자열의 문자들을 다꺼낸다
            if(cnt[content-'a']==-1) { //초기화된 값이 아니면 값을 저장하지 않는다.
            	cnt[content-'a']=i;
            }// a를 기준으로 소문자만 사용되므로 a를 빼서 인덱스로 사용 b의 인덱스는 1 c는 2 이런 식 
            //사용된 자리는 i를 통해 나타내므로 i를 배열의 인덱스 요소로 저장.
        }
        for(int i=0;i<cnt.length;i++){
            System.out.print(cnt[i]+" ");
        }
        
    }
}
*/
// 백준1157 단어 공부이다
/*import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String word=sc.next().toUpperCase();
		sc.close();
		int[] arr=new int[26];
		int max;
		for(int i=0;i<word.length();i++) {
			arr[word.charAt(i)-'A']++;//문자열을 문자로 바꾸고 소문자로 사용하면 증가시킴.
		}
		max=0;
		//max=arr[0]이라 했다가 계속 틀렸었다. 이유가 무엇일까..?
		//바로 찾았다. a일 경우 오류가 발생한다. i+'A' 에서 i인 0이 존재하지 않기 때문이다!!!세상에!
		char answer='?';
		for(int i=0;i<arr.length;i++) {
			if(max<arr[i]) {
				max=arr[i];
				answer=(char)(i+'A');
			}else if(max==arr[i]) {
				answer='?';
			}
		}
		System.out.print(answer);
	}
}
*/

//백준 1152 단어 개수구하기
/*
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] arr=sc.nextLine().trim().split(" ");
		// 띄어쓰기가 들어갈경우 split가 배열로 바꿔서 오류가 난다. 무조건 1이 있는거다.
		//띄어쓰기만하면 배열요소에 아무것도 들어가지 않았다. 그래서 그걸 체크하고 다른것은 정상적으로 보낸다
		if(arr[0].equals("")) {
			System.out.print(0);
		}else {
			System.out.print(arr.length);
		} 
		
	}
}
*/

//백준 2908 숫자 뒤집어서 큰수 찾기
/*
import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String[] numbers=sc.nextLine().split(" ");
		for(int i=0;i<2;i++) {
			StringBuffer sb=new StringBuffer(numbers[i]);
			numbers[i]=sb.reverse().toString(); 
			//sb객체 생성후 사용가능한 reverse 메소드를 이용해서 뒤집고 타입이 맞지않으니 문자열로 바꾼다.
		}
		int a=Integer.parseInt(numbers[0]);
		int b=Integer.parseInt(numbers[1]);
		if(a>b) {
			System.out.print(a);
		}
		else {
			System.out.print(b);
		}
	}
}
*/

// 문자열에서 알파벳이 나올 시 알파벳 배열을 선언할 생각을 해야한다!!!

//자바 5622 전화기 문제 이건 내풀이.
/*import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String arr=sc.next();
		int sum=0;
		for(int i=0;i<arr.length();i++) {
			switch(arr.charAt(i)){
			case'A':
			case'B':
			case'C':
				sum+=3;
				break;
			case'D':
			case'E':
			case'F':
				sum+=4;
				break;
			case'G':
			case'H':
			case'I':
				sum+=5;
				break;
			case'J':
			case'K':
			case'L':
				sum+=6;
				break;
			case'M':
			case'N':
			case'O':
				sum+=7;
				break;
			case'P':
			case'Q':
			case'R':
			case'S':
				sum+=8;
				break;
			case'T':
			case'U':
			case'V':
				sum+=9;
				break;
			case'W':
			case'X':
			case'Y':
			case'Z':
				sum+=10;
				break;
	
			}
		}
		System.out.print(sum);
	}
}
/*이건 인터넷에서 찾은 풀이 생각의 전환이 정말 놀라웠다.
아스키코드값을 기준으로 나눴다. 한 수 배웠다..
전체 코드 말고 기준을 나누는 부분만 가져왔다.
			if(value < 68) count += 3;
			else if(value < 71) count += 4;
			else if(value < 74) count += 5;
			else if(value < 77) count += 6;
			else if(value < 80) count += 7;
			else if(value < 84) count += 8;
			else if(value < 87) count += 9;
			else count += 10;

*/

//진짜 개고생했다
//크로아티아 알파벳 문제
/*
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next().trim();
		int cnt=0;
		int len=str.length();
		for(int i=0;i<len;i++) {
			cnt++;
			switch(str.charAt(i)) {
			case'c':
				if(i<len-1&&(str.charAt(i+1)=='='||str.charAt(i+1)=='-')) {
					i++;
				}
				break;
			case'd':
				if(i<len-2&&str.charAt(i+1)=='z'&&str.charAt(i+2)=='=') {
						 i+=2;
				}
				else if(i<len-1&&str.charAt(i+1)=='-') {
						 i++;
				}
				break;
			case'l':
			case'n':
				if(i<len-1&&str.charAt(i+1)=='j') {
						i++;
				}
				break;
			case's':
			case'z':
				if(i<len-1&&str.charAt(i+1)=='=') 
					{
						i++;
					}
				break;
			}
			
		}
		sc.close();
		System.out.print(cnt);
	}
}
*/
//오류가 발생하는데 원인은 바로 마지막에 c가들어온다고 생각해보자.
//그러면 c는 i+1을 하며 다음 문자를 찾는데 문자열의 마지막이므로 더 찾을 문자가 없어 오류가 발생한다.
//그러므로 조건문을 전체적으로 추가하자.
//스위치문은 해당하는 케이스를 찾으면 수행하고 break가 없으면 밑에 경우를 실행한다. 세성



//왜 틀렸는지 연구해보자
/*
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next().trim();
		int cnt=0;
		for(int i=0;i<str.length();i++) {
			switch(str.charAt(i)) {
			case'c':
				if(i<str.length()-1) {
					if(str.charAt(i+1)=='='||str.charAt(i+1)=='-') {
						i++;
					}
				}
				break;
			case'd':
				//여기가 문제였다.
//if문은 성공하면 다음 else if 문을 안돌린다. 그런데 외부 if는 성공하고 내부 if 가 실패한다고 가정하면
// else if 가 맞을 수도 있는데 else if를 갈 수가 없다. 그래서 이런 경우를 예방하기위해 한번에 체크해줘야한다.
				//여기가 문제였다 해결!!!!
				/*if(i<str.length()-1) {
					if(str.charAt(i+1)=='-') {
						 i++;
					}
				}	
				else if(i<str.length()-2) {
					if(str.charAt(i+1)=='z'&&str.charAt(i+2)=='=') {
						 i+=2;
					}
				}
				break;
				//따라서 이게 맞다.
				
				if(i<str.length()-1&&str.charAt(i+1)=='-') {
						 i++;	
				}	
				else if(i<str.length()-2&&str.charAt(i+1)=='z'&&str.charAt(i+2)=='=') {
						 i+=2;
				}
				 break;
			case'l':
			case'n':
				if(i<str.length()-1) {
					if(str.charAt(i+1)=='j') {
						i++;
					}
				}
			break;
			case's':
			case'z':
				if(i<str.length()-1) {
					if(str.charAt(i+1)=='=') {
						i++;
					}
				}
				break;
			}
			cnt++;
		}
		sc.close();
		System.out.print(cnt);
	}
}
*/

//피보나치 수열
/*
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int result=fibo(n);
		System.out.print(result);
	}
	public static int fibo(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		return fibo(n-1)+fibo(n-2);
	}
}
*/


//백준 25 88
/*
import java.util.Scanner;

public class brute {
	public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	int num=sc.nextInt();
	String[] num2=sc.next().split("");
	for(int i=2;i>=0;i--) {
			System.out.printf("%d\n", num*Integer.parseInt(num2[i]));
		}	
	String fin = String.join("",num2);
	System.out.printf("%d",num*Integer.parseInt(fin));
	}
}

*/
/*
import java.util.Scanner;
public class Main{
	public static void main(String args[]) {
	Scanner sc=new Scanner(System.in);
	int a=sc.nextInt();
	int b=sc.nextInt();
	System.out.printf("%d\n", a+b);
	System.out.printf("%d\n", a-b);
	System.out.printf("%d\n", a*b);
	System.out.printf("%d\n", a/b);
	System.out.printf("%d\n", a%b);
	}
}
*/

/*
import java.util.Scanner;
public class Main{
	public static void main(String args[]) {
	Scanner sc=new Scanner(System.in);
	int A=sc.nextInt();
	int B=sc.nextInt();
	int C=sc.nextInt();
	System.out.printf("%d\n",(A+B)%C);
	System.out.printf("%d\n",((A%C)+(B%C))%C);
	System.out.printf("%d\n",(A*B)%C);
	System.out.printf("%d\n",((A%C)*(B%C))%C);
	
	}
}

*/
/*
import java.util.Scanner;

public class Main{
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		
		if(a>b) System.out.println(">");
		else if(a<b) System.out.println("<");
		else System.out.println("==");
	}
}
*/

//시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.
/*
import java.util.Scanner;

public class Main{
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int score=sc.nextInt();
		if(score>=90) System.out.println("A");
		else if(score>=80) System.out.println("B");
		else if(score>=70) System.out.println("C");
		else if(score>=60) System.out.println("D");
		else  System.out.println("F");
		
	}
	
	
}
*/

/*
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a % 4 == 0 && (a % 100 != 0 || a % 400 == 0)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
        
    }
}
*/

/*
import java.util.Scanner;

public class Main{
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		int y=sc.nextInt();
		if (x>0&&y>0)System.out.println("1");
		else if (x<0&&y>0)System.out.println("2");
		else if (x>0&&y<0)System.out.println("4");
		else System.out.println("3");
	}
}
*/

//알람시계 문제
/*
import java.util.Scanner;

public class Main{
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int hour=sc.nextInt();
		int min=sc.nextInt();
		if(hour==0&&min<45) {
			int minus=45-min;
			System.out.printf("%d %d",23,60-minus);
		}
		else if(min<45) {
			int minus=45-min;
			System.out.printf("%d %d",hour-1,60-minus);
		}
		else {
			System.out.printf("%d %d",hour,min-45);
		}
	}
}
*/

/*
import java.util.Scanner;
public class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        for(int i=num;i>0;--i) {
        	System.out.printf("%d\n",i);
        }
        
    }
}
*/

/*
import java.util.Scanner;

public class Main{
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("반지름과 원의 중심을 입력하세요");
		int radius=sc.nextInt();
		int centerX=sc.nextInt();
		int centerY=sc.nextInt();
		
		System.out.println("좌표를 입력하세요");
		int pointX=sc.nextInt();
		int pointY=sc.nextInt();
		
		double distanceY=Math.pow((pointY-centerY),2);
		double distanceX=Math.pow((pointX-centerX),2);
		
		double pointDistance=Math.sqrt(distanceX+distanceY);
		
		if(pointDistance>radius) {
			System.out.println("원 밖에 있습니다.");
		}else {
			System.out.println("원 안에 있습니다.");
		}
		
	}
}
*/

/*
public class Main{
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("입력 :");
		int num1=sc.nextInt();
		System.out.println(Integer.toBinaryString(num1));
		
		System.out.println("입력 : bit의 위치 (1 이상)");
		int place=sc.nextInt();
		System.out.println("출력 :" +((num1>>>--place)&1));
	}
}

*/

/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;  
import java.util.StringTokenizer;

public class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		//Buffer reader,writer 콘솔에서 사용법
		
		int num=Integer.parseInt(br.readLine());//읽어 들이고 정수형으로 캐스팅
		StringTokenizer st; //사용자가 지정하는 기준을 바탕으로 문자열을나눈다.
		
		for(int i=0; i<num;i++) {
			st=new StringTokenizer(br.readLine()," "); //한줄을 읽고 띄어쓰기 기준으로 나눈다
			bw.write(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())+"\n"); //버퍼에 작성
			//nextToken 메소드는 문자열에서 다음 토큰을 가져온다
		}
		bw.flush(); //이걸 해야 버퍼에 작성되었던 것들이 모두 나온다.
		bw.close();
		br.close();
	}
}
*/

//백준 2741
/*
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class Main{
	public static void main(String args[]) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int num=Integer.parseInt(br.readLine());
		for(int i=1;i<=num;i++) bw.write(i+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
*/

/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main{
	public static void main(String args[])throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int num=Integer.parseInt(br.readLine());
		for(int i=num;i>=1;i--)bw.write(i+"\n");
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
*/

/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num=Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int a,b;
		for(int i=1;i<=num;i++) {
			st=new StringTokenizer(br.readLine()," ");
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			bw.write("Case #"+i+": "+a+" + "+b+" = "+(a+b)+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
*/

/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main{
	public static void main(String args[])throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int num=Integer.parseInt(br.readLine());
		for(int i=1;i<=num;i++) {
			for(int j=1;j<=i;j++) {
				bw.write("*");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
*/

/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main{
	public static void main(String args[])throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num=Integer.parseInt(br.readLine());
		for(int i=1;i<=num;i++) {
			for(int j=num-i;j>=1;j--)bw.write(" ");
			for(int z=1;z<=i;z++)bw.write("*");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
*/
/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
	public static void main(String args[])throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int num=Integer.parseInt(st.nextToken());
		int max=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<num;i++) {
			int content=Integer.parseInt(st.nextToken());
			if(content<max)bw.write(content+" ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
*/
/*
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
	public static void main(String args[])throws IOException{
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int first=Integer.parseInt(st.nextToken());
		int second=Integer.parseInt(st.nextToken());
		while(first!=0&&second!=0) {
			bw.write(first+second+"\n");
			st=new StringTokenizer(br.readLine()," ");
			first=Integer.parseInt(st.nextToken());
			second=Integer.parseInt(st.nextToken());
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
*/


/*
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
	public static void main(String args[])throws IOException{
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		String str="";
	
		while((str=br.readLine())!=null) {
			st=new StringTokenizer(str," "); 
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			bw.write(a+b+"\n");
		}
		bw.flush();
		
		bw.close();
		br.close();
	}
}
*/

/*
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main{
	public static void main(String[] args)throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
	
		int num=Integer.parseInt(br.readLine());
		
		int result=num;
		int cnt=0;
		
		while(true) {
			num=(( num % 10 ) * 10) + (((num / 10) + (num % 10)) % 10);
			//입력할 때 num이 바뀌어야하므로 result 는 안된다.
			cnt++;	
			if(num==result)break;
		}
		
		System.out.println(cnt);
	}
}
*/

//백준 배열 문제들

/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num=Integer.parseInt(br.readLine());
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int content=Integer.parseInt(st.nextToken());
		int max=content;
		int min=content;
		for(int i=1;i<num;i++) { //한번 꺼냈으니 총 횟수에서 1개를 줄인다.
			content=Integer.parseInt(st.nextToken());
			if(max<content)max=content;
			if(min>content)min=content;
		}
		bw.write(min+" "+max);
		bw.flush();
		bw.close();
		br.close();
	}
}
*/

/*
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int max=0,cnt=1;
		for(int i=1;i<=9;i++) {
			int num=Integer.parseInt(br.readLine());
			if(num>max) {
				max=num;
				cnt=i;
			}
		}
		bw.write(max+"\n"+cnt);
		bw.flush();
		bw.close();
		br.close();
		
	}
}

*/

/*

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int a=Integer.parseInt(br.readLine());
		int b=Integer.parseInt(br.readLine());
		int c=Integer.parseInt(br.readLine());
		int num=a*b*c;
		int[] arr=new int[10];
		
		String[] element=String.valueOf(num).split("");
		for(int i=0;i<element.length;i++) {
			int x=Integer.parseInt(element[i]);//1이야
			arr[x]++;
		}
		for(int i=0;i<arr.length;i++) {
			bw.write(arr[i]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
*/

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int num=Integer.parseInt(br.readLine());
		
		for(int i=0;i<num;i++) {
			String[] str=br.readLine().split(" ");
			int sum=0;
			int cnt=Integer.parseInt(str[0]);
			int moreThanAverage=0;
			
			for(int j=1;j<=cnt;j++) {
				sum+=Integer.parseInt(str[j]);
			}
			
			int average=sum/cnt;

			for(int j=1;j<=cnt;j++) {
				if(average<Integer.parseInt(str[j]))moreThanAverage++;
			}
			System.out.printf("%.3f%%\n",((double)moreThanAverage/cnt)*100);
		}
		br.close();
	}
}
*/

//1193

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		
		for(int i=0;i<num;i++) {
			String[] str=br.readLine().split("X");//X를 기준으로 나눔
			int score=0;
			for(int j=0;j<str.length;j++) {// 나눈 개수만큼 반복
				if(str[j]!="") {
					String[] Olength=str[j].split(""); //그 안의 O가 있는 걸 다시 나눔.
					//예를 들어 OOXXOXXOOO  OO   O OOO 이렇게 3개가 있을것임.
					//그러나 X였던곳은 ""이런 상태임.고로 이것도 체크해야함
					for(int z=1;z<=Olength.length;z++) {
						score+=z; //길이가 1이면 1만 더함 2이면 1 2 3이면 1 2 3!!!
					}
				}	
			}
			System.out.println(score);
		}
		
	}
}
*/

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine()); //총 점수 개수를 받음
		double sum=0;
		
		String[] scores=br.readLine().split(" "); //점수를 받고 띄어쓰기로 구분
		double max=Double.parseDouble(scores[0]);
		for(int i=1;i<num;i++) {
			double score=Double.parseDouble(scores[i]);
			if(max<score)max=score; //최대값을 결정
			
		}
		
		for(int i=0;i<num;i++) {
			double score=Double.parseDouble(scores[i]);
			double newScore=score/max*100;
			scores[i]=String.valueOf(newScore);
		}
		
		for(int i=0;i<num;i++) {
			
			sum+=Double.parseDouble(scores[i]);
			
		}
		System.out.printf("%.2f",sum/num);
	}
}
*/

/*
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int[] arr=new int[42];
		int cnt=10;
		
		for(int i=0;i<10;i++) {
			int num=Integer.parseInt(br.readLine())%42;
			if(arr[num]==1) {
				cnt--;
				continue;
			}else {
				arr[num]=1;
				
			}
		}
		System.out.println(cnt);
	}
}
*/

/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
	
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		bw.write((int) (Math.pow(2, n) - 1) + "\n");
		hanoi(n,1,2,3);
		bw.flush();
		bw.close();
		br.close();
	}
	public static void hanoi(int n,int a, int b, int c) throws IOException{
		if(n==1) {
			bw.write(a+" "+c+"\n");
			return;
		}
		else {
			hanoi(n-1,a,c,b); //n-1 개를 a에서 b로 이동
			bw.write(a+" "+c+"\n");//1개를 a에서 c로 이동
			hanoi(n-1,b,a,c); //n-1개를 b에서 c로 이동
		}
	}
}
*/

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		int cnt=0;
		
		String[] str=br.readLine().split(" ");
		for(int i=0;i<num;i++) {
			int checkingNum=Integer.parseInt(str[i]);
			int check=0;
			if(checkingNum==1)continue;
			
			for(int j=2;j<=checkingNum;j++) {
				if(checkingNum%j==0) {
					check++;
				}
			}
			if(check==1) {
				cnt++;
			}
			
		}
		System.out.println(cnt);
		br.close();
	}
}
*/

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int sum=0;
		int low=Integer.parseInt(br.readLine()); 
		int high=Integer.parseInt(br.readLine()); 
		int min=high;
		for(int i=low; i<=high;i++) { //받은 수의 전체 범위를 돌린다.
			int cnt=0;
			
			if(i==1)continue;
			
			for(int j=2;j<=i;j++) {
				if(i%j==0) {
					cnt++;
				}
			}
			
			if(cnt==1) {
				sum+=i;
				if(i<min)min=i;
			}
		}	
		
		
		if(sum !=0) {
			System.out.println(sum);
			System.out.println(min);
		}
		else {
			System.out.println(-1);
		}
	}
}
*/

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
		while(true) {
			String[] arr=br.readLine().split(" ");
			int a=Integer.parseInt(arr[0]);
			int b=Integer.parseInt(arr[1]);
			int c=Integer.parseInt(arr[2]);
			if(a==0||b==0||c==0)break;
			if(Math.pow(a, 2)+Math.pow(b, 2)==Math.pow(c, 2))System.out.println("right");
			else if(Math.pow(a, 2)+Math.pow(c, 2)==Math.pow(b, 2))System.out.println("right");
			else if(Math.pow(c, 2)+Math.pow(b, 2)==Math.pow(a, 2))System.out.println("right");
			else System.out.println("wrong");
		}
	}
}

*/

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] a=br.readLine().split(" ");
		String[] b=br.readLine().split(" ");
		String[] c=br.readLine().split(" ");
	
		if(Integer.parseInt(a[0])==Integer.parseInt(b[0])) System.out.print(c[0]);
		else if(Integer.parseInt(b[0])==Integer.parseInt(c[0])) System.out.print(a[0]);
		else System.out.print(b[0]);
		
		if(Integer.parseInt(a[1])==Integer.parseInt(b[1])) System.out.print(" "+c[1]);
		else if(Integer.parseInt(b[1])==Integer.parseInt(c[1])) System.out.print(" "+a[1]);
		else System.out.print(" "+b[1]);
		
		
	}
}

*/

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		int cnt=num;
		for(int i=0;i<num;i++) {
			String arr=br.readLine();
			int check[]=new int[26];
			for(int j=1;j<arr.length();j++) {
				char content=arr.charAt(j);
					char beforeContent=arr.charAt(j-1);
					if(content==beforeContent&&check[beforeContent-'a']==0)continue;
					else if(check[beforeContent-'a']==0&&content!=beforeContent){
						check[beforeContent-'a']=1;
					}
					else if(check[beforeContent-'a']==1) {
						cnt--;
						break;
					}
					if(j==arr.length()-1&&check[content-'a']==1) {
						cnt--;
						break;
					}		
			}	
		}
		System.out.println(cnt);
	}
}
*/

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		int[] arr=new int[num];
		
		for(int i=0;i<num;i++) {
			int element=Integer.parseInt(br.readLine());
			arr[i]=element;
		}
		
		int i,j,key;
		
		for( i=1;i<num;i++) {
			key=arr[i];
			
			for( j=i-1; j>=0&arr[j]>key ; j--) { //자바는 만약 &&문이 앞에서 거짓이면 뒤에것은 확인하지 않는다.
				//그래서 순서도 따져야하는 거 같다.
				arr[j+1]=arr[j];
			}
			arr[j+1]=key;
		}
		
		for( i=0;i<num;i++) {
			System.out.println(arr[i]);
		}
		
	}
}
//&를 쓰도록 하자. 이게 앞 뒤 조건 둘다 검사한다.

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		int i; //층을 나타낼 변수
		int sum=0;//이번 계층까지 합한 것들
		for( i=1;sum<num;i++) {
			sum+=i;
		}
		i--; //증가시키고 조건문에서 막히기 때문에 i--실행. i가 층임
		int underNums=sum-i; //이번 계층 아래에 있는 것들
		int leaveNums=num-underNums;//현재 계층에서 (자기를 포함하고) 아래 계층을 빼고 남은 숫자들 
		if(i%2==0) { //짝수
			System.out.println(leaveNums+"/"+(i-leaveNums+1));
		}
		else {//홀수
			System.out.println((i-leaveNums+1)+"/"+leaveNums);
		}
	}
}