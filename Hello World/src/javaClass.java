
import java.util.Scanner;
import java.lang.ArithmeticException;
import java.util.InputMismatchException;

public class javaClass{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int beDividedNumber=1;
		int dividingNumber=0;
		int check=0;
		
		while(true) {
			
			try {
				if(beDividedNumber!=check) {
				System.out.println("나뉨수를 입력하시오.");
				 beDividedNumber=sc.nextInt();
				}
			}
			
			catch(InputMismatchException e) {
				System.out.println("정수가 아닙니다. 다시 입력하세요!");
				sc.next();
				continue;
			}
			
			try {
				System.out.println("나눔수를 입력하시오.");
				dividingNumber=sc.nextInt(); 
			}
			
			catch(InputMismatchException e) {
				System.out.println("정수가 아닙니다. 다시 입력하세요!");
				check=beDividedNumber;
				sc.next();
				continue;
			}
			
			try {
				int result=beDividedNumber/dividingNumber;
				System.out.println(beDividedNumber+"을 "+dividingNumber+"로 나누면 "+result+"입니다.");
				check=0;
			}
			catch(ArithmeticException e) {
				System.out.println("0으로 나눌 수 없습니다.");
				continue;
			}
			finally {
				
			}
		}
		
	}
}
//문제점 분자로 0이 들어오면 안된다.