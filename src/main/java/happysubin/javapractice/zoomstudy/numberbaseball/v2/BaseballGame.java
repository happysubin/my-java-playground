package happysubin.javapractice.zoomstudy.numberbaseball.v2;

import java.util.ArrayList;

public class BaseballGame {

    private Player player;
    private Computer computer;

    public BaseballGame(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
    }

    public void start() {
        computer.generateAnswer();

        Hint hint;

        do{
            ArrayList<Integer> attemptedAnswer = player.createAttemptedAnswer();
            hint = computer.comparedWithAnswer(attemptedAnswer);
        }while(computer.isNotAnswer(hint));

        System.out.println("hint.getMessage() = " + hint.getMessage());
        for(Integer i : computer.getAnswer()){
            System.out.print(i);
        }

    }

    public void stop(){

    }
}
