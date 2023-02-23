package happysubin.javapractice.project.blackjack.src.domain.card;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cards {

    private List<Card> cards = new ArrayList<>();

    public Cards() {}

    /**
     * 테스트 코드용 생성자
     */
    public Cards(List<Card> cards) {
        Collections.sort(cards);
        this.cards = cards;
    }

    public void add(Card card){
        cards.add(card);
        Collections.sort(cards);
    }

    public int getTotalScore() {
        return calculateCardsPoint();
    }

    public boolean lessPointThan16() {
        return calculateCardsPoint() <= 16;
    }

    public boolean isBlackJack() {
        return calculateCardsPoint() == 21 & cards.size() == 2;
    }

    public boolean isBust() {
        return calculateCardsPoint() > 21;
    }

    private int calculateCardsPoint() {
        int sum = 0;
        for (Card card : cards) {
            sum = card.getCumulativeScore(sum);
        }
        return sum;
    }

    public List<Card> getCards() {
        return cards;
    }
}
