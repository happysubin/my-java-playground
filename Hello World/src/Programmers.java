


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
	
	import java.io.*;

public class Programmers {
	public static String solution(String new_id) {
		String answer="";
		new_id=new_id.toLowerCase(); //1
		new_id=new_id.replaceAll("[^a-z0-9-_.]","");//괄호안의 문자 빼고 다 찾음 2
			
		new_id=new_id.replaceAll("\\.+","."); //마침표 \.이 아니라 \\.으로 표현 3

		if(new_id.startsWith(".")){ //4
			new_id=new_id.substring(1);
		}

		if(new_id.endsWith(".")){
			new_id=new_id.substring(0, new_id.length()-1);
		}

		if(new_id.isEmpty())new_id+="a"; //빈 공백이면 a를 더한다 5

		if(new_id.length()>15)new_id=new_id.substring(0, 15); //0부터 15번째 문자열로 자른다. 6

		if(new_id.endsWith(".")){
			new_id=new_id.substring(0, new_id.length()-1);
		}
		if(new_id.length()<3){ //7
			for(int i=new_id.length();i<3;i++){
				new_id+=String.valueOf(new_id.charAt(new_id.length()-1));
			}
		}
		answer+=new_id;	    
	    return answer;
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		System.out.println(solution(s));
	}
}
