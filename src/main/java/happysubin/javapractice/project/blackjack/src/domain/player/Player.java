package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.state.State;

import java.util.List;

public interface Player {
    void printCardListAndTotalScore();
    String getName();
    List<Card> getCardList();
    PlayerInfo getPlayerInfo();
    State getState();
    int calculateCardsPoint();
    void printCardList();
    void firstDrawTwoCard(Deck deck);
}
