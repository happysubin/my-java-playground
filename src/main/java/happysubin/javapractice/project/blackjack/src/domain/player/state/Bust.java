package happysubin.javapractice.project.blackjack.src.domain.player.state;

import happysubin.javapractice.project.blackjack.src.domain.card.Cards;


/**
 * 버스트(Bust): 카드 총합이 21을 넘는 경우. 배당금을 잃는다.
 */
public class Bust extends Finished{

    public Bust(Cards cards) {
        super(cards);
    }

    @Override
    protected double earningRate() {
        return 0;
    }
}
