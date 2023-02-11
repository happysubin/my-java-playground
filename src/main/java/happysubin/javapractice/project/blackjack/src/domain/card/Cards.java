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
        this.cards = cards;
    }

    public void addCard(Card card){
        cards.add(card);
        Collections.sort(cards);
    }

    public List<Card> getCards() {
        return cards;
    }
}
