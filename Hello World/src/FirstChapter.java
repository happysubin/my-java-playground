/*
import java.util.Scanner;

public class FirstChapter {
    public static int Solution(String str,String check){
        str=str.toLowerCase();
        check=check.toLowerCase();
        String[] arr=str.split("");
        int num=0;
        
        for(int i=0; i<arr.length;i++){
            if(arr[i].equals(check))num++;
        }
        return num;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        String check=sc.next();
        System.out.println(Solution(str,check));
        sc.close();
    }
}

//1번 문자 찾기 해설

class TeacherSolution{

    public int solution(String str,char c){
        int answer=0;
        str=str.toUpperCase();
        c=Character.toUpperCase(c);
        for(char x: str.toCharArray()){//새로운 문자 배열이 하나 생성. 인덱스 0부터 시작
            if(x==c)answer++;
        } 
            
        return answer;
    }
    public static void main(String[] args){
        TeacherSolution T=new TeacherSolution();
        Scanner kb=new Scanner(System.in);
        String str=kb.next();
        char c=kb.next().charAt(0);
        System.out.println(T.solution(str,c));
        kb.close();
    }
}
*/

/*
import java.util.Scanner;

public class FirstChapter{
    public static char[] solution(String str){
        char[] answer=new char[str.length()];
        for(int i=0;i<str.length();i++){
            if(Character.isUpperCase(str.charAt(i))){
                answer[i]=Character.toLowerCase(str.charAt(i));
            }
            else if(Character.isLowerCase(str.charAt(i))){
                answer[i]=Character.toUpperCase(str.charAt(i));
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        char[] result=new char[str.length()];

        result=solution(str);       
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]);
        }
    }
}
*/

/*
import java.util.Scanner;

public class FirstChapter{
    public String solution(String str){
        String answer="";
        for(char x: str.toCharArray()){
            if(Character.isLowerCase(x))answer+=Character.toUpperCase(x);
            else answer+=Character.toLowerCase(x);
        }
        return answer;
    }

    public static void main(String[] args){
        FirstChapter T=new FirstChapter();
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.println(T.solution(str));


    }
}
*/

/*
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


public class FirstChapter{
    public static String solution(String str){
        String[] arr=str.split(" ");
        String result=arr[0];
        int max=arr[0].length();

        for(int i=1;i<arr.length;i++){
            if(max<arr[i].length())result=arr[i];
        }
        return result;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br=new java.io.BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        System.out.println(solution(str));
    }
}
*/

/*

import java.lang.StringBuffer; //이걸 사용해야만 reverse method 사용 가능.
import java.io.*;

public class FirstChapter{

    public static void solution(int num,String[] arr){
        
        for(int i=0;i<arr.length;i++){
            StringBuffer sb=new StringBuffer(arr[i]);
            String str=sb.reverse().toString();
            System.out.println(str);
        }
        
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());  
        String[] arr=new String[num];
        for(int i=0; i<num;i++){
            arr[i]=br.readLine();
        }  
        solution(num,arr);   
    }
}

*/

/*
import java.util.ArrayList;
import java.util.Scanner;

public class FirstChapter{
    public ArrayList<String> solution(int num,String[] str){
        ArrayList<String> answer=new ArrayList<String>();
        for(String x:str){
            char[] s=x.toCharArray();
            int lt=0; int rt=s.length-1; //lt는 뒤집을 문자 배열의 앞을 가리킨다. rt는 뒤집을 문자 배열의 뒤를 가리킨다.
            //직접 뒤집는 알고리즘
            while(lt<rt){ //짝수든 홀수든 이 조건.
                char tmp=s[lt];
                s[lt]=s[rt];
                s[rt]=tmp;
                //교환
                lt++;
                rt--;
            }
            String tmp=String.valueOf(s);
            answer.add(tmp);
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        FirstChapter T=new FirstChapter();
        int num=sc.nextInt();
        String[] str=new String[num];
        for(int i=0;i<num;i++){
            str[i]=sc.next();
        }
        for(String x:T.solution(num,str)){
            System.out.println(x);
        }
        sc.close();
    }
}
*/

