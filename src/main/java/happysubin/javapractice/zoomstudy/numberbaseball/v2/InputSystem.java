package happysubin.javapractice.zoomstudy.numberbaseball.v2;

import java.util.*;

public class InputSystem {
    public void receiveAnswer(ArrayList<Integer> attemptedAnswer){
        Scanner scanner = new Scanner(System.in);
        System.out.println("3자리 수를 입력하세요.");
        int inputNumber = scanner.nextInt();

        attemptedAnswer.add(inputNumber / 100);
        attemptedAnswer.add((inputNumber % 100) / 10 );
        attemptedAnswer.add(inputNumber % 10);
    }

    public int receiveChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("게임을 종료하시려면 1을 입력하세요.");
        System.out.println("게임을 계속하시려면 2을 입력하세요.");

        int inputNumber = scanner.nextInt();

        return inputNumber;
    }

    //게임을 재시작할 것인지, 종료할 것인지 값을 받는다.
}
