
public class Programmers {

	/*
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
	*/
	/*
	class Solution {
	    public int solution(String s) {
	        int answer = 0;
	        s=s.replace("zero","0");
	        s=s.replace("one","1");
	        s=s.replace("two","2");
	        s=s.replace("three","3");
	        s=s.replace("four","4");
	        s=s.replace("five","5");
	        s=s.replace("six","6");
	        s=s.replace("seven","7");
	        s=s.replace("eight","8");
	        s=s.replace("nine","9");
	        String str=String.join("",s);
	        answer=Integer.parseInt(str);
	        return answer;
	    }
	}
	*/
	class Solution {
	    public int solution(int[] absolutes, boolean[] signs) {
	        int sum=0;
	        for(int i=0; i<absolutes.length;i++){
	            if(signs[i]==false)absolutes[i]*=-1;
	        }
	        for(int i=0; i<absolutes.length;i++){
	            sum+=absolutes[i];
	        }
	        
	        int answer = sum;
	        return answer;
	    }
	}

}
