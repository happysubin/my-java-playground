import java.io.*;
import java.util.StringTokenizer;

public class Main{

    public int solution (int total, int goal, int[] arr){
   
        int cnt=0;

        // 1 2 1 3 1 1 1 2  
        //순서를 적어보자면 차례로 더 하다가 값이 맞으면 멈춘다. 왜냐면 어차피 숫자가 1보다 커 더해지므로 더 이상의 경우는 없기 때문.
        //그러면 1에서 모든 수를 구하면 2 다음은 1 다음은 3 이러헤
        for(int i=0; i<total;i++){  
            int sum=0;
            for(int j=i;j<total;j++){
                sum+=arr[j];
                if(goal==sum){ 
                    cnt++;
                    break;
                }
                else if(goal<sum)break; //그냥 안 맞고 값이 커지면 멈춘다. 시간낭비를 막자

            }
        }
        return cnt;
    }
    public static void main(String[] args)throws IOException{
        Main T=new Main();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");
        int total=Integer.parseInt(s[0]);
        int goal=Integer.parseInt(s[1]);
        int[] arr=new int[total];

        StringTokenizer st=new StringTokenizer(br.readLine());
        int i=0;
        while(st.hasMoreTokens()){
            arr[i++]=Integer.parseInt(st.nextToken());
        }

        System.out.print(T.solution(total, goal, arr));
    }
}