
/*
import java.io.BufferedReader;
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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

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
					}else if(str.charAt(i)=='1'&&str.charAt(i+1)=='0'){
						cnt++;
					}
				}
			}
			else {//0으로 시작할때
				if(i<str.length()-1) { //마지막 숫자 전까지
					if(str.charAt(i)==str.charAt(i+1)) { //1과 같으면 진행
						continue;
					}else if(str.charAt(i)=='0'&str.charAt(i+1)=='1'){
						cnt++;
					}
				}
				
			}
		}
		System.out.println(cnt);
	}
}