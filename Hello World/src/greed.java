
/*
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class greed {

	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		int num=Integer.parseInt(br.readLine());
		int sum=0;
		
		String[] arr1=br.readLine().split(" ");
		String[] arr2=br.readLine().split(" ");
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		for(int i=0;i<num;i++) {
			sum+=Integer.parseInt(arr1[i])*Integer.parseInt(arr2[num-i-1]);
		}
		
		System.out.println(sum);
		
	}
}

*/


/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/*
public class greed{
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		int cnt=0;
		
		for(int i=0;i<str.length();i++) {
			
			if(str.charAt(0)=='1') { //1로 시작할때
				if(i<str.length()-1) { //마지막 숫자 전까지
					if(str.charAt(i)==str.charAt(i+1)) {
						continue;
					}else if(str.charAt(i)=='1'&&str.charAt(i+1)=='0'){ //바뀌는 지점에서 증가
						cnt++;
					}
				}
			}
			else {//0으로 시작할때
				if(i<str.length()-1) { //마지막 숫자 전까지
					if(str.charAt(i)==str.charAt(i+1)) { //1과 같으면 진행
						continue;
					}else if(str.charAt(i)=='0'&str.charAt(i+1)=='1'){ //바뀌는 지점에서 증가
						cnt++;
					}
				}
				
			}
		}
		System.out.println(cnt);
	}
}
*/
//0으로 시작한다. 001100110011001100 묶음의수 0 - 5 1 - 4 따라서 1을 돌림 
//            000011001100110011 묶음의수 0 - 4 1- 4 따라서 아무거나 다됨
//1로 시작한다.  11001100110011 묶음의 수 0 - 3 1 - 4 따라서 0을 돌려
//            1100110011000 묶음의 수 1 - 3 0 - 3 따라서 아무거나 해도됨   


/*


import java.io.BufferedReader;




import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class greed{
public static void main(String[] args)throws IOException {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	long num=Long.parseLong(br.readLine());
	long i=0,sum=0;
	if(num==1) System.out.println(1);
	for(i=1;sum<=num;i++) {
		sum+=i;
		}
	System.out.println(i-2);
	
	}
}

*/

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class greed{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		for(int i=0;i<num;i++) {
			int num2=Integer.parseInt(br.readLine());
			String[] str=br.readLine().split(" "); 
			
			int[] arr=new int[str.length];
			int[] arr2=new int[str.length];
			
			for(int j=0;j<str.length;j++) {
				arr[j]=Integer.parseInt(str[j]);
			}
			
			Arrays.sort(arr); //정렬 완료
			
			if(num2%2==0) { //짝수일때
				int k=0;
				for(int j=0;j<arr.length;j++) {
					
					if(j%2==0) {
						arr2[k++]=arr[j]; //짝수 자리에 숫자들을 앞에서부터 담음
					}
					else {
						arr2[arr.length-k]=arr[j]; //홀수 자리 숫자들을 뒤에서 부터 담음 결국 1234  1342
					}
				}
				
				int gap=Math.abs(arr2[arr2.length-1]-arr2[0]); //끝과 처음 차이를 기준으로 시작. 절댓값 씌워서 알아내기
				for(int j=0;j<arr2.length-1;j++) {
					if(gap<Math.abs(arr2[j+1]-arr2[j])) gap=Math.abs(arr2[j+1]-arr2[j]);//차이 큰거 업데이트
				}
					System.out.println(gap); 

			}
			
			else { //길이가 홀 수 일 때
				int k=0;
				for(int j=0;j<arr2.length-1;j++) {
						
						if(j%2==0) {
							arr2[k++]=arr[j]; //짝수 자리를 앞에서 부터 넣는다  ex 7이면 0123
						}
						
						else {
							arr2[arr2.length-k]=arr[j]; //홀수 자리를 뒤에서부터 넣는다 654
						}
				}
				arr2[arr2.length/2]=arr[arr.length-1]; //제일 큰 숫자를 가운데에 넣는다. 7이면 3
				
				int gap=Math.abs(arr2[arr2.length-1]-arr2[0]); //끝과 처음 차이를 기준으로 시작
				for(int j=0;j<arr2.length-1;j++) {
					if(gap<Math.abs(arr2[j+1]-arr2[j])) gap=Math.abs(arr2[j+1]-arr2[j]);		
				}
					System.out.println(gap);	
			}
		}
	}
}

