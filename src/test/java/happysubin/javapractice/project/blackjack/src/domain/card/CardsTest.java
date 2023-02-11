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
        //given
        Cards cards = createCards(new Card(ACE, SPADE), new Card(JACK, DIAMOND));

        //when
        cards.firstExtractState();

        //then
        assertThat(cards.isBlackJack()).isTrue();
        assertThat(cards.getTotalScore()).isEqualTo(21);
    }


    @Test
    void isRunning(){
        //given
        Cards cards = createCards(new Card(ACE, SPADE), new Card(ACE, DIAMOND));

        //when
        cards.firstExtractState();

        //then
        assertThat(cards.isRunning()).isTrue();
        assertThat(cards.getTotalScore()).isEqualTo(12);
    }

    @Test
    void isDealerGameOver(){
        //given
        Cards cards = createCards(new Card(ACE, SPADE), new Card(ACE, DIAMOND), new Card(JACK, DIAMOND), new Card(KING, HEART));
        //when
        cards.lastDealerExtractState();

        //then
        assertThat(cards.getTotalScore()).isEqualTo(22);
        assertThat(cards.isGameOver()).isTrue();
    }


    @Test
    void isDealerFinish(){
        //given
        Cards cards = createCards(new Card(ACE, SPADE), new Card(JACK, DIAMOND), new Card(KING, HEART));

        //when
        cards.lastDealerExtractState();

        //then
        assertThat(cards.getTotalScore()).isEqualTo(21);
        assertThat(cards.isFinish()).isTrue();
    }


    @Test
    void isGameParticipantGameOver(){
        //given
        Cards cards = createCards(new Card(ACE, SPADE), new Card(FOUR, DIAMOND), new Card(JACK, DIAMOND), new Card(KING, HEART));

        //when
        cards.lastGameParticipantExtractState();

        //then
        assertThat(cards.getTotalScore()).isEqualTo(25);
        assertThat(cards.isGameOver()).isTrue();
    }


    @Test
    void isGameParticipantRunning(){
        //given
        Cards cards = createCards(new Card(ACE, SPADE), new Card(FIVE, HEART));

        //when
        cards.lastGameParticipantExtractState();

        //then
        assertThat(cards.getTotalScore()).isEqualTo(16);
        assertThat(cards.isRunning()).isTrue();
    }

    /**
     * TODO 버그 수정해야함
     */
    @Test
    void aceBug(){
        //given
        Cards cards = createCards(new Card(ACE, SPADE), new Card(ACE, DIAMOND), new Card(JACK, DIAMOND));

        //when
        cards.lastDealerExtractState();

        //then
        assertThat(cards.getTotalScore()).isEqualTo(13);
        assertThat(cards.isFinish()).isTrue();
    }


    private Cards createCards(Card... cards) {
        List<Card> result = new ArrayList<>();

        for (Card card : cards) {
            result.add(card);
        }
        return new Cards(result);
    }
}
