package happysubin.javapractice.project.blackjack.src.domain.player.factory;

import happysubin.javapractice.project.blackjack.src.domain.player.state.legacy.LegacyState;

public class StateFactory {

    private StateFactory(){}

    public static LegacyState firstExtractState(int totalScore){
        if(totalScore == 21) return LegacyState.BLACK_JACK;
        return LegacyState.RUNNING;
    }

    public static LegacyState lastGameParticipantExtractState(int totalScore){
        if(totalScore > 21 ) return LegacyState.GAME_OVER;
        return LegacyState.RUNNING;
    }

    public static LegacyState lastDealerExtractState(int totalScore){
        if(totalScore > 21 ) return LegacyState.GAME_OVER;
        return LegacyState.FINISH;
    }

    public static LegacyState finishState(){
        return LegacyState.FINISH;
    }
}
