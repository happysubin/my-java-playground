/*
 * a>>b
 * a의 각 비트를 오른쪽으로 b번 시프트한다. 최상위 비트의 빈자리는 시프트 전의 최상위 비트로 다시 채운다.
 * 산술적 오른쪽 시프트라고 한다.
 * 
 * a>>>b
 * a의 각 비트를 오른쪽으로 b번 시프트하다. 그리고 최상위 비트의 빈자리는 0으로 채운다.ㄴ
 * 논리적 오른쪽 시프트라고한다.
 * 
 * a<<b
 * a의 각 비트를 왼쪽으로 b번 시프트한다. 그리고 최하위 비트의 빈자리는 0으로 채운다.
 * 산술적 왼쪽 시프트라고 한다.
 * 
 * 실습 1 복습!
 * 
 * 
 */
//4-11 중요


import java.util.Scanner;
/*
public class Example{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		System.out.println(Integer.toBinaryString(num));
		int num2=sc.nextInt();
		System.out.println(num>>>--num2&1);
	}
}
*/

/*
import java.lang.ArithmeticException;
import java.util.InputMismatchException;

public class Example{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int dividing=0,divided=0;
		
		while(true) {
			try {
			System.out.println("나뉨수를 입력하시오");
			divided=sc.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("숫자가 아닙니다. 숫자를 입력하세요.");
				sc.next();
				continue;
			}
			while(true) {
				try {
					System.out.println("나눔수를 입력하시오");
					 dividing=sc.nextInt();
					}
					catch(InputMismatchException e) {
						System.out.println("숫자가 아닙니다. 숫자를 입력하세요.");
						sc.next();
						continue;
					}
				try {
						int result=divided/dividing;
						System.out.println(divided+"을 "+dividing+"로 나누면 "+result+"입니다.");
						
						break;
					}
					catch(ArithmeticException e) {
						System.out.println("0으로 나눌 수 없습니다.");
						continue;
					}
			}
		}
	}
}
*/

class Book{
	String year,author,title;
	Book(String author, String title, String year){
		this.author=author;
		this.title=title;
		this.year=year;
	}
	Book(String author, String title){
		this(author,title,"제작년도 미상");
	}
}

public class Example{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Book[] book=new Book[2];
		for(int i=0;i<book.length;i++) {
			System.out.println("저자 입력하시오.");
			String author=sc.nextLine();
			System.out.println("제목 입력하시오.");
			String title=sc.nextLine();
			System.out.println("제작년도 입력하시오.");
			String year=sc.nextLine();
			
			if(year!="") {
				book[i]=new Book(author,title,year);
			}else {
				book[i]=new Book(author,title);
			}
		}
		for(int i=0;i<book.length;i++) {
			System.out.print("(" + book[i].title + ", " + book[i].author+ ", " + book[i].year + ")");
		}
		sc.close();
	}
}