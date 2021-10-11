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
 */

import java.util.Scanner;

public class Example{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		System.out.println(Integer.toBinaryString(num));
		
		int num2=sc.nextInt();
		num=num>>>--num2;
		System.out.println(num2&1);
	}
}

