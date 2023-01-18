package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.player.observer.PlayerObserver;
import happysubin.javapractice.project.blackjack.src.domain.player.state.State;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPlayer implements Player{

    protected List<Card> cardList = new ArrayList<>();
    protected PlayerInfo playerInfo;
    protected State state;
    protected PlayerObserver observer;

    public AbstractPlayer(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
        this.state = State.RUNNING;
        this.observer = new PlayerObserver(this);
    }

    @Override
    public String getName() {
        return playerInfo.getName();
    }

    @Override
    public List<Card> getCardList() {
        return cardList;
    }

    @Override
    public void printCardListAndTotalScore() {
        observer.printCardListAndTotalScore();
    }

    protected int calculateCardsPoint(List<Card> cardList) {
        return cardList.stream().map(Card::getLevelScore).reduce(0, Integer::sum);
    }
}
