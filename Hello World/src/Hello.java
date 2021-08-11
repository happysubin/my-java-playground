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