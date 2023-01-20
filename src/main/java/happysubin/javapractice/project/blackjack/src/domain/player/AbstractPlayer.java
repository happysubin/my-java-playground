package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Cards;
import happysubin.javapractice.project.blackjack.src.domain.player.observer.PlayerObserver;
import happysubin.javapractice.project.blackjack.src.domain.player.state.State;

import java.util.List;

public abstract class AbstractPlayer implements Player{

    protected Cards cards;
    protected PlayerInfo playerInfo;
    protected State state;
    protected PlayerObserver observer;

    public AbstractPlayer(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
        this.state = State.RUNNING;
        this.cards = new Cards();
        this.observer = new PlayerObserver(this);
    }

    public AbstractPlayer(Cards cards, PlayerInfo playerInfo) {
        this.cards = cards;
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
        return cards.getCards();
    }

    @Override
    public void printCardListAndTotalScore() {
        observer.printCardListAndTotalScore();
    }

    @Override
    public void lossBettingMoney(List<Double> gameParticipantGetMoney) {
        playerInfo.lossMoney(gameParticipantGetMoney);
        System.out.println();
    }

    @Override
    public int calculateCardsPoint() {
        int sum = 0;
        for (Card card : cards.getCards()) {
            sum = card.getCumulativeScore(sum);
        }
        return sum;
    }

    @Override
    public PlayerInfo getPlayerInfo() {
        return playerInfo;
    }

    @Override
    public State getState() {
        return state;
    }
}
