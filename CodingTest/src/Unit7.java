
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Unit7 {
    public static void recursive(int n){
        if(n==0)return;
        else {
            System.out.println(n);
            recursive(n - 1);
        }

    }
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        recursive(num);
    }
}

//자연수 n이 입력되면 1부터 n까지 출력

 */


/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Unit7 {
    public static void recursive(int n){
        if(n==0)return;
        else {
            System.out.print(n%2);
            recursive(n/2);
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        recursive(num);
    }
}

//2진수 재귀함수로 출력하기



 */

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Unit7 {
    public static int recursive(int n){
        if(n==1)return 1;
        else return n*recursive(n-1);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        System.out.println(recursive(num));
    }
}
    팩토리얼 재귀로 풀기
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Unit7 {
    static int[] fibo;
    public static int recursive(int n){
        if(fibo[n]>0) return fibo[n]; //0보다 크면 이미 구한 숫자들이다. 시간을 줄이기 위해서 이 코드를 삽입!
        if(n==1)return fibo[n]=1;
        else if(n==2)return fibo[n]=1;
        else return fibo[n]=recursive(n-2)+recursive(n-1);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        fibo=new int[num+1];
        recursive(num);
        for(int i=1;i<=num;i++)System.out.print(fibo[i]+" ");
    }
}
//피보나치 수열 재귀를 이용.