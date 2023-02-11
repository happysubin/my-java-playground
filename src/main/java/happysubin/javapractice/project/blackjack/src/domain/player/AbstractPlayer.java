package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Cards;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.observer.PlayerObserver;

import happysubin.javapractice.project.blackjack.src.utils.RandomUtil;

public abstract class AbstractPlayer implements Player {

    protected Cards cards;
    protected PlayerInfo playerInfo;
    protected PlayerObserver observer;

    public AbstractPlayer(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
        this.cards = new Cards();
        this.observer = new PlayerObserver(this);
    }

    /**
     * 테스트에서 사용할 생성자다.
     */

    public AbstractPlayer(Cards cards, PlayerInfo playerInfo) {
        this.cards = cards;
        this.playerInfo = playerInfo;
        this.observer = new PlayerObserver(this);
    }

    @Override
    public String getName() {
        return playerInfo.getName();
    }

    @Override
    public Cards getCards() {
        return cards;
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
            cards.addCard(deck.drawCard(RandomUtil.getRandomNumber(deck.getDeckSize())));
        }
        cards.firstExtractState();
    }

    @Override
    public int getTotalScore() {
        return cards.getTotalScore();
    }
}
