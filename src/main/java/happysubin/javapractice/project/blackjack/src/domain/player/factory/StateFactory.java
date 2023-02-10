package happysubin.javapractice.project.blackjack.src.domain.player.factory;

import happysubin.javapractice.project.blackjack.src.domain.player.state.State;

public class StateFactory {

    private StateFactory(){}

    public static State firstExtractState(int totalScore){
        if(totalScore > 21 ) return State.GAME_OVER;
        else if(totalScore == 21) return State.BLACK_JACK;
        return State.RUNNING;
    }

    public static State lastGameParticipantExtractState(int totalScore){
        if(totalScore > 21 ) return State.GAME_OVER;
        return State.RUNNING;
    }

    public static State lastDealerExtractState(int totalScore){
        if(totalScore > 21 ) return State.GAME_OVER;
        return State.FINISH;
    }

    public static State finishState(){
        return State.FINISH;
    }
}
