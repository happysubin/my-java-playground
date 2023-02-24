package happysubin.javapractice.project.blackjack.src.domain.player.state;

import happysubin.javapractice.project.blackjack.src.domain.card.Cards;

/**
 * 스테이(Stay): 카드를 더 뽑지 않고 차례를 마치는 것
 */
public class Stay extends Finished{

    public Stay(Cards cards) {
        super(cards);
    }

    @Override
    protected double earningRate() {
        return 1;
    }

    @Override
    public double compare(State dealerState, int betMoney) {

        int totalScore = cards.getTotalScore();
        int dealerTotalScore = dealerState.cards().getTotalScore();

        if(dealerState.getClass() == Bust.class || totalScore > dealerTotalScore){
            return profit(betMoney);
        }

        else if (totalScore < dealerTotalScore){
            return profit(-1 * betMoney);
        }

        return 0;
    }
}
