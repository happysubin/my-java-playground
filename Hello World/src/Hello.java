//코드업 100제 1001번     이클립스는 클래스와 파일이름이 같아야한다!
/*
public class Hello {

	public static void main(String[] args) {
		System.out.println("Hello");

	}

}*/

//1002
/*public class Hello{
    public static void main(String[] args){
        System.out.println("Hello World");
    }
}
*/

//1003
/*public class Hello{
    public static void main(String[] args){
        System.out.println("Hello \nWorld");
    }
}*/

//1004
/*
 public class Hello{
    public static void main(String[] args){
        System.out.println("\'Hello\'");  \' 으로 쉼표를 쓴다
    }
} 
 */
 //1005
/* public class Hello{
    public static void main(String[] args){
        System.out.println("\"Hello World\"");  
    }
} 
*/
//1006
/*
public class Main{
    public static void main(String[] args){
        System.out.println("\"!@#$%^&*()\"");
    }
}
*/
//1007
/*
public class Main{
    public static void main(String[] args){
        System.out.println("\"C:\\Download\\hello.cpp\"");
    }
}
*/
//1008
/*public class Hello{
	public static void main(String[] args) {
		System.out.println("\u250C\u252C\u2510\n");
	}
}*/

//1010
/*
 import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num;
        num=sc.nextInt();
        System.out.println(num);
    }
}
 */

//1011
/*
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s;
        s=sc.next();  sc.nextLine는 한줄을 다 받는다
        System.out.println(s);
    }
}
//1012
 * 
 import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        float n;
        n=sc.nextFloat();
        System.out.printf("%f",n);  //printf 로 부동소수점 표현가능. c언어와 매우 비슷해보인다.
    }
    
}
 */

//1013

/* 
 * import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a,b;
        a=sc.nextInt();
        b=sc.nextInt();
        System.out.printf("%d %d",a,b);
    }
}
 */
//1014

/*
 import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String a,b;
        a=sc.next();
        b=sc.next();
        System.out.println(b+" "+a);
    }
}

//1015
 /*
  import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double a;
        a=sc.nextDouble();
        System.out.printf("%.2f",a);
        
    }
}
*/


//1017
  /*
   import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a;
        a=sc.nextInt();
        System.out.printf("%d %d %d",a,a,a);
        
    }
}
   * */
 
//1018
/*
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String a;
        a=sc.next();
        System.out.println(a);
    }
}
*/

//1019
/*
 import java.util.Scanner;
public class Hello{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] str;
		int a,b,c;
		str=sc.next().split("\\.");
		a=Integer.parseInt(str[0]);
		b=Integer.parseInt(str[1]);
		c=Integer.parseInt(str[2]);
		System.out.printf("%04d.%02d.%02d",a,b,c); //이렇게 표현하는게 중요했다!!!
		 split("\\.") 이래야지 .을 기준으로 배열을 만든다. 정규표현식이라해서 
 \.하다가 오류가 너무 많이 나왔다..
	}
}
 */

//1020
/*import java.util.Scanner;
public class Hello{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] a;
        a=sc.next().split("-");
        
        System.out.println(a[0]+a[1]);
    }
}
 자바는 배열과 문자열이 c와 다르다. 문자열과 배열이 다르므로 문자열을 자르면 배열이므로 타입이 문자열인 변수에 값을
 할당할 수 없다.

*/

//1021

/*
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String a;
        a=sc.next();
        System.out.println(a);
    }
}
*/

//1022
/*
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String a;
        a=sc.nextLine();
        System.out.println(a);
    }
}
*/
//1023
/*
import java.util.Scanner;

public class Hello{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double a;
        String[] str;
        a=sc.nextDouble();
        str = Double.toString(a).split("\\."); 캐스팅하고 문자열을 나눠서 문자열 배열에 할당
        System.out.printf("%s %s",str[0],str[1]);
    }
}
*/

//1024

/*
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] str;
        str=sc.next().split(""); //이러면 모든 문자열을 문자 1개로 나눈다. js 랑은 다르네..
        for(int i=0;i<str.length;i++) {
        	System.out.printf("\'%s\'\n",str[i]);
        }
    }
}*/

//1025

/*
import java.util.Scanner;
public class Hello{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] a;
        int j=0;
        a=sc.next().split(""); 받은 숫자문자열을 다 나눈다
        for(int i=10000; i>=1;i=i/10){
            System.out.printf("[%d] \n", Integer.parseInt(a[j++])*i);
            //차근 차근 곱하면서 배열의 인덱스를 증가시켜 해당하는 인덱스에 맞게 곱한다
        }
    }
}
*/

//1026
/*
import java.util.Scanner;

public class Hello{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] str;
        str=sc.next().split(":");
        System.out.printf("%s",str[1].equals("00")?'0':str[1]);
    }
} 00:00:00 시분초 분을 출력하는데 분이 00 이면 0을 출력.
equal 메소드는 값을 비교!!! ==는 주소값을 비교한다고 한다.
*/

//1027
/*
import java.util.Scanner;
public class Hello{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] str;
        str=sc.next().split("\\."); .을 기준으로 문자열을 나눈다
        System.out.printf("%s-%s-%s",str[2],str[1],str[0]);
        
    }
}
*/

//1028
/*
import java.util.Scanner;
public class Hello{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        long a; long int 형을 선언
        a=sc.nextLong(); long int 형을 받는다
        System.out.printf("%d", a);
    }
}
*/
//1029
/*
import java.util.Scanner;
public class Hello{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double a; 
        a=sc.nextDouble(); 
        System.out.printf("%.11f", a);
    }
}
   자바는 %lf 가 없다 %.11f 이렇게 자리수를 나타내서 더 찍어야한다.
*/

