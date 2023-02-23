package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Cards;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.observer.PlayerObserver;
import happysubin.javapractice.project.blackjack.src.domain.player.state.RightAfterStarted;
import happysubin.javapractice.project.blackjack.src.domain.player.state.State;

import happysubin.javapractice.project.blackjack.src.utils.RandomUtil;

public abstract class AbstractPlayer implements Player {

    protected State state;
    protected PlayerInfo playerInfo;
    protected PlayerObserver observer;

    public AbstractPlayer(PlayerInfo playerInfo, Cards cards) {
        this.playerInfo = playerInfo;
        this.state = new RightAfterStarted(cards, 0);
        this.observer = new PlayerObserver(this);
    }

    @Override
    public String getName() {
        return playerInfo.getName();
    }

    @Override
    public Cards getCards() {
        return state.cards();
    }

    @Override
    public void printCardListAndTotalScore() {
        observer.printCardListAndTotalScore();
    }

    @Override
    public PlayerInfo getPlayerInfo() {
        return playerInfo;
    }

    @Override
    public void printCardList() {
        observer.printCardList();
    }

    @Override
    public void firstDrawTwoCard(Deck deck) {
        for (int i = 0; i < 2; i++) {
            state.draw(drawCardFromDeck(deck));
        }
        printCardList();
    }


    protected Card drawCardFromDeck(Deck deck) {
        return deck.drawCard(RandomUtil.getRandomNumber(deck.getDeckSize()));
    }

    @Override
    public int getTotalScore() {
        return state.cards().getTotalScore();
    }
}
