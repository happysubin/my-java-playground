package happysubin.javapractice.project.blackjack.src.domain.card;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static happysubin.javapractice.project.blackjack.src.domain.card.Level.*;
import static happysubin.javapractice.project.blackjack.src.domain.card.Suit.*;
import static org.assertj.core.api.Assertions.*;

public class CardsTest {

    @Test
    void isBlackJack(){
        Cards cards = createCards(new Card(ACE, SPADE), new Card(JACK, DIAMOND));

        assertThat(cards.isBlackJack()).isTrue();
        assertThat(cards.getTotalScore()).isEqualTo(21);
    }


    @Test
    void isLessPointThan16(){
        Cards cards = createCards(new Card(ACE, SPADE), new Card(ACE, DIAMOND));

        assertThat(cards.lessPointThan16()).isTrue();
        assertThat(cards.getTotalScore()).isEqualTo(12);
    }

    @Test
    void isBurst(){
        Cards cards = createCards(new Card(ACE, SPADE), new Card(ACE, DIAMOND), new Card(JACK, DIAMOND), new Card(KING, HEART));

        assertThat(cards.getTotalScore()).isEqualTo(22);
        assertThat(cards.isBust()).isTrue();
    }


    @Test
    void pointSame21ButNotBlackJack(){
        Cards cards = createCards(new Card(ACE, SPADE), new Card(JACK, DIAMOND), new Card(KING, HEART));

        assertThat(cards.getTotalScore()).isEqualTo(21);
        assertThat(cards.isBlackJack()).isFalse();
    }

    /**
     * TODO 버그 수정해야함
     */
    @Test
    void aceBug(){
        Cards cards = createCards(new Card(ACE, SPADE), new Card(ACE, DIAMOND), new Card(JACK, DIAMOND));

        assertThat(cards.getTotalScore()).isEqualTo(13);
    }


    private Cards createCards(Card... cards) {
        List<Card> result = new ArrayList<>();

        for (Card card : cards) {
            result.add(card);
        }
        return new Cards(result);
    }
}
