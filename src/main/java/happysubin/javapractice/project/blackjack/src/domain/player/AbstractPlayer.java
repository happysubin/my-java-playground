package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.observer.PlayerObserver;
import happysubin.javapractice.project.blackjack.src.utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPlayer implements Player{

    protected List<Card> cardList = new ArrayList<>();
    protected PlayerObserver observer;

    public AbstractPlayer() {
        this.observer = new PlayerObserver(this);
    }

    @Override
    public void receiveFirstTwoCards(Deck deck) {
        for (int i = 0; i < 2; i++) {
            cardList.add(deck.drawCard(RandomUtil.getRandomNumber(deck.getDeckSize())));
        }
        observer.printCardList();
    }

    @Override
    public void selectivelyReceiveCard(Deck deck) {
        boolean draw = true;
        while(draw){
            draw = selectiveDraw(deck, cardList, observer);
        }
    }

    @Override
    public List<Card> getCardList() {
        return cardList;
    }

    @Override
    public void printCardListAndTotalScore() {
        observer.printCardListAndTotalScore();
    }

    protected abstract boolean selectiveDraw(Deck deck, List<Card> cardList, PlayerObserver observer);
}
