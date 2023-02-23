package happysubin.javapractice.project.blackjack.src.domain.player.state;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Cards;

public class RightAfterStarted extends Running{

    public RightAfterStarted(Cards cards) {
        super(cards);
    }

    @Override
    public State draw(Card card) {
        cards.add(card);
        if (cards.isBlackJack()) {
            return new BlackJack(cards);
        }
        return new Hit(cards);
    }
}
