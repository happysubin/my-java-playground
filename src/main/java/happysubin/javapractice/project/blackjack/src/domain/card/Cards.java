package happysubin.javapractice.project.blackjack.src.domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cards {

    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card){
        cards.add(card);
        Collections.sort(cards);
    }

    public List<Card> getCards() {
        return cards;
    }
}
