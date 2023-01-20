package happysubin.javapractice.project.blackjack.src.domain.card;

import happysubin.javapractice.project.blackjack.src.domain.player.GameParticipant;
import happysubin.javapractice.project.blackjack.src.domain.player.PlayerInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardTest {

    @Test
    void isAce(){

        //given
        Card card1 = new Card(Level.ACE, Suit.CLOVER);
        Card card2 = new Card(Level.KING, Suit.CLOVER);

        //when
        boolean result1 = card1.isAceCard();
        boolean result2 = card2.isAceCard();

        //then

        Assertions.assertThat(result1).isTrue();
        Assertions.assertThat(result2).isFalse();
    }

    @Test
    @DisplayName("에이스는 제일 마지막에 항상 존재하도록 정렬을 확인하는 테스트")
    void sortedTest(){

        //given
        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(Level.ACE, Suit.CLOVER));
        cards.add(new Card(Level.KING, Suit.CLOVER));
        cards.add(new Card(Level.QUEEN, Suit.CLOVER));

        //when
        Collections.sort(cards);

        //then
        Assertions.assertThat(cards.get(2).isAceCard()).isTrue();
    }

    @Test
    @DisplayName("에이스를 11 점수로 계산했을 때 총 점수 검사 테스트")
    void calculateAceScoreIs11Test(){
        //given
        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(Level.ACE, Suit.CLOVER));
        cards.add(new Card(Level.KING, Suit.CLOVER));
        cards.add(new Card(Level.KING, Suit.HEART));

        Collections.sort(cards);

        //when
        int sum = 0;
        for (Card card : cards) {
            sum = card.getCumulativeScore(sum);
        }

        //then
        Assertions.assertThat(sum).isEqualTo(21);
    }

    @Test
    @DisplayName("에이스를 11 점수로 계산했을 때 총 점수 검사 테스트")
    void calculateAceScoreIs1Test(){
        //given
        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(Level.ACE, Suit.CLOVER));
        cards.add(new Card(Level.KING, Suit.HEART));
        cards.add(new Card(Level.QUEEN, Suit.SPADE));
        Collections.sort(cards);

        //when
        int sum = 0;
        for (Card card : cards) {
            sum = card.getCumulativeScore(sum);
        }

        //then
        Assertions.assertThat(sum).isEqualTo(21);
    }
}
