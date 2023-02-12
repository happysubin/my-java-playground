package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;

public interface DealerBehavior {
    void lastDraw(Deck deck);
}
