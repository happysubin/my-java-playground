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
        ArrayList<Integer> answer = computer.generateAnswer();

        for (Integer integer : answer) {
            System.out.println("integer = " + integer);
        }

        Hint hint;

        do{
            ArrayList<Integer> attemptedAnswer = player.createAttemptedAnswer();
            hint = computer.comparedWithAnswer(attemptedAnswer, answer);

        } while (computer.isNotAnswer(hint));

        System.out.println(hint.getMessage());

        //개인의 의사 결정
        if(player.choiceGamerStartOrStop() == 1){
            finishGame();
        }
        else{
            restartGame();
        }
    }

    public void restartGame(){
        start();
    }

    public void finishGame(){
        System.out.println("게임을 종료합니다");
    }



}
