/*
import java.io.*;


public class Review {
    public static int[] solution(int num,int[] arr){
        int[] answer=new int[num];
        answer[0]=arr[0];
        int x=arr[0];

        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1])answer[i]=arr[i];
        }

        return answer;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(br.readLine());
        String[] x=br.readLine().split(" ");
        int[] arr=new int[a];
        int i=0;
        for (String s:x){
            arr[i++]=Integer.parseInt(s);
        }
        for (int j : solution(a,arr)) {
            if(j>0)System.out.print(j+" ");
        }

    }
}*/
/*

import java.io.*;


public class Review {
    public static int solution(int num,int[] arr){
        int answer=1;
        int max=arr[0];

        for(int i=1;i<arr.length;i++){
         if(arr[i]>max){
             max=arr[i];
             answer++;
         }
        }

        return answer;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(br.readLine());
        String[] x=br.readLine().split(" ");
        int[] arr=new int[a];
        int i=0;
        for (String s:x){
            arr[i++]=Integer.parseInt(s);
        }
        System.out.println(solution(a,arr));

    }
}
*/



/*
import java.io.*;
public class Review {
    public static String[] solution(int num,int[] a,int[] b){
        String[] answer=new String[num];
        for(int i=0;i<num;i++){
            if(a[i]==b[i])answer[i]="D";
            else if((a[i]==1&b[i]==3)||(a[i]==2&b[i]==1)||(a[i]==3&b[i]==2))answer[i]="A";
            else answer[i]="B";
        }

        return answer;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(br.readLine());
        String[] a1=br.readLine().split(" ");
        String[] a2=br.readLine().split(" ");

        int[] arr1=new int[a];
        int[] arr2=new int[a];
        int i=0;
        int j=0;

        for (String s:a1){
            arr1[i++]=Integer.parseInt(s);
        }
        for (String s:a2){
            arr2[j++]=Integer.parseInt(s);
        }


        for (String s : solution(a,arr1,arr2)) {
            System.out.println(s);
        }

    }
}
 */

/*
import java.io.*;
public class Review {
    public static int[] solution(int num){
        int[] answer=new int[num];

        for(int i=0;i<num;i++){
            if(i==0){
                answer[i]=1;
            }
            else if(i==1){
                answer[i]=1;
            }
            else{
                answer[i]=answer[i-1]+answer[i-2];
            }
        }
        return answer;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(br.readLine());
        for(int x:solution(a)){
            System.out.print(x+" ");
        }

    }
}
*/



import java.io.*;
public class Review{
    public static int solution(int num){
        int[] arr=new int[num+1];
        int answer=0;
        for(int i=2;i<num;i++)
            if(i*i<num){
                if(arr[i]==0){
                    for(int j=i;j<num;j=j*2){
                        if(j!=i)arr[j]
                    }
                }
            }
            else break;
        for (int i : arr) {
            System.out.print(i+" ");
        }
        return answer;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(br.readLine());
        System.out.print(solution(a));
    }
}
