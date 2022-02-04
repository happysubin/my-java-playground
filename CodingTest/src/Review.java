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


/*
import java.io.*;
public class Review{
    public static int solution(int num){
        int[] arr=new int[num+1];
        int answer=0;
        for(int i=2;i<=num;i++)
            if(i*i<num){
                for(int j=i;j<=num;j=j+i){
                    if(i==j&arr[j]!=2)arr[j]=1;//첫 숫자고 배수로 체크가 안되어있으면 1을 넣는다.
                    else arr[j]=2;
                }
            }
            else break;
        for(int i=2;i<num+1;i++){
            if(arr[i]!=2)answer++;
        }
        return answer;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(br.readLine());
        System.out.print(solution(a));
    }
}
 */

/*
import java.io.*;

public class Review{
    public static int[] solution(int num,String[] arr){
        int[] nums=new int[num];
        int[] answer=new int[num];
        int z=0;
        for(String x: arr){
            StringBuilder sb=new StringBuilder(x);
            nums[z++]=Integer.parseInt(sb.reverse().toString());
        }

        for(int i=0;i<nums.length;i++){
            for(int j=2;j<=nums[i];j++){
                if(nums[i]%j==0){
                    if(j!=nums[i])break;
                    answer[i]=nums[i];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        String[] arr=br.readLine().split(" ");
        for(int x: solution(num,arr)){
            if(x!=0)System.out.print(x+" ");
        }
    }
}

 */


/*
import java.io.*;

public class Review{
    public static int solution(int num,String str){
        int answer=0;
        int score=0;
        String[] arr=str.split(" ");

        for(int i=0;i<num;i++){
            if(arr[i].equals("1")){
                score++;
                answer+=score;
            }
            else if(arr[i].equals("0")) {
                score = 0;
            }
        }
        return answer;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        String arr=br.readLine();
        System.out.println(solution(num,arr));

    }
}

 */

/*
import java.io.*;

public class Review{
    public static int[] solution(int num,String str){
        int[]nums =new int[num];
        int[]answer =new int[num];
        int score=0,z=0;
        String[] arr=str.split(" ");
        for (String s : arr) {
            nums[z++]=Integer.parseInt(s);
        }
        
        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                if(nums[i]<nums[j])answer[i]++;
            }
        }

        return answer;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        String str=br.readLine();
        for( int x: solution(num,str)){
            System.out.print(x+1+" ");
        }

    }
}

 */


/*

import java.util.Scanner;

public class Review{
    public static int solution(int[][] arr,int num){
        int max=0;
        int score=0;
        for(int i=0;i<num;i++){
            int score1=0;
            int score2=0;
            for(int j=0;j<num;j++){
               score1+=arr[i][j];
               score2+=arr[j][i];
            }
            max=Math.max(score1,max);
            max=Math.max(score2,max);
        }

        for(int i=0;i<num;i++){
            score+=arr[i][i];
        }
        max=Math.max(score,max);
        int j=0;
        for(int i=num-1;i>=0;i--){
            score+=arr[j++][i];
        }


        return max;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int[][] arr=new int[num][num];

        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                arr[i][j]=sc.nextInt();
            }
        }

      System.out.println(solution(arr,num));


    }
}*/


/*

import java.util.Scanner;

public class Review{
    public static int solution(int[][] arr,int num){
        int cnt=0;
        for(int i=1;i<=num;i++){
            for(int j=1;j<=num;j++){
               if(arr[i][j]>arr[i][j+1]&arr[i][j]>arr[i+1][j]&arr[i][j]>arr[i][j-1]&arr[i][j]>arr[i-1][j])cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int[][] arr=new int[num+2][num+2];

        for(int i=1;i<=num;i++){
            for(int j=1;j<=num;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println(solution(arr,num));
    }
}

 */