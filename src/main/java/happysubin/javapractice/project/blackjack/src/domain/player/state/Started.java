package happysubin.javapractice.project.blackjack.src.domain.player.state;

import happysubin.javapractice.project.blackjack.src.domain.card.Cards;

public abstract class Started implements State{

    protected Cards cards;

    public Started(Cards cards) {
        this.cards = cards;
    }

    @Override
    public Cards cards() {
        return cards;
    }
}
