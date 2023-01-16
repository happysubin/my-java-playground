package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.observer.PlayerObserver;
import happysubin.javapractice.project.blackjack.src.utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public abstract class AbstractPlayer implements Player{

    private List<Card> cardList = new ArrayList<>();
    private PlayerObserver observer;

    public AbstractPlayer() {
        this.observer = new PlayerObserver(this);
    }

    @Override
    public void receiveFirstTwoCards(Deck deck) {
        for (int i = 0; i < 2; i++) {
            cardList.add(deck.getCard(RandomUtil.getRandomNumber(deck.getDeckSize())));
        }
        observer.printCardList();
    }

    @Override
    public List<Card> getCardList() {
        return cardList;
    }
}
