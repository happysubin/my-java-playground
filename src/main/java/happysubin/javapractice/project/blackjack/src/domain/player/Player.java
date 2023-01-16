package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;

import java.util.List;

public interface Player {
    void receiveFirstTwoCards(Deck deck);
    List<Card> getCardList();
    String getName();
}
