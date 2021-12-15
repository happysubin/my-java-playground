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