*/

//햄버거 문제

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class greed{
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split(" ");
		int num=Integer.parseInt(str[0]);
		int range=Integer.parseInt(str[1]);
		String[] line=br.readLine().split("");
		int cnt=0;
		
		for(int i=0;i<line.length;i++) {
			//System.out.println(line[i].equals("P"));
			if(line[i].equals("P")) { //요소가 P일때
				for(int j=i-range;j<=i+range;j++) { //기준이 2라면 앞에서부터 뒤까지 반복해야함. 물론 배열의 길이에 유의.
					if(j>=0&j<line.length) {
						if(line[j].equals("H")) {
						cnt++;
						line[j]="D";
						break;
						}
					}	
				}	
			}
		}
		System.out.println(cnt);
	}
}
*/
//p는 사람 h는 햄버거
//equals 함수 중요

/*20 2
HHHHHPPPPPHPHPHPHHHP
*/

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class greed{
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		String[] str=br.readLine().split(" "); 
		int[] arr=new int[str.length];
		int sum=0; //뽑힌 값들을 곱하고 더할 때 쓰임
		for(int i=0;i<str.length;i++) arr[i]=Integer.parseInt(str[i]);
		Arrays.sort(arr);
		
		for(int i=num-1;i>0;i--) {
			sum+=arr[i]*arr[i-1];
			arr[i-1]=arr[i]+arr[i-1];
			
		}
		
		System.out.println(sum);
	}
}

*/

//폴리노미노 

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class greed{
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split("-"); //마이너스로 나눔
		

		for(int i=0;i<str.length;i++) {
			int sum=0;
			if(str[i].length()>2) {
				String[] str2=str[i].split("\\+");
				for(int j=0;j<str2.length;j++) {
					sum+=Integer.parseInt(str2[j]);
				}
				str[i]=String.valueOf(sum);
			}	
		}
		
		int result=Integer.parseInt(str[0]);
		for(int i=1;i<str.length;i++) {
			result-=Integer.parseInt(str[i]);
		}
		System.out.println(result);
	}
}
*/
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class greed {
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=1000-Integer.parseInt(br.readLine());
		int cnt=0;
		while(num>0) {
			if(num>=500) {num-=500;cnt++;}
			else if(num>=100) {num-=100;cnt++;}
			else if(num>=50) {num-=50;cnt++;}
			else if(num>=10) {num-=10;cnt++;}
			else if(num>=5) {num-=5;cnt++;}
			else {num-=1;cnt++;}
		}
		System.out.println(cnt);
	}
}
*/

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class greed{
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		int[] arr=new int[num];
		int max=0;
		for(int i=0;i<num;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int j=num;
		for(int i=0;i<num;i++) {
			int sum=arr[i]*j--;
			if(max<sum)max=sum;
		}
		System.out.println(max);
	}
}

*/

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class greed{
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		str=str.replace("XXXX","AAAA");
		str=str.replace("XX","BB");
		if(str.contains("X"))System.out.println(-1); //X가 남아있다면 -1 출력
		else System.out.println(str);
		str.toLowerCase()
	}
}
*/
/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class greed {
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split(" ");
		int x=Integer.parseInt(str[0]);
		int y=Integer.parseInt(str[1]);
		int cnt=0;
		while(y>x) {
			if(y%10==1) {
				y/=10;
				cnt++;
				//System.out.println(y);
			
			}
			else if(y%2==0) {
				y/=2;
				cnt++;
				//System.out.println(y);
			}
			else {
				break;
			}
		}
		if(y==x)System.out.println(++cnt);
		else System.out.println(-1);
		
	}
}

//5 /2 ==2 cnt =1  2>2 x로 움직임 근데 y==x 그래서 2가나옴

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class greed{
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split(""); //모든 요소로 나눈다.
		int i=0;
		for(int j=0;j<str.length;j++) {
			if(i==0&str[j].equals("U"))i++;
			if((i==1 ||i==3)&str[j].equals("C"))i++;
			if(i==2 & str[j].equals("P"))i++;
		}
		if(i==4)System.out.println("I love UCPC");
		else System.out.println("I hate UCPC");
	}
}