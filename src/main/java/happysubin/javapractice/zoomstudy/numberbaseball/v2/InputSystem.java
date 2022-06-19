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
}
