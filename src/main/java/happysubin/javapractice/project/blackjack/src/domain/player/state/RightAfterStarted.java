package happysubin.javapractice.project.blackjack.src.domain.player.state;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Cards;

public class RightAfterStarted extends Running{

    private int count;

    public RightAfterStarted(Cards cards, int count) {
        super(cards);
        this.count = count;
    }

    @Override
    public State draw(Card card) {
        cards.add(card);
        count++;

        if (cards.isBlackJack()) {
            return new BlackJack(cards);
        }

        if(count == 2){
            return new Hit(cards);
        }
        return new RightAfterStarted(cards, count);
    }
}
