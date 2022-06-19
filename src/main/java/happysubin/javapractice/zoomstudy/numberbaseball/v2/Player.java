package happysubin.javapractice.zoomstudy.numberbaseball.v2;

import java.util.ArrayList;

public class Player {

    public ArrayList<Integer> createAttemptedAnswer(){
        InputSystem inputSystem = new InputSystem();
        ArrayList<Integer> attemptedAnswer = new ArrayList<>(3);

        inputSystem.receiveAnswer(attemptedAnswer);

        return attemptedAnswer;
    }

    //게임을 계속할 것인지 아닌지 의사 결정을 한다
    public int choiceGamerStartOrStop(){
        InputSystem inputSystem = new InputSystem();

        int choice = inputSystem.receiveChoice();

        return choice;
    }
}
