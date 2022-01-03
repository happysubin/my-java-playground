
/*
import java.io.*;
import java.util.HashMap;


public class FourthChapter {

    public String solution(int num,String[] arr ){
        int max=0;
        int point=0;

        HashMap<String,Integer> map=new HashMap<String,Integer>(50);
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);//매핑되고 값이 없으면 0이나옴.
        }

        for(int i=0;i<map.size();i++){
            if(max<map.get(arr[i])){
                max=map.get(arr[i]);
                point=i;
            }
           
        }
        return arr[point];
    }
    public static void main(String[] args)throws IOException{
        FourthChapter T=new FourthChapter();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        String[] arr=br.readLine().split("");
       
        System.out.println(T.solution(num,arr));
    }
    
}
*/

import java.io.*;
import java.util.HashMap;

public class FourthChapter{
    public String solution(String[] arr1,String[] arr2){
        HashMap<String,Integer> map1=new HashMap<String,Integer>();
        HashMap<String,Integer> map2=new HashMap<String,Integer>();
        for(String x:arr1){
            map1.put(x,map1.getOrDefault(x, 0)+1);
        }

        for(String x:arr2){
            map2.put(x,map2.getOrDefault(x, 0)+1);
        }   

        for(String x:arr1){
            if(map1.get(x)!=map2.get(x)){
                return "NO";
            }
        }

        return "YES";

    }
    public static void main(String[] args)throws IOException{
        FourthChapter T=new FourthChapter();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] arr1=br.readLine().split("");
        String[] arr2=br.readLine().split("");
        System.out.print(T.solution(arr1, arr2));
    }
}