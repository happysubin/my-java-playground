package happysubin.javapractice.project.blackjack.src.domain.player.state;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Cards;

public abstract class Finished extends Started {

    public Finished(Cards cards) {
        super(cards);
    }

    @Override
    public State draw(Card card) {
        throw new UnsupportedOperationException("Finished 상태에서는 카드를 뽑을 수 없습니다.");
    }

    @Override
    public State stay() {
        return new Stay(cards);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public double profit(double profit) {
        return profit * earningRate();
    }

    abstract protected double earningRate();
}
