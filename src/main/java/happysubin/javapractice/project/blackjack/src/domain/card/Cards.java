package happysubin.javapractice.project.blackjack.src.domain.card;

import happysubin.javapractice.project.blackjack.src.domain.player.factory.StateFactory;
import happysubin.javapractice.project.blackjack.src.domain.player.state.State;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cards {

    private List<Card> cards = new ArrayList<>();
    protected State state;

    public Cards() {
        this.state = State.RUNNING;
    }

    /**
     * 테스트 코드용 생성자
     */
    public Cards(List<Card> cards) {
        Collections.sort(cards);
        this.cards = cards;
    }

    public void addCard(Card card){
        cards.add(card);
        Collections.sort(cards);
    }


    public void firstExtractState() {
        this.state = StateFactory.firstExtractState(calculateCardsPoint());
    }

    public void lastDealerExtractState() {
        this.state = StateFactory.lastDealerExtractState(calculateCardsPoint());
    }

    public void lastGameParticipantExtractState() {
        this.state = StateFactory.lastGameParticipantExtractState(calculateCardsPoint());
    }

    public void finish() {
        this.state = StateFactory.finishState();
    }

    public boolean leePointThan16() {
        return calculateCardsPoint() <= 16;
    }

    private int calculateCardsPoint() {
        int sum = 0;
        for (Card card : cards) {
            sum = card.getCumulativeScore(sum);
        }
        return sum;
    }

    public boolean isRunning() {
        return state == State.RUNNING;
    }

    public boolean isBlackJack() {
        return state == State.BLACK_JACK;
    }

    public boolean isGameOver() {
        return state == State.GAME_OVER;
    }

    public boolean isFinish() {
        return state == State.FINISH;
    }


    public boolean isNotGameOver() {
        return state != State.GAME_OVER;
    }

    public boolean isSamePoint(Cards cards) {
        return cards.samePoint(calculateCardsPoint());
    }

    private boolean samePoint(int calculateCardsPoint) {
        return calculateCardsPoint() == calculateCardsPoint;
    }

    public boolean morePointThan(Cards gameParticipantCards) {
        return gameParticipantCards.lessThan(calculateCardsPoint());
    }

    private boolean lessThan(int calculateCardsPoint) {
        return calculateCardsPoint() < calculateCardsPoint;
    }

    public int getTotalScore() {
        return calculateCardsPoint();
    }

    public List<Card> getCards() {
        return cards;
    }
}
