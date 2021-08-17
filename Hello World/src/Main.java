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
import java.util.Scanner;

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
		max=arr[0];
		//max=arr[0]이라 했다가 계속 틀렸었다. 이유가 무엇일까..?
		//바로 찾았다. a일 경우 오류가 발생한다. i+'A' 에서 i인 0이 존재하지 않기 때문이다!!!세상에!
		char answer='?';
		for(int i=1;i<arr.length;i++) {
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