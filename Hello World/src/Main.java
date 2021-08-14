//1085
/*
 * import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] str=sc.nextLine().split(" ");
		long a=Integer.valueOf(str[0]);
		long b=Integer.valueOf(str[1]);
		long c=Integer.valueOf(str[2]);
		long d=Integer.valueOf(str[3]);
		double result=((((a*b*c*d)/8)/Math.pow(2, 10))/Math.pow(2, 10));
		System.out.printf("%.1f MB",result);
	}
}
*/

//1086
/*
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] str=sc.nextLine().split(" ");
		long a=Integer.valueOf(str[0]);
		long b=Integer.valueOf(str[1]);
		long c=Integer.valueOf(str[2]);
		double result=((((a*b*c)/8)/Math.pow(2, 10))/Math.pow(2, 10));
		System.out.printf("%.2f MB",result);
	}
}
*/

//1087

/*
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt(); 
        int sum=0;
        for(int i=1;i<=num;i++){
            sum=sum+i;
            if(sum>=num){
                System.out.printf("%d", sum);
                break;
            }
        }
    }
}
*/

//1088
/*
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        for(int i=0;i<=num;i++){
            if(i%3!=0) System.out.printf("%d ",i);
        }
    }
}
*/

//1089
/*
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] str=sc.nextLine().split(" ");
        int a=Integer.valueOf(str[0]);
        int b=Integer.valueOf(str[1]);
        int c=Integer.valueOf(str[2]);
        System.out.printf("%d", a+b*(c-1));
    }
}
*/

//1090
/*
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        String[] str=sc.nextLine().split(" ");
        int a=Integer.valueOf(str[0]);
        int b=Integer.valueOf(str[1]);
        int c=Integer.valueOf(str[2]);
        System.out.printf("%.0f", a*Math.pow(b,c-1));
    }
}
*/

//1091
/*
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] str=sc.nextLine().split(" ");
        long a=Integer.valueOf(str[0]);
        long b=Integer.valueOf(str[1]);
        long c=Integer.valueOf(str[2]);
        long d=Integer.valueOf(str[3]);
        for(int i=1;i<d;i++ ){
            a=(a*b)+c;
        }
        System.out.printf("%d", a);
    }
} 시작한수가 1번째 수열이니 예를들어 13번 반복이면 12번 해줘야한다.
*/

//1092
/*
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] str=sc.nextLine().split(" ");
        int a=Integer.valueOf(str[0]);
        int b=Integer.valueOf(str[1]);
        int c=Integer.valueOf(str[2]);
        int day=1;
        while((day%a!=0)||(day%b!=0)||(day%c!=0))day++; 최소공배수때 whle문이 멈춘다고 생각.
        System.out.println(day);
    }
}
*/

//1093
/*

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int[] arr=new int[23];
        int num=0;
        
        // 이 부분이 중요했다.
        for(int i=0;i<a;i++){
            num=sc.nextInt();
            arr[num-1]+=1;
        }      
        //
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
*/

//1094
/*
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int num=sc.nextInt();
    int [] arr=new int[num];
    for(int i=0; i<arr.length;i++){
        arr[i]=sc.nextInt();
    }
    for(int i=arr.length-1; i>=0;i--){
        System.out.printf("%d ",arr[i]);
    }
    
    }
}
*/
