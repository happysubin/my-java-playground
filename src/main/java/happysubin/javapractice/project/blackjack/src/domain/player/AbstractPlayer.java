package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.observer.PlayerObserver;
import happysubin.javapractice.project.blackjack.src.domain.player.state.State;
import happysubin.javapractice.project.blackjack.src.utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPlayer implements Player {

    protected List<Card> cardList = new ArrayList<>();
    protected PlayerInfo playerInfo;
    protected State state;

    protected PlayerObserver observer;

    public AbstractPlayer(PlayerInfo playerInfo) {
        this.observer = new PlayerObserver(this);
        this.playerInfo = playerInfo;
        this.state = State.RUNNING;
    }

    public State receiveFirstTwoCards(Deck deck) {
        for (int i = 0; i < 2; i++) {
            cardList.add(deck.drawCard(RandomUtil.getRandomNumber(deck.getDeckSize())));
        }
        observer.printCardList();
        return state;
    }

    public void printCardListAndTotalScore() {
        observer.printCardListAndTotalScore();
    }

    public State getState() {
        return state;
    }

    protected int calculateCardsPoint(List<Card> cardList) {
        return cardList.stream().map(Card::getLevelScore).reduce(0, Integer::sum);
    }
}
