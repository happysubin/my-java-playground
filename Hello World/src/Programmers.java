
public class Programmers {

	
	class Solution {
	    public int[] solution(int[] lottos, int[] win_nums) {
	        int[] answer = new int[2];
	        int z_num=0;
	        int num=0;
	        for(int i=0;i<6;i++){
	            if(lottos[i]==0)z_num++;
	            else {
	                for(int j=0;j<6;j++){
	                    if(lottos[i]==win_nums[j]){
	                        num++;
	                    }
	                }
	            }
	        }
	        if(num==6)answer[1]=1;
	        else if(num==5)answer[1]=2;
	        else if(num==4)answer[1]=3;
	        else if(num==3)answer[1]=4;
	        else if(num==2)answer[1]=5;
	        else answer[1]=6;
	        
	        if(num+z_num==6)answer[0]=1;
	        else if(num+z_num==5)answer[0]=2;
	        else if(num+z_num==4)answer[0]=3;
	        else if(num+z_num==3)answer[0]=4;
	        else if(num+z_num==2)answer[0]=5;
	        else answer[0]=6;
	        
	        return answer;
	    }
	}
	
}
