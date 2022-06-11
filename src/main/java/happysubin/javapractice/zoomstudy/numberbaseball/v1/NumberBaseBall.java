package happysubin.javapractice.zoomstudy.numberbaseball.v1;


import javax.swing.*;
import java.util.*;

//슈퍼 클래스, 갓 클래스로 일단 작성 후 리팩토링을 진행.
public class NumberBaseBall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> goal = new ArrayList<>(3);

        Random random = new Random();

        //랜덤 숫자 생성
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for(int i = 0; goal.size() < 3; i++){
            int temp = random.nextInt(numbers.length);
            if(numbers[temp] != -1){
                goal.add(numbers[temp]);
                numbers[temp] = -1;
            }
        }

        while(true){
            List<Integer> input = new ArrayList<>(3);
            //유저 숫자 입력
            System.out.println("3자리 수를 입력하세요.");
            int inputNumber = sc.nextInt();

            input.add(inputNumber / 100);
            input.add((inputNumber % 100) / 10 );
            input.add(inputNumber % 10);

            //숫자 검사
            int strikeCount = 0; //스트라이크 검사
            int ballCount = 0;
            String message = "";

            for(int i = 0; i < 3; i++) {
                if (goal.get(i) == input.get(i)){
                    strikeCount++;
                }
                else if(goal.contains(input.get(i)) & goal.get(i) != input.get(i)){
                    ballCount++;
                }
            }
            //조건문 탈출
            if(strikeCount == 3){
                System.out.println("정답입니다.");
                break;
            }

            if(ballCount == 0 & strikeCount == 0){
                message = "OUT";
            }
            else{
                message = strikeCount + " strike " + ballCount + " ball";
            }
            System.out.println(message);
        }


        for (Integer integer : goal) {
            System.out.print(integer);
        }
        System.out.println("게임을 종료합니다.");
    }
}