/*
import java.io.*;
public class FirstChapter{

    public String solution(String str){
        char[] arr=str.toCharArray();
        int lt=0,rt=arr.length-1;
        while(lt<rt){
            if(Character.isAlphabetic(arr[lt])&Character.isAlphabetic(arr[rt])){ //알파벳인지 검사
                char tmp=arr[lt];
                arr[lt]=arr[rt];
                arr[rt]=tmp;
                lt++;
                rt--;
            }
            else if(Character.isAlphabetic(arr[lt])!=true &Character.isAlphabetic(arr[rt])!=true){ 
                lt++;rt--;
            }
            else if(Character.isAlphabetic(arr[lt])!=true)lt++;
            else if(Character.isAlphabetic(arr[rt])!=true)rt--;
            

        }
        str=String.valueOf(arr);
        return str;
    }
    public static void main(String[] args)throws IOException{
        FirstChapter T=new FirstChapter();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        System.out.println(T.solution(str));
    }
}

//꼭 자리가 맞을 필요는 없다. 알파벳이 아니면 lt는 뒤로 향하고 rt는 앞으로 향한다.
// lt rt가 둘다 알파벳이 아닐 수 있으므로 둘 다 아닌 것을 먼저 검사하고 이후에 lt rt 배열 인덱스를 1개씩 검사
//참고로 lt 는 left rt는 right

*/

/*
import java.util.Scanner;

public class FirstChapter{

    public String solution(String str){
        String answer;
        int lt=0, rt=str.length()-1;
        char[] arr=str.toCharArray();
        while(lt<rt){
            if(!Character.isAlphabetic(arr[lt]))lt++; 
            else if(!Character.isAlphabetic(arr[rt]))rt--;
            else{
                char tmp=arr[lt];
                arr[lt]=arr[rt];
                arr[rt]=tmp;
                lt++;
                rt--;
            }
        }
        answer=String.valueOf(arr);
        return answer;
    }
    public static void main(String[] args){
        FirstChapter T=new FirstChapter();
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.println(T.solution(str));
        sc.close();
    }
}

*/

/*
import java.io.*;

public class FirstChapter{

    public String solution(String str){
        String answer="";
        String[] arr=str.split("");
        for(int i=0;i<str.length();i++){
            if(!answer.contains(arr[i])){
                answer=answer.concat(arr[i]);
            }
            else continue;
        }

        return answer;
    }
    public static void main(String[] args)throws IOException{

        FirstChapter T=new FirstChapter();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        String str=br.readLine();
        System.out.println(T.solution(str));
    }
}
*/

/*

import java.util.Scanner;

//indexOf 함수는 인자로 들어오는 문자가 등장하는 배열의 제일 처음 인덱스 값을 알려준다.
//따라서 for 문에서 i와 indexOf 리턴 값이 같으면 제일 처음 등장한 문자다. 이것만 answer에 더하면 된다.

public class FirstChapter {
    public String solution(String str){
        String answer="";
        
        for(int i=0;i<str.length();i++){
            if(str.indexOf(str.charAt(i))==i)answer+=str.charAt(i);
        }

        return answer;
    }
    public static void main(String[] args){
        FirstChapter T=new FirstChapter();
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.println(T.solution(str));

    }
}
*/
/*
import java.io.*;

public class FirstChapter{
    public String solution(String str){
        String answer="";
        str=str.toLowerCase();
        if(str.length()%2==0){ //짝수
            for(int i=0;i<str.length()/2;i++){
                if(str.charAt(i)==str.charAt(str.length()-1-i)){
                    if(i==str.length()/2-1) answer=answer.concat("YES");
                }
                else {
                    answer=answer.concat("NO");
                    break;
                }
            }
        }else{ //홀수
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)==str.charAt(str.length()-1-i)){
                    if(i==str.length()/2-1) answer=answer.concat("YES");
                }
                else {
                    answer=answer.concat("NO");
                    break;
                }
            }
        }
        return answer;

    }
    public static void main(String[] args)throws IOException{
        FirstChapter T=new FirstChapter();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        System.out.println(T.solution(str));
    }
}
*/

/*

import java.util.*;
class Main {	
	public String solution(String str){
		String answer="YES";
		str=str.toUpperCase();
		int len=str.length();
		for(int i=0; i<len/2; i++){
			if(str.charAt(i)!=str.charAt(len-i-1)) answer="NO";
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.print(T.solution(str));
	}
}



import java.util.*;
class Main {	
	public String solution(String str){
		String answer="NO";
		String tmp=new StringBuilder(str).reverse().toString();
		if(str.equalsIgnoreCase(tmp)) answer="YES";
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.print(T.solution(str));
	}
}

*/

/*
import java.io.*;


public class FirstChapter{
    public String solution(String str){
        str=str.toLowerCase().replaceAll("[^a-z]",""); //처음인자는 제거할 정규 표현식, 이후는 제거한 곳에 들어갈 문자
        StringBuffer sb=new StringBuffer(str);
        if(str.equals(sb.reverse().toString()))return "YES";
        return "NO";

    }
    public static void main(String[] args) throws IOException{
        FirstChapter T=new FirstChapter();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        System.out.println(T.solution(str));
    }
}
*/

/*
import java.io.*;

public class FirstChapter {

    public int solution(String str){
        String answer=str.toLowerCase().replaceAll("[a-z]",""); //알파벳들을 전부 제거
        int num=Integer.parseInt(answer);
        return num;
    }
    public static void main(String[] args)throws IOException{
        FirstChapter T=new FirstChapter();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        System.out.println(T.solution(str));
    }
}

*/


/*

//숫자 0 은 아스키 번호로 48  아스키 번호 57까지가 숫자 9.

import java.util.*;
class Main {	
	public int solution(String s){
		//int answer=0;
		String answer="";
		for(char x : s.toCharArray()){
			//if(x>=48 && x<=57) answer=answer*10+(x-48);
			//if(Character.isDigit(x)){
				//answer=answer*10+ Character.getNumericValue(x);
			//}
			if(Character.isDigit(x)) answer+=x;
		}
		return Integer.parseInt(answer);
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.print(T.solution(str));
	}
}
*/

/*

import java.io.*;

public class FirstChapter{
    public void solution(String str,int num){
        String[] arr=new String[num];
       str=str.replace("#","1");
       str=str.replace("*","0");
       int j=0;
       for(int i=0; i<=str.length()-7;i=i+7){
           System.out.println(i);
           arr[j++]=str.substring(i,i+7); //이러면 i 부터 i+6 까지의 숫자를 가져온다. 그러므로 총 7개를 가져오는 것
       }
       for(int i=0;i<arr.length;i++){
           char a=(char)Integer.parseInt(arr[i],2);// 문자열을 2진수로 바꾼다. char형 캐스팅을 통해 정수를 문자로 변환
           System.out.print(a);
       }
    }
    public static void main(String[] args)throws IOException{
        FirstChapter T=new FirstChapter();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        String str=br.readLine();
        T.solution(str,num);
    }
}

*/

import java.util.*;
class Main {	
	public String solution(int n, String s){
		String answer="";
		for(int i=0; i<n; i++){
			String tmp=s.substring(0, 7).replace('#', '1').replace('*', '0'); //0부터 6까지 7개들을 잘라서 옮긴다.
			int num=Integer.parseInt(tmp, 2); 
			answer+=(char)num;//문자열에 문자를 더함
			s=s.substring(7); //앞의 7문자를 계속 잘라낸다. 28개가 21개 21개가 14개 14개가 7개 7개가 0개로 문자열이 작아진다.
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		String str=kb.next();
		System.out.println(T.solution(n, str));
	}
}