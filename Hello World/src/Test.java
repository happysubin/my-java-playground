import java.util.Scanner; 

public class Test {

public static void main(String[] args) {

       int a=64, b, c, d;

       b = ~a;              

       c = (a & 64) >>>6 ;     

       d = (b & 64) >>>6;     

       System.out.println(Integer.toBinaryString(a)); 
       for(int i=0;i<10;i++) {
    	   if(a>>>i==1)System.out.println(i+1);
       }
       
       System.out.println(Integer.toBinaryString(b));
    
       System.out.println(c);

       System.out.println(d);

       int bitOpLSB;

       String strBinary="";

       int movedRight = a;

       for(int i=0;i<8;i++){

               bitOpLSB = (movedRight & 0x1);   //AND문을 연산자를 통해 0인지 1인지 구분해냄

               System.out.print(bitOpLSB); 

               strBinary =  String.valueOf(bitOpLSB) + strBinary;

               movedRight = movedRight >>> 1;

               }
       }
}

/*

1000000

11111111111111111111111110111111

1

0

00000010

1)   위와 같이 출력이 되도록 밑줄 __을 채우고 그 이유를 설명하시오.

  	c = (a & 64) >>>6 ;     
    d = (b & 64) >>>6; 

2)   위 출력 중 00000010이 나온 이유를 설명하시오.


3)  위 첫번 째 출력 1000000의 오른쪽으로부터 1의 위치인 7을 출력하기 위한 코드와 결과를 적고 설명하시오.

 	for(int i=0;i<10;i++) {
    	   if(a>>>i==1)System.out.println(i+1);
       }

*/