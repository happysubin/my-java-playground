
/*
class Point {
int x, y;
public Point(int x, int y) {
this.x = x; this.y = y;
}
public boolean equals(Point obj) {
if(obj.x == x && obj.y == y) return true; // obj.x, obj.y
else return false;
	}

}


public class Example {
public static void main(String[] args) {
Point a = new Point(2,3);
Point b = new Point(2,3);
Point c = new Point(3,4);
c=b;
if(a == b) System.out.println("a==b"); //a==b는 주소 값이 다르므로 출력문이 실행됩니다. 멤버 변수의 값만 같습니다.
if(c == b) System.out.println("a==c"); //c와 a는 주소 값이 같으므로 이 출력문은 실행됩니다.
if(a.equals(b)) System.out.println("a is equal to b"); //구성하는 멤버 변수가 같아서 출력문이 실행됩니다. 객체가 저장한 데이터가 같다.
if(a.equals(c)) System.out.println("a is equal to c"); //구성하는 멤버 변수가 같아서 출력문이 실행됩니다. 객체가 저장한 데이터가 같다.
	}
}

*/



import java.util.Scanner;

public class Example{
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);

		
		System.out.println("좌표를 입력하세요");
		int pointA=sc.nextInt();
		int pointB=sc.nextInt();

		System.out.println("좌표를 입력하세요");
		int pointX=sc.nextInt();
		int pointY=sc.nextInt();

		double distanceY=Math.pow((pointY-pointB),2);
		double distanceX=Math.pow((pointX-pointA),2);

		double pointDistance1=Math.sqrt(distanceX);
		double pointDistance2=Math.sqrt(distanceY);

		if(pointDistance1==pointDistance2) {
			System.out.println("거리가 같다.");
		}else {
			System.out.println("거리가 다르다.");
		}

	}
}