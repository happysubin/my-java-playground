//백준 문자열 문제들

//아스키 코드
/*
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        char a=sc.next().charAt(0);
        System.out.print((int)a);
    }
}
*/

/*숫자의 합
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        String[] str=sc.next().split("");
        int sum=0;
        for(int i=0;i<num;i++){
            sum=sum+Integer.parseInt(str[i]);
        }
        System.out.print(sum);
    }
}
*/
// 자바는 int 배열을 선언하면 초기값은 0이고 string 배열의 초기값은 null이다.

//백준 문자열반복 2675
/*
import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int cnt=0;
		
		for(int i=0;i<num;i++) {
			cnt=sc.nextInt();
			String[] arr=sc.next().split("");
			
			for(int j=0;j<arr.length;j++) {
				for(int z=0;z<cnt;z++) {
					System.out.print(arr[j]);
				}
			}
			System.out.println();
		}
		
	}
}
*/
/*
import java.util.Scanner;
//소문자만 처음에 사용된 인덱스를 표시
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String name=sc.next(); //이름을 받는다
        int[] cnt=new int[26]; // 알파벳을 위한 배열
        
        for(int i=0;i<cnt.length;i++){
            cnt[i]=-1; //사용하지 않은 알파벳은 -1을 출력하므로 -1로 초기화
        }
        for(int i=0;i<name.length();i++){
            char content=name.charAt(i); //이름 문자열의 문자들을 다꺼낸다
            if(cnt[content-'a']==-1) { //초기화된 값이 아니면 값을 저장하지 않는다.
            	cnt[content-'a']=i;
            }// a를 기준으로 소문자만 사용되므로 a를 빼서 인덱스로 사용 b의 인덱스는 1 c는 2 이런 식 
            //사용된 자리는 i를 통해 나타내므로 i를 배열의 인덱스 요소로 저장.
        }
        for(int i=0;i<cnt.length;i++){
            System.out.print(cnt[i]+" ");
        }
        
    }
}
*/
// 백준1157 단어 공부이다
/*import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String word=sc.next().toUpperCase();
		sc.close();
		int[] arr=new int[26];
		int max;
		for(int i=0;i<word.length();i++) {
			arr[word.charAt(i)-'A']++;//문자열을 문자로 바꾸고 소문자로 사용하면 증가시킴.
		}
		max=0;
		//max=arr[0]이라 했다가 계속 틀렸었다. 이유가 무엇일까..?
		//바로 찾았다. a일 경우 오류가 발생한다. i+'A' 에서 i인 0이 존재하지 않기 때문이다!!!세상에!
		char answer='?';
		for(int i=0;i<arr.length;i++) {
			if(max<arr[i]) {
				max=arr[i];
				answer=(char)(i+'A');
			}else if(max==arr[i]) {
				answer='?';
			}
		}
		System.out.print(answer);
	}
}
*/

//백준 1152 단어 개수구하기
/*
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] arr=sc.nextLine().trim().split(" ");
		// 띄어쓰기가 들어갈경우 split가 배열로 바꿔서 오류가 난다. 무조건 1이 있는거다.
		//띄어쓰기만하면 배열요소에 아무것도 들어가지 않았다. 그래서 그걸 체크하고 다른것은 정상적으로 보낸다
		if(arr[0].equals("")) {
			System.out.print(0);
		}else {
			System.out.print(arr.length);
		} 
		
	}
}
*/

//백준 2908 숫자 뒤집어서 큰수 찾기
/*
import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String[] numbers=sc.nextLine().split(" ");
		for(int i=0;i<2;i++) {
			StringBuffer sb=new StringBuffer(numbers[i]);
			numbers[i]=sb.reverse().toString(); 
			//sb객체 생성후 사용가능한 reverse 메소드를 이용해서 뒤집고 타입이 맞지않으니 문자열로 바꾼다.
		}
		int a=Integer.parseInt(numbers[0]);
		int b=Integer.parseInt(numbers[1]);
		if(a>b) {
			System.out.print(a);
		}
		else {
			System.out.print(b);
		}
	}
}
*/

// 문자열에서 알파벳이 나올 시 알파벳 배열을 선언할 생각을 해야한다!!!

//자바 5622 전화기 문제 이건 내풀이.
import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String arr=sc.next();
		int sum=0;
		for(int i=0;i<arr.length();i++) {
			switch(arr.charAt(i)){
			case'A':
			case'B':
			case'C':
				sum+=3;
				break;
			case'D':
			case'E':
			case'F':
				sum+=4;
				break;
			case'G':
			case'H':
			case'I':
				sum+=5;
				break;
			case'J':
			case'K':
			case'L':
				sum+=6;
				break;
			case'M':
			case'N':
			case'O':
				sum+=7;
				break;
			case'P':
			case'Q':
			case'R':
			case'S':
				sum+=8;
				break;
			case'T':
			case'U':
			case'V':
				sum+=9;
				break;
			case'W':
			case'X':
			case'Y':
			case'Z':
				sum+=10;
				break;
	
			}
		}
		System.out.print(sum);
	}
}
/*이건 인터넷에서 찾은 풀이 생각의 전환이 정말 놀라웠다.
아스키코드값을 기준으로 나눴다. 한 수 배웠다..
전체 코드 말고 기준을 나누는 부분만 가져왔다.
			if(value < 68) count += 3;
			else if(value < 71) count += 4;
			else if(value < 74) count += 5;
			else if(value < 77) count += 6;
			else if(value < 80) count += 7;
			else if(value < 84) count += 8;
			else if(value < 87) count += 9;
			else count += 10;

*/