import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class Example{
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		String[] str=br.readLine().split(" ");
		int[] arr=new int[num];
		int score=0;
		
		for(int i=0;i<num;i++)arr[i]=Integer.parseInt(str[i]);
		
		Arrays.sort(arr);
		
		for(int i=num-1;i>0;i--) {
			score+=arr[i]*arr[i-1];
			arr[i-1]=arr[i]+arr[i-1];
		}
		System.out.println(score);
		
	}
}