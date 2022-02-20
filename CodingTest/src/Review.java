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
/*

import java.util.Scanner;

public class Review{
    public static int solution(int[][] arr,int num){
        int[][] check=new int[num][num];
        int max=0;
        int result=0;

        for(int i=0;i<5;i++){
            for(int j=0;j<num;j++){
               for(int z=0;z<num;z++){
            if(arr[j][i]==arr[z][i]) {
                check[j][z]=1;
            }
               }
            }
        }

        for(int i=0;i<num;i++){
            int sum=0;
            for(int j=0;j<num;j++){
                sum+=check[i][j];
            }
            if(max<sum){
                max=sum;
                result=i;
            }

        }

        return result+1;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int[][] arr=new int[num][5];

        for(int i=0;i<num;i++){
            for(int j=0;j<5;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println(solution(arr,num));
    }
}
*/

/*

import java.io.*;

public class Review{
    public static int[] solution(String[] arr1, String[] arr2,int num1,int num2){
        int lt=0,rt=0,i=0;

        int[] answer=new int[num1+num2];

        while(lt<num1&rt<num2){
            if(Integer.parseInt(arr1[lt])<Integer.parseInt(arr2[rt])){
                answer[i++]=Integer.parseInt(arr1[lt++]);
            }else {
                answer[i++] = Integer.parseInt(arr2[rt++]);
            }
        }

        if(lt==num1){
            for(int j=rt;j<num2;j++){
                answer[i++]=Integer.parseInt(arr2[rt++]);
            }
        }else{
            for(int j=lt;j<num1;j++){
                answer[i++]=Integer.parseInt(arr1[lt++]);
            }
        }
        return answer;
    }

    public static void main(String[] args)throws  IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num1=Integer.parseInt(br.readLine());
        String[] arr1=br.readLine().split(" ");
        int num2=Integer.parseInt(br.readLine());
        String[] arr2=br.readLine().split(" ");

        for(int x:solution(arr1,arr2,num1,num2)){
            System.out.print(x+" ");
        }
    }
}
*/

/*
import java.io.*;
import java.util.Arrays;

public class Review{
    public static int[] solution(String[] arr1, String[] arr2,int num1,int num2){
        int z1=0,z2=0,i=0;
        int lt=0,rt=0;
        int[] iArr1=new int[num1];
        int[] iArr2=new int[num2];
        int[] answer=new int[Math.max(num1,num2)];

        for(String x :arr1){
            iArr1[z1++]=Integer.parseInt(x);
        }
        for(String x: arr2){
            iArr2[z2++]=Integer.parseInt(x);
        }

        Arrays.sort(iArr1);
        Arrays.sort(iArr2);

        while(lt<num1&rt<num2){
            if(iArr1[lt]<iArr2[rt])lt++;
            else if(iArr1[lt]>iArr2[rt])rt++;
            else{
                answer[i++]=iArr1[lt];
                lt++;rt++;
            }
        }
        return answer;
    }

    public static void main(String[] args)throws  IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num1=Integer.parseInt(br.readLine());
        String[] arr1=br.readLine().split(" ");
        int num2=Integer.parseInt(br.readLine());
        String[] arr2=br.readLine().split(" ");

        for(int x:solution(arr1,arr2,num1,num2)){
            if(x!=0)System.out.print(x+" ");
        }
    }
}
 */


/*
import java.io.*;

public class Review{
    public static int solution(int len, int num, String[] arr){
        int[] arr2 =new int[len];
        int z=0,sum=0,max=0,lt=0;
        for(String x:arr){
            arr2[z++]=Integer.parseInt(x);
        }

        for(int i=0;i<num;i++){
            sum+=arr2[i];
        }

        max=sum;

        for(int rt=num;rt<len;rt++){
            sum=sum-arr2[lt++]+arr2[rt];
            max=Math.max(max,sum);
        }
        return max;
    }

    public static void main(String[] args)throws  IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] arr1=br.readLine().split(" ");
        int len=Integer.parseInt(arr1[0]);
        int num=Integer.parseInt(arr1[1]);
        String[] arr2=br.readLine().split(" ");
       System.out.print(solution(len,num,arr2));


    }
}
*/


