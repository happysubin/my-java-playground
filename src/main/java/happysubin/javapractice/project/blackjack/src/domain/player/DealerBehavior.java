package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.state.State;

public interface DealerBehavior {
    State firstDrawTwoCard(Deck deck);
    void lastDraw(Deck deck);
}
