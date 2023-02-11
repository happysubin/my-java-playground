package happysubin.javapractice.project.blackjack.src.domain.card;

public class Card implements Comparable<Card> {

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

    public boolean isAceCard(){
        return Level.isAce(level);
    }

    public int getCumulativeScore(int sum) {
        if (!isAceCard()){
            return sum + level.score();
        }
        if(sum < 11 ){
            return sum + 11;
        }
        return sum + 1;
    }

    @Override
    public int compareTo(Card o) {
        if(o.isAceCard()) return -1;
        return 1;
    }
}