/*
import java.io.*;

public class Review{
    public static int solution(int len, int num, String[] arr){
        int[] arr2 =new int[len];
        int z=0,sum=0,cnt=0,lt=0;
        for(String x:arr){
            arr2[z++]=Integer.parseInt(x);
        }

        for(int rt=0;rt<len;rt++){
            sum+=arr2[rt];
            if(sum==num)cnt++;
            while(sum>=num){
                sum-=arr2[lt++];
                if(sum==num)cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args)throws  IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] arr1=br.readLine().split(" ");
        int len=Integer.parseInt(arr1[0]);
        int num=Integer.parseInt(arr1[1]);
        String[] arr2=br.readLine().split(" ");
        System.out.print(solution(len,num,arr2));
    }
}
 */

/*

import java.io.*;

public class Review{
    public static int solution(int num){
        int cnt=0, sum=0,lt=0;
        int[] arr=new int[num];
        for(int i=1;i<=num;i++){
            arr[i-1]=i;
        }

        for(int rt=0;rt<num;rt++){
            sum+=arr[rt];
            if(sum==num)cnt++;
            while(sum>=num){
                sum-=arr[lt++];
                if(sum==num)cnt++;
            }
        }


        return cnt;
    }

    public static void main(String[] args)throws  IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        System.out.print(solution(num));
    }
}

 */

/*

import java.io.*;
import java.util.HashMap;


public class Review{
    public static String solution(int num,String[] arr){
        HashMap<String,Integer> map=new HashMap<>();
        int max=0;
        String answer="";

        for(String x:arr){
            map.put(x,map.getOrDefault(x,0)+1);
            //getOrDefault(Object key, V DefaultValue) 키. DefaultValue는 값이 없다면 나오는 기본 값.
        }

        for( String string:map.keySet()){
            if(max<map.get(string)){
                answer=string;
                max=map.get(string);
            }
        }
        return answer;
    }

    public static void main(String[] args)throws  IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        String[] arr=br.readLine().split("");
        System.out.print(solution(num,arr));
    }
}

 */

/*

import java.io.*;
import java.util.HashMap;


public class Review{
    public static String solution(String str1, String str2){
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();


        for(char x:str1.toCharArray()){
            map1.put(x,map1.getOrDefault(x,0)+1);
        }
        for(char x:str2.toCharArray()){
            map2.put(x,map2.getOrDefault(x,0)+1);
        }

        for(char x :map1.keySet()){
            if(map1.get(x)==map2.get(x))continue;
            else {
                return "NO";
            }
        }

        return "YES";
    }

    public static void main(String[] args)throws  IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String str1=br.readLine();
        String str2=br.readLine();
        System.out.print(solution(str1,str2));
    }
}

 */


/*
import java.io.*;
import java.util.HashMap;


public class Review{
    public static int[] solution(int len, int num,String str){
        HashMap<String,Integer> map=new HashMap<>();
        String[] key=str.split(" ");
        int[] answer=new int[len-num+1];
        int j=0,lt=0;

        for(int i=0;i<num;i++){
            map.put(key[i],map.getOrDefault(key[i],0)+1);
        }

        answer[j++]=map.size();

        for(int rt=num;rt<len;rt++){
            if(map.get(key[lt])!=1){
                map.put(key[lt],map.get(key[lt])-1);
            }
            else if(map.get(key[lt])==1){
                map.remove(key[lt]);
            }
            lt++;
            map.put(key[rt],map.getOrDefault(key[rt],0)+1);
            answer[j++]=map.size();
        }

        return answer;
    }

    public static void main(String[] args)throws  IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] arr=br.readLine().split(" ");
        int len=Integer.parseInt(arr[0]);
        int num=Integer.parseInt(arr[1]);
        String str=br.readLine();

        for(int x:solution(len,num,str)){
            System.out.print(x+" ");
        }
    }
}

 */

