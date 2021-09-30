
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
		
		for(int i=0;i<num;i++)System.out.print(arr1[i]);
		for(int i=0;i<num;i++)System.out.print(arr2[num-i-1]);
		System.out.println(sum);
		
	}
}
