package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;

import java.util.List;

public interface Player {
    void printCardListAndTotalScore();
    String getName();
    List<Card> getCardList();
    PlayerInfo getPlayerInfo();
    void printCardList();
    void firstDrawTwoCard(Deck deck);
    int getTotalScore();
}
