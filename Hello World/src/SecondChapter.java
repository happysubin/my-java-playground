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
