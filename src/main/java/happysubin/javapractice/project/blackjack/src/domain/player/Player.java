package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Cards;

import java.util.List;

public interface Player {
    void printCardListAndTotalScore();
    String getName();
    List<Card> getCardList();
    void lossBettingMoney(List<Double> gameParticipantGetMoney);
    int calculateCardsPoint(List<Card> cardList);
}
