
/*

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
*/
//문제점 분자로 0이 들어오면 안된다.


/*
import java.util.Scanner;

class Book{
	String title,author,year;
	
	public Book(String title, String author) {
		this(title,author,"발간년도미상");
	}
	public Book(String title, String author,String year) {
		this.title=title;
		this.author=author;
		this.year=year;
	}
}
	

public class javaClass{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Book[] book=new Book[2];
		for(int i=0;i<book.length;i++) {
			System.out.println("제목>>");
			String title=sc.nextLine();
			
			System.out.println("저자>>");
			String author=sc.nextLine();
			
			System.out.println("발간년도>>");
			String year=sc.nextLine();
			
			if(year=="") {
				book[i]=new Book(title,author);
			}
			else {
				book[i]=new Book(title,author,year);
			}
			
		}
		for(int i=0;i<book.length;i++) {
			System.out.print("(" + book[i].title + ", " + book[i].author+ ", " + book[i].year + ")");
		}
		sc.close();
		
	}
}

*/


class Disk  {
	public int width=5;
	public Disk(){};
}

class Disk1 extends Disk{
	protected int height=6;
	public int width=10; // 여기에 A파트 추가
	public Disk1() {};
	public int area(Disk2 d) { //여기에 C파트 수정
		return d.width*d.height; 
	}
}

class Disk2 extends Disk1{
	private int depth=7;
	public int width=15; //여기에 B파트 추가
	public Disk2(int depth) {
		this.depth=depth;
	}
	public void setdepth(int dep) {
		this.depth=dep;
	}
	public int getdepth() {
		return depth;
	}
	public int vol() {
		return area(this)*depth; //여기에 D파트 수정
	}
}

class javaClass{
	public static void main(String[] args) {
		Disk2 d=new Disk2(8);
	System.out.println("d width = "+d.width);
	System.out.println("dheight="+d.height+",area="+d.area(d)); //여기에 E파트 수정
	d.setdepth(9);
	System.out.println("ddepth="+d.getdepth()+",vol="+d.vol());
	}
}

//버전 1 
/*

d width = 5
dheight=6,area=30
ddepth=9,vol=270

*/

//버전 2 (A,B)

/*
d width = 15  제일 마지막에 값 할당된 width. Disk2에서 할당.

dheight=6,area=60 height 는 Disk1에서 값 할당.
area 메소드가 디스크1의 width height를 곱합 각각 6과 10 이다. 따라서 60

ddepth=9,vol=540 9와 60을 곱한다.

*/

//버전 3 (A,B,C,D,E)

/*


d width = 15 제일 마지막에 값 할당된 width. Disk2에서 할당.
dheight=6,area=90 이번에는 Disk1의 값이 아닌 인자로 들어온 객체의 width와 height를 곱한다.
15와 6을 곱해서 90
ddepth=9,vol=810 90곱하기 9 depth는 set함수를 이용해서 정해진 마지막 값 따라서 810.



*/


