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

/*
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

6 - 6 장난꾸러기
 */

/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class Point implements Comparable<Point>{
    public int x,y;
    Point(int x,int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x==o.x)return this.y-o.y;
        //리턴 값이 음수 또는 0이면 자리가 유지됨. 양수면 자리가 교체됨. 우리는 올림차순
            //즉 this 가 더 크면 양수가 나오는데, 올림차순인데 이게 더 크면 말이 안되므로 뒤집는다.
                //그러나 정상적인 상태면 this 가 아래에 있으므로 값이 더 작으므로 파라미터가 값이 더커서 음수가 리턴된다.
        //우리는 올림차순이기 때문에 음수가 리턴된다. 즉 자리가 유지.
        else return this.x-o.x;
    }
}


public class Unit6{

    public static void main(String[] args)  {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        ArrayList<Point> arr=new ArrayList<>();
        for(int i=0;i<num;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            arr.add(new Point(x,y));
        }
        Collections.sort(arr); //sort메소드를 이용하면서 우리가 오버라이딩한 compareTo가 적용된다. 즉 정렬의 기준이 적용된다.
        for (Point o : arr) {
            System.out.println(o.x+" "+o.y);
        }


    }
}

//6 - 7 좌표 정렬


 */

/*
import java.io.*;
import java.util.Arrays;

public class Unit6 {
    public static int solution(int len,int aim, int[] arr) {
        Arrays.sort(arr);
        int answer=0;
        for(int i=0;i<len;i++){
            if(arr[i]==aim)answer=i+1;
        }
        return answer;
    }

    public static int solution(int len,int aim, int[] arr) {
        int answer=0;
        Arrays.sort(arr);
        int lt=0,rt=len-1;

        while(lt<=rt){ 이분 검색은 언젠가 lt가 rt보다 커진다.
            int mid=(lt+rt)/2;
            if(arr[mid]==aim){
                answer=mid+1;
                break;
            }
            if(arr[mid]>aim)rt=mid-1;
            else lt=mid+1;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr=br.readLine().split(" ");
        int len=Integer.parseInt(arr[0]);
        int aim=Integer.parseInt(arr[1]);
        String[] str=br.readLine().split(" ");
        int[] list=new int[len];
        int j=0;

        for(String x: str){
            list[j++]=Integer.parseInt(x);
        }
        System.out.println( solution(len,aim,list)+" ");
    }
}

6 - 8 이분검색
 */


import java.io.*;
import java.util.Arrays;

public class Unit6 {

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
    public static int solution(int len,int sec, int[] arr) {
        int lt=arr[len-1];
        int rt=Arrays.stream(arr).sum();
        int answer=0;

        while(lt<=rt){
            int mid=(lt+rt)/2; //mid가 DVD의 용량
            if(count(arr,mid)<=sec){
                answer=mid;
                rt=mid-1;
            }
            else lt=mid+1;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr=br.readLine().split(" ");
        int len=Integer.parseInt(arr[0]);
        int sec=Integer.parseInt(arr[1]);
        String[] str=br.readLine().split(" ");
        int[] list=new int[len];
        int j=0;
        for(String x: str){
            list[j++]=Integer.parseInt(x);
        }

        System.out.println(solution(len,sec,list)+" ");
    }
}
