/*

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