
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


