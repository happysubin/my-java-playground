/*
import java.io.*;

public class Unit6 {
    public static int[] solution(int num, int[] list){
        int min;

        int i,j=0;
        for(i=0;i<num;i++){
            min=i;
            for(j=i+1;j<num;j++) if(list[j]<list[min])min=j;
            int tmp=list[min];
            list[min]=list[i];
            list[i]=tmp;

        }

        return list;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        String[] arr=br.readLine().split(" ");
        int i=0;
        int[] list=new int[num];
        for( String x:arr){
            list[i++]=Integer.parseInt(x);
        }
        for(int x: solution(num,list)){
            System.out.print(x+" ");
        }

    }
}

6 - 1선택 정렬
 */

import java.io.*;

public class Unit6 {
    public static int[] solution(int num, int[] list){

        int i,j,key;
        for(i=num-1;i>0;i--){
            key=list[i];
            for(j=0;j<i;j++) {
                if(list[j]>list[j+1]){
                    int tmp=list[j];
                    list[j]=list[j+1];
                    list[j+1]=tmp;
                }
            }


        }

        return list;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        String[] arr=br.readLine().split(" ");
        int i=0;
        int[] list=new int[num];
        for( String x:arr){
            list[i++]=Integer.parseInt(x);
        }
        for(int x: solution(num,list)){
            System.out.print(x+" ");
        }

    }
}


/*
import java.io.*;

public class Unit6 {
    public static int[] solution(int num, int[] list){

        int i,j,key;
        for(i=1;i<num;i++){
            key=list[i];
            for(j=i-1;j>=0&&list[j]>key;j--) {
                list[j+1]=list[j];
            }
         list[j+1]=key; //j--가 실행되므로 ++

        }

        return list;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        String[] arr=br.readLine().split(" ");
        int i=0;
        int[] list=new int[num];
        for( String x:arr){
            list[i++]=Integer.parseInt(x);
        }
        for(int x: solution(num,list)){
            System.out.print(x+" ");
        }

    }
}

6 - 3 삽입 정렬
 */