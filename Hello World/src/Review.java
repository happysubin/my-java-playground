/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Review{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int cnt=0;
        String s=br.readLine().toLowerCase();
        String c=br.readLine().toLowerCase();
        String[] arr=s.split("");
        for(String x: arr){
            if(c.equals(x))cnt++;
        }
        System.out.println(cnt);
    }
}
*/

/*
import java.io.*;

public class Review{

    public String solution(String s){
        String answer="";
        for(char c: s.toCharArray()){
            if(Character.isUpperCase(c)) answer+=Character.toLowerCase(c);
            else answer+=Character.toUpperCase(c);
        }
        return answer;

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Review T=new Review();
        String s=br.readLine();

        System.out.println(T.solution(s));
    }
}
*/

/*

import java.io.*;

public class Review{
    public  static String solution(String[] s){
        String answer="";

        int max=0;
        for(String x: s){
            if(max<x.length()){
                max=x.length();
                answer=x;
            }
        }
        return answer;

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");
        System.out.print(solution(s));

    }
}
*/

/*
import java.io.*;

public class Review{
    public  static String[] solution(String[] s){
        String[] answer=new String[s.length];
        int i=0;
        for(String x: s){
            StringBuilder sb=new StringBuilder(x);
           answer[i++]=sb.reverse().toString();
        }
        return answer;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       int a=Integer.parseInt(br.readLine());
       String[] arr=new String[a];
        for(int i=0;i<arr.length;i++){
            arr[i]=br.readLine();
        }

       for(String s:solution(arr)){
           System.out.println(s);
       }
    }
}
*/ 
/*

import java.io.*;

public class Review{
    public  static char[] solution(String s){
        char[] arr=s.toCharArray();
        int lt=0;
        int rt=s.length()-1;
        while(lt<rt){
            if(!Character.isAlphabetic(arr[lt])){
                lt++;
            }

            else if(!Character.isAlphabetic(arr[rt])){
                rt--;
            }
            else{
                char tmp=arr[rt];
                arr[rt]=arr[lt];
                arr[lt]=tmp;
                lt++;
                rt--;
            }
        }

        return arr;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        for(char c:solution(s)){
            System.out.print(c); 
        }

    }
}
*/

/*

import java.io.*;

public class Review{
    public  static String solution(String s){
        String[] arr=s.split("");
        String answer="";
        for(int i=0;i<s.length();i++){
            if(s.indexOf(arr[i])==i){
                answer+=arr[i];
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        System.out.println(solution(s));
    
    }
}
*/

/*

import java.io.*;

public class Review{
    public  static String solution(String s){
        s=s.toLowerCase();
       StringBuilder sb=new StringBuilder(s);
       if(s.equals(sb.reverse().toString())){
           return "YES";
       }
       
       return "NO";
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        System.out.println(solution(s));
    
    }
}

*/


/*
import java.io.*;

public class Review{
    public  static String solution(String s){

      String a=s.toLowerCase().replaceAll("[^a-z]","");
      StringBuilder sb=new StringBuilder(a);
       if(sb.reverse().toString().equals(a)){
           return "YES";
       }
       return "NO";
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        System.out.println(solution(s));
    
    }
}
*/
/*

import java.io.*;

public class Review{
    public  static int solution(String s){
        
      String a=s.toLowerCase().replaceAll("[a-z]","");
      return Integer.parseInt(a);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        System.out.println(solution(s));
    
    }
}
*/

/*


import java.io.*;

public class Review{
    public  static int[]  solution(String str,String key){
    char k=key.charAt(0);   
    int[] arr=new int[str.length()];
    int x=1000; 

    for(int i=0;i<str.length();i++){
        char c=str.charAt(i);
        if(c==k){
            x=0;
            arr[i]=x++;
        }
        else{
            arr[i]=x++;
        }
    }
   x =1000;
    for(int i=str.length()-1;i>=0;i--){
        char c=str.charAt(i);
        if(c==k){
            x=0;
            arr[i]=x++;
        }
        else{
            if(arr[i]>x){
                arr[i]=x++;
                
            }
        }
    }
   return arr;     
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");
        
        for(int x:solution(s[0],s[1])){
            System.out.print(x+" ");
        }
    
    }
}

*/

