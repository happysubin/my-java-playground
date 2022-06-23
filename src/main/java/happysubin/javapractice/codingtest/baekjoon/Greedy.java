package happysubin.javapractice.codingtest.baekjoon;/*

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class Test implements Comparable<Test>{
    public int x;
    public int y;

    public Test(int x, int y){
        this.x = x;
        this.y = y;
    }


    //return 값이 음수, 0이면 객체의 자리가 바뀌지 않는다.
    //return 값이 양수면 두 객체의 자리가 바뀐다.

    @Override
    public int compareTo(Test o) {
        if (this.x > o.x) return 1;
        else return -1;
    }
}

public class Greedy {
    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for(int i=0; i<num;i++){
            int total = Integer.parseInt(br.readLine());
            ArrayList<Test> arr= new ArrayList<>();
            for(int j=0; j<total;j++){
                String[] str = br.readLine().split(" ");
                arr.add(new Test(Integer.parseInt(str[0]),Integer.parseInt(str[1])));
            }

            Collections.sort(arr); //서류심사 x 정렬까지 완료. 이제 면접 순위로 비교해야함

            int standard = arr.get(0).y;  //1등의 면접 순위를 기준으로 둔다.
            int suc = 1; //성공자 수

            for(int z=1; z<arr.size();z++){
                if(arr.get(z).y<standard) {
                    standard= arr.get(z).y;
                    suc++;
                }
            }
            System.out.println(suc);
        }
    }
}

//



 */

import java.io.*;
import java.util.*;
//회의실

public class Greedy{
    public class Meeting implements Comparable<Meeting>{
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.end == o.end) return this.start - o.start; //종료 시점이 같으면 시작 시간으로 정렬
            return this.end - o.end;
        }

        //양수면 자리가 바뀐다.

        @Override
        public String toString() {
            return "Meeting{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public int solution()throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Meeting> list = new ArrayList<>();
        int num = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i = 0; i < num; i++){
            String[] s = br.readLine().split(" ");
            list.add(new Meeting(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
        }
        Collections.sort(list);

        int previousEndTime = 0;

        for(int i = 0; i < num; i++){
            // 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신한다
            if(previousEndTime <= list.get(i).start){
                previousEndTime = list.get(i).end;
                answer++;
            }
        }

        return answer;

    }
    public static void main(String[] args) throws IOException {
        Greedy main = new Greedy();
        System.out.println(main.solution());
    }
}