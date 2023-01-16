package happysubin.javapractice.project.blackjack.src.domain.card;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> cardList = new ArrayList<>();

    public Deck() {
        initDeck();
    }

    public Card getCard(int deckSize) {
        return cardList.remove(deckSize);
    }

    private void initDeck(){
        initCardList(Level.getLevelList(), Suit.getSuitList());
    }

    private void initCardList(List<Level> levelList, List<Suit> suitList) {
        levelList.forEach(level -> {
            makeCard(suitList, level);
        });
    }

    private void makeCard(List<Suit> suitList, Level level) {
        suitList.forEach(suit -> {
            cardList.add(new Card(level, suit));
        });
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public Integer getDeckSize(){
        return cardList.size();
    }
}
