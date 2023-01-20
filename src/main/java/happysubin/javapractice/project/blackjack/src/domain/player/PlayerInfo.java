package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.player.state.State;

import java.util.List;

public class PlayerInfo {
    private final String name;
    private int bettingMoney;

    public PlayerInfo(String name, Integer bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    public double calculateBlackJack(State dealerState, State myState){
        if(dealerState == State.BLACK_JACK & myState == State.BLACK_JACK){
            return 0;
        }
        else if(myState == State.BLACK_JACK){
            int temp = this.bettingMoney;
            this.bettingMoney *= 1.5;
            return temp * 0.5;
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public Integer getBettingMoney() {
        return bettingMoney;
    }

    public void lossMoney(List<Double> gameParticipantGetMoney) {
        for (Double lossMoney : gameParticipantGetMoney) {
            this.bettingMoney -= lossMoney;
        }
    }
}
