import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ThirdChapter {
    public int [] solution(String s){
        String arr[]=s.replaceAll("  "," ").split(" ");
       
        int[] answer=new int[arr.length];
        for(int i=0;i<arr.length;i++)answer[i]=Integer.parseInt(arr[i]);
        Arrays.sort(answer);
        return answer;
    }    

    public static void main(String[] args)throws IOException{
        ThirdChapter T=new ThirdChapter();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num1=Integer.parseInt(br.readLine());
        String arr1=br.readLine();
        int num2=Integer.parseInt(br.readLine());
        String arr2=br.readLine();
        arr1=arr1+" "+arr2;
        for(int x:T.solution(arr1))System.out.print(x+" ");
    }
}