//1030

/*

import java.util.Scanner;
public class Hello{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String a; 
        a=sc.nextLine(); 
        System.out.printf("%s", a);
    }}
    
*/
//1031
/*import java.util.Scanner;
public class Hello{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a; 
        a=sc.nextInt(); 
        System.out.printf("%o", a); 8진수로 출력
    }}
    */

//1032
/*
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a; 
        a=sc.nextInt(); 
        System.out.printf("%x", a); 16진법 출력 알파벳이 소문자이다.
    }}
    

*/

//1033
/*
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a; 
        a=sc.nextInt(); 
        System.out.printf("%X", a.); 16진법으로 출력 알파벳이 대문자이다.
    }
  }
    */

//1034
/*
import java.util.Scanner;
public class Hello{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String a;
        int b;
        a=sc.next();
        b=Integer.valueOf(a, 8); 숫자열을 문자열로 받아서 문자열을 8진수로 바꾼다.
        System.out.printf("%d", b);
        
    }
}
//1035
 /*
 import java.util.Scanner;
public class Hello{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String a;
        int b;
        a=sc.next();
        b=Integer.valueOf(a, 16); 숫자열을 문자로 받아서 16진수로 바꾼다
        System.out.printf("%o", b); 16진수를 8진수로 출력
        
    }
}
//1036
 //charAt은 자바에 문자열에 index값을 통해 문자를 읽어오는 함수
  /*
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        char a;
        int b;
        a=sc.next().charAt(0);  문자열에서 0인덱스를 가지는 문자를 가져온다  (한문자만 입력됨)
        b=(int)a; 문자를 int형으로 바꾼다. 여기서 문자의 값이 바뀌는 정수의 값은 아스키코드이다.
        System.out.printf("%d", b);
    }}
    
  */
/*
 import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        char a;
        a=sc.next().charAt(0);
        int b=a; char형을 int형에 박아도 그냥 실행된다!1
        System.out.printf("%d", b);
    }}
    
*/
//1037

/*

 import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a;
        a=sc.nextInt();
        char b=(char)a; 똑같이 그냥 숫자를 char형으로 바꾸면 아스키코드 값으로 바뀐다.
        System.out.printf("%c", b);
    }}
    /*

//1038 1039

/*
 import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double a,b;
        a=sc.nextDouble();
        b=sc.nextDouble();
        
        System.out.printf("%.0f",a+b); //이러면 소수점 아래를 출력하지않는다!!!
        
    }}
    */

//1040
/*
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a;
        a=sc.nextInt();
        System.out.printf("%d", -a);
    }
}
*/
//1041
/*
 * import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        char a;
        a=sc.next().charAt(0);
        System.out.printf("%c", a+1); a를 입력하면 b가 출력됩니다.
    }
}
 */

//1042
/*
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a,b;
        a=sc.nextInt();
        b=sc.nextInt();
        System.out.printf("%d", a/b);
    }
}
*/

//1043
/*
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a,b;
        a=sc.nextInt();
        b=sc.nextInt();
        System.out.printf("%d", a%b);
    }
}
*/

//1044
/*
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        long a;
        a=sc.nextInt();
        System.out.printf("%d", ++a);
    }
}
*/

//1045

/*

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double a,b;
        a=sc.nextDouble();
        b=sc.nextDouble();
        System.out.printf("%.0f\n", a+b); 소수점부터 안보여준다 즉 정수자리만 보여줌!!!
        System.out.printf("%.0f\n", a-b);
        System.out.printf("%.0f\n", a*b);
        System.out.printf("%.0f\n", a/b);
        System.out.printf("%.0f\n", a%b); 
        System.out.printf("%.2f", a/b);
    }
}


*/

//1046
/*
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double a,b,c;
        a=sc.nextDouble();
        b=sc.nextDouble();
        c=sc.nextDouble();
        System.out.printf("%.0f\n", a+b+c); 
        System.out.printf("%.1f", (a+b+c)/3);
      
    }
}
*/

//1047

/*

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
        
        System.out.printf("%d", a<<1);
        
	}
}
*/

//1048
/*
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b=sc.nextInt();
		sc.close();
        
        System.out.printf("%d", a<<b);
        
	}
}
*/
//1049
/*
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a,b;
        a=sc.nextInt();
        b=sc.nextInt();
        System.out.printf("%d",a>b?1:0);
    }
}


*/

//1050
/*
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a,b;
        a=sc.nextInt();
        b=sc.nextInt();
        System.out.printf("%d",a==b?1:0);
    }
}
*/
//1051
/*
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a,b;
        a=sc.nextInt();
        b=sc.nextInt();
        System.out.printf("%d",b>=a?1:0);
    }
}
*/

//1052
/*
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a,b;
        a=sc.nextInt();
        b=sc.nextInt();
        System.out.printf("%d",b!=a?1:0);
    }
}
*/

//1053

/*
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a;
        a=sc.nextInt();
    
        System.out.printf("%b",a==1?0:1);
    }
}

//1054
 /*
  * import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a,b;
        a=sc.nextInt();
        b=sc.nextInt();
        if(a==1&&b==1){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
        
    }
}
  */
//1055
/*
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a,b;
        a=sc.nextInt();
        b=sc.nextInt();
        if(a==1||b==1){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
        
    }
}
*/