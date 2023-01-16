package happysubin.javapractice.project.blackjack.src.domain.card;

public class Card {

    private final Level level;
    private final Suit suit;

    public Card(Level level, Suit suit) {
        this.level = level;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return level.toString() + suit.toString();
    }
}
