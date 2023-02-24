package happysubin.javapractice.project.blackjack.src.domain.player.state;

import happysubin.javapractice.project.blackjack.src.domain.card.Cards;

public abstract class Running extends Started{

    public Running(Cards cards) {
        super(cards);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public double profit(double profit) {
        return profit;
    }

    @Override
    public State stay() {
        return new Stay(cards);
    }

    @Override
    public double compare(State dealerState, int betMoney) {
        throw new UnsupportedOperationException("게임 진행 중에는 결론을 도출할 수 없습니다.");
    }
}
