
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
			
			if(num2%2==0) { 
				int k=0;
				for(int j=0;j<arr.length;j++) {
					
					if(j%2==0) {
						arr2[k++]=arr[j];
					}
					else {
						arr2[arr.length-k]=arr[j];
					}
				}
				
				int gap=Math.abs(arr2[arr2.length-1]-arr2[0]);
				for(int j=0;j<arr2.length-1;j++) {
					if(gap<Math.abs(arr2[j+1]-arr2[j])) gap=Math.abs(arr2[j+1]-arr2[j]);		
				}
					System.out.println(gap);

			}
			
			else { //길이가 홀 수 일 때
				int k=0;
				for(int j=0;j<arr2.length-1;j++) {
						
						if(j%2==0) {
							arr2[k++]=arr[j];
						}
						
						else {
							arr2[arr2.length-k]=arr[j];
						}
				}
				arr2[arr2.length/2]=arr[arr.length-1];
				
				
				int gap=Math.abs(arr2[arr2.length-1]-arr2[0]);
				for(int j=0;j<arr2.length-1;j++) {
					if(gap<Math.abs(arr2[j+1]-arr2[j])) gap=Math.abs(arr2[j+1]-arr2[j]);		
				}
					System.out.println(gap);
					
			}
		}
	}
}