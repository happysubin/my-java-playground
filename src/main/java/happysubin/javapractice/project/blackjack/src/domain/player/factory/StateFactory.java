package happysubin.javapractice.project.blackjack.src.domain.player.factory;

import happysubin.javapractice.project.blackjack.src.domain.player.state.State;

public class StateFactory {

    private StateFactory(){}

    public static State extractState(int totalScore){
        if(totalScore > 21 ) return State.GAME_OVER;
        else if(totalScore == 21) return State.BLACK_JACK;
        return State.RUNNING;
    }

    public static State getFinishState(){
        return State.FINISH;
    }
}
