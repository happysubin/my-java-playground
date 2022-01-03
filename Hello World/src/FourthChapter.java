
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
