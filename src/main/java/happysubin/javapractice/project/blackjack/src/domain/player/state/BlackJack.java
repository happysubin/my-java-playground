package happysubin.javapractice.project.blackjack.src.domain.player.state;

import happysubin.javapractice.project.blackjack.src.domain.card.Cards;

/**
 * 블랙잭(Blackjack): 처음 두 장의 카드 합이 21인 경우, 베팅 금액의 1.5배
 */
public class BlackJack extends Finished{

    public BlackJack(Cards cards) {
        super(cards);
    }

    @Override
    protected double earningRate() {
        return 1.5;
    }
}