/*

import java.io.*;

public class Review{
    public  static String  solution(String s){
    s=s+" ";
    String answer="";
    int cnt=1;
    for(int i=0;i<s.length()-1;i++){
        char c=s.charAt(i);
        if(c==s.charAt(i+1))cnt++;
        else{
            if(cnt==1)answer+=c;
            else {
                answer+=c+String.valueOf(cnt);
                cnt=1;
            }
        }
    }
   

    return answer;

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        System.out.print(solution(s));

    }
}

*/

/*

import java.io.*;

public class Review{
    public  static void  solution(int num, String s){
        s=s.replaceAll("#", "1").replaceAll("\\*","0");

        int[] arr=new int[num];

        int j=0;
        for(int i=0;i<4;i++){
            arr[i]=Integer.parseInt(s.substring(j, j=j+7),2);
        }

        for(int x: arr){
            System.out.print((char)x);
          
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        String s=br.readLine();
        solution(num, s);

    }
}


*/

//인프런 코테 강의 문자열 복습 

//인프런 코테 강의 문자열 복습 2
/*

import java.io.*;

public class Review{

    public static String solution(String str){
        str=str+" ";
        String answer="";
       for(int i=0;i<str.length()-1;i++){
           char x=str.charAt(i);
           if(str.indexOf(x)==i){
            answer+=x;
           }
       }
       return answer;

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();

        System.out.println(solution(str));

    }
}
*/
/*

import java.io.*;

public class Review{

    public static String solution(String str){
      
       str=str.toLowerCase().replaceAll("[^a-z]","");
       StringBuilder sb=new StringBuilder(str);
       if(str.equals(sb.reverse().toString())){
           return "YES";
       }
       return "NO";

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();

        System.out.println(solution(str));

    }
}
*/



/*
import java.io.*;

public class Review{

    public static int[] solution(String str,char c){
        int [] answer=new int[str.length()];
        int j=10000;

        for(int i=0;i<str.length();i++){
            char x=str.charAt(i);
            if(x==c){
                j=0;
                answer[i]=j;
            }
            else{
                j++;
                answer[i]=j;
            }
        }

        j=10000;

        for(int i=str.length()-1;i>=0;i--){
            char x=str.charAt(i);
            if(x==c){
                j=0;
                answer[i]=j;
            }
            else{
                j++;
                if(answer[i]>j){
                    answer[i]=j;
                }
            }
        }
        
        return answer;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] arr=br.readLine().split(" ");
        String str=arr[0];
        char a=arr[1].toCharArray()[0];

        for(int x: solution(str,a)){
            System.out.print(x+" ");
        }

    }
}
*/

/*

import java.io.*;

public class Review{

    public static String solution(String str){
        String answer="";
        str=str+" ";

        int check=1;
        for(int i=0;i<str.length()-1;i++){

            if(str.charAt(i)==str.charAt(i+1)){
                check++;
            }
            else{
                if(check==1){
                    answer+=str.charAt(i);
                }
                else {
                    answer+=str.charAt(i)+String.valueOf(check);
                    check=1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        System.out.print(solution(str));
    }
}
*/



import java.io.*;

public class Review{

    public static String solution(String str){
        int rt=str.length()-1,lt=0;
        char[] arr=str.toCharArray();
        String answer;
        while(lt<rt){
            if(!Character.isAlphabetic(arr[lt])) lt++;    
            else if(!Character.isAlphabetic(arr[rt])) rt--;
            
            else{
                char tmp=arr[lt];
                arr[lt]=arr[rt];
                arr[rt]=tmp;
                lt++;rt--;
            }
        } 
        
        answer=String.valueOf(arr);
        return answer;

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();

        System.out.println(solution(str));

    }
}