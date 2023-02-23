package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Cards;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;

public interface Player {
    void printCardListAndTotalScore();
    String getName();
    Cards getCards();
    PlayerInfo getPlayerInfo();
    void printCardList();
    void firstDrawTwoCard(Deck deck);
    int getTotalScore();
}
