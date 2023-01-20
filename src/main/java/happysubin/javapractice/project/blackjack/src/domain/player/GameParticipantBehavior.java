package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.state.State;

public interface GameParticipantBehavior {
    double firstDrawTwoCard(Deck deck, State state);
    void lastSelectiveDraw(Deck deck);
}
