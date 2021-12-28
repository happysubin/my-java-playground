
/*
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

*/

import java.util.Scanner;

public class ThirdChapter{
    public int[] solution(int num1, int num2, int[] arr1, int[] arr2){
        int[] answer=new int[num1+num2]; //정렬한 값을 넣을 배열
        int p1=0,p2=0,i=0;
        while(p1<num1 & p2<num2 ){
            if(arr1[p1]<arr2[p2])answer[i++]=arr1[p1++]; //작은걸 먼저 넣는다.
            else answer[i++]=arr2[p2++];
        }

        //남는 것은 온통 큰수이니 넣어버린다. 이것은 두 배열이 정렬이 된 배열이여서 가능하다.
        while(p1<num1)answer[i++]=arr1[p1++];
        while(p2<num2)answer[i++]=arr2[p2++];

        return answer;
    }

    public static void main(String[] args){
        ThirdChapter T=new ThirdChapter();
        Scanner sc=new Scanner(System.in);

        int num1=sc.nextInt();
        int[] arr1=new int[num1];
        for(int i=0;i<num1;i++)arr1[i]=sc.nextInt();

        int num2=sc.nextInt();
        int[] arr2=new int[num2];
        for(int i=0;i<num2;i++)arr2[i]=sc.nextInt();

        for(int x:T.solution(num1, num2, arr1, arr2)){
            System.out.print(x+" ");
        }

        sc.close();

    }
}

//이런 쉬운 정렬 문제가 만약에 나온다면 투 포인터를 쓰는 지 확인하기위함이므로 이렇게 풀자!!!