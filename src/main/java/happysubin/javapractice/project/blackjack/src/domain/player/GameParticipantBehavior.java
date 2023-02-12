package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;

public interface GameParticipantBehavior {
    void lastSelectiveDraw(Deck deck);
}
