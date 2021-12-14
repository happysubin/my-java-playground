
import java.util.Scanner;

public class FirstChapter {
    public static int Solution(String str,String check){
        str=str.toLowerCase();
        check=check.toLowerCase();
        String[] arr=str.split("");
        int num=0;
        
        for(int i=0; i<arr.length;i++){
            if(arr[i].equals(check))num++;
        }
        return num;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        String check=sc.next();
        System.out.println(Solution(str,check));
        sc.close();
    }
}