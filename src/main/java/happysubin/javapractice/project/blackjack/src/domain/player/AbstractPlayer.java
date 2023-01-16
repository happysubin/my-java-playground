package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPlayer implements Player{

    private List<Card> cardList = new ArrayList<>();

    @Override
    public void receiveFirstTwoCards(Deck deck) {
        for (int i = 0; i < 2; i++) {
            cardList.add(deck.getCard(RandomUtil.getRandomNumber(deck.getDeckSize())));
        }
    }

    @Override
    public List<Card> getCardList() {
        return cardList;
    }
}
