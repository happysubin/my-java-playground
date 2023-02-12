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
        return 0;
    }
}