/*
import java.io.*;
import java.util.HashMap;

public class Review{
    public static int solution(String str, String key){
        HashMap<Character,Integer> mapA=new HashMap<>();
        HashMap<Character,Integer> mapB=new HashMap<>();
        int answer=0,lt=0;

        for( char c:key.toCharArray()){
            mapB.put(c,mapB.getOrDefault(c,0)+1);
        }

        for(int i=0;i<key.length()-1;i++){
            char c=str.charAt(i);
            mapA.put(c,mapA.getOrDefault(c,0)+1);
        }

        for(int rt=key.length()-1;rt<str.length();rt++){
            char c=str.charAt(rt);
            mapA.put(c,mapA.getOrDefault(c,0)+1);
            if(mapA.equals(mapB))answer++;

            mapA.put(str.charAt(lt),mapA.get(str.charAt(lt))-1);
            if(mapA.get(str.charAt(lt))==0)mapA.remove(str.charAt(lt));
            lt++;


        }

        return answer;
    }

    public static void main(String[] args)throws  IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String big=br.readLine();
        String small=br.readLine();

        System.out.println(solution(big,small));
    }
}





/*
import java.io.*;
import java.util.*;

public class Review{
    public static int solution(int num, int rank,String[] str){
        TreeSet<Integer> set=new TreeSet<>(Collections.reverseOrder());
        Integer[] arr=new Integer[num];
        int k=0;
        for(String x:str){
            arr[k++]=Integer.parseInt(x);
        }
        for(int i=0;i<num;i++){
            for(int j=i+1;j<num;j++){
                for(int z=j+1;z<num;z++){
                    set.add(arr[i]+arr[j]+arr[z]);
                }
            }
        }
        int cnt=0;
        for(int i: set){
            cnt++;
            if(cnt==rank)return i;
        }

        return -1;
    }

    public static void main(String[] args)throws  IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] arr=br.readLine().split(" ");
        int num=Integer.parseInt(arr[0]);
        int rank=Integer.parseInt(arr[1]);
        String[] arr2=br.readLine().split(" ");

        System.out.println(solution(num,rank,arr2));
    }
}

 */


/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Review{
    public static int count(int[] arr, int capacity){
        int cnt=1,sum=0;
        for(int x:arr){
            if(sum+x>capacity){
                cnt++;
                sum=x;
            }
            else sum+=x;
        }

        return cnt;
    }

    public static int solution(int len, int num, int[] arr){
        int lt=Arrays.stream(arr).max().getAsInt();
        int rt= Arrays.stream(arr).sum();
        int answer=0;

        while(lt<=rt){
            int mid=(lt+rt)/2;
            if(count(arr,mid)<=num){ //mid가 DVD의 용량
                answer=mid;
                rt=mid-1;
            }
            else lt=mid+1;
        }
        return answer;
    }

    //결정 알고리즘은 답이 확실히 존재한다는 가정하에 사용
    //rt가 모든 뮤직비디오가 dvd에 들어가는 최대 값
    //최소 dvd 용량이 뮤직비디오의 제일 큰 값.
    //그래야지 제일 큰 뮤직비디오가 들어갈 수 있다.

    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().split(" ");
        int len=Integer.parseInt(str[0]);
        int num=Integer.parseInt(str[1]);

        String[] arr=br.readLine().split(" ");
        int[] list=new int[len];
        int k=0;
        for(String s:arr){
            list[k++]=Integer.parseInt(s);
        }

        System.out.println(solution(len,num,list));
    }
}


 */

//특정 문자 뒤집기 복습


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Review{
    public static String solution(String str){
        int lt=0,rt=str.length()-1;
        String answer="";
        char[] arr = str.toCharArray();
        while(lt<=rt){
            if(!Character.isAlphabetic(arr[lt]))lt++;
            else if(!Character.isAlphabetic(arr[rt]))rt--;
            else{
                char tmp=arr[lt];
                arr[lt]=arr[rt];
                arr[rt]=tmp;
                lt++;rt--;
            }
        }

        for(char c:arr){
            answer+=c;
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        System.out.println(solution(str));

    }
}