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

/*
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


6-2 버블정렬
 */
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

/*
import java.io.*;
import java.util.ArrayList;

public class Unit6 {
    public static ArrayList<String> solution(int size, int len, String[] str) {
        ArrayList<String> arr = new ArrayList<>(size);

        for(int i=0;i<len;i++){
            String num=str[i];


            if(arr.contains(num)){
                arr.remove(num);
                arr.add(num);
            }
            else arr.add(num);

            if(arr.size()>size)arr.remove(0);


        }
        return arr;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr=br.readLine().split(" ");
        int size=Integer.parseInt(arr[0]);
        int len=Integer.parseInt(arr[1]);
        String[] str=br.readLine().split(" ");

        ArrayList<String> solution = solution(size, len, str);
        for(int i=solution.size()-1;i>=0;i--){
            System.out.print(solution.get(i)+" ");
        }


    }
}
 6 - 4 LRU
 */

/*
import java.io.*;
import java.util.Arrays;

public class Unit6 {
    public static String solution(int num, String[] str) {
        String answer="U";
        Arrays.sort(str);

        for(int i=0;i<num-1;i++){
            if(str[i].equals(str[i+1]))return "D";
        }


        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] str=br.readLine().split(" ");
        System.out.println(solution(num,str)+" ");
    }
}
6- 5 중복 문자 체크
 */


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Unit6 {
    public static ArrayList<Integer> solution(int num, int[] arr) {
        ArrayList<Integer> answer=new ArrayList<>();

        int[] clone=arr.clone();
        Arrays.sort(clone);

        for(int i=0;i<num;i++){
            if(clone[i]!=arr[i])answer.add(i+1);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] str=br.readLine().split(" ");
        int[] arr=new int[num];
        int j=0;

        for(String x: str){
            arr[j++]=Integer.parseInt(x);
        }
        for( int x: solution(num,arr)){
            System.out.print(x+" ");
        }
    }
}