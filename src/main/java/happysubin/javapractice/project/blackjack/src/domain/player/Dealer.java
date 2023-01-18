package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.state.State;

public interface Dealer extends Player{
    State firstDrawTwoCard(Deck deck);
    void lastDraw(Deck deck);
}
