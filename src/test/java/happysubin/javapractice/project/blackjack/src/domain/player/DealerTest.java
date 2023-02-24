package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.*;
import happysubin.javapractice.project.blackjack.src.domain.player.state.BlackJack;
import happysubin.javapractice.project.blackjack.src.domain.player.state.Bust;
import happysubin.javapractice.project.blackjack.src.domain.player.state.Stay;
import happysubin.javapractice.project.blackjack.src.utils.RandomUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.CallsRealMethods;


import static happysubin.javapractice.project.blackjack.src.domain.card.Level.*;
import static happysubin.javapractice.project.blackjack.src.domain.card.Suit.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

public class DealerTest {

    @Test
    @DisplayName("16이하면 카드를 한장 더 뽑는다.")
    void scoreLessThan16ReceiveCard(){
        //given
        Deck mockDeck = mock(Deck.class);
        Dealer dealer = new Dealer(new Cards());

        //when
        when(mockDeck.getDeckSize()).thenReturn(52);
        when(mockDeck.drawCard(Mockito.anyInt())).thenReturn(new Card(FOUR, DIAMOND), new Card(FIVE, SPADE), new Card(SIX, SPADE));
        dealer.firstDrawTwoCard(mockDeck);
        dealer.lastDraw(mockDeck);

        //then
        assertThat(dealer.state.getClass()).isEqualTo(Stay.class);
        assertThat(dealer.getCards().getCards().size()).isEqualTo(3);
        assertThat(dealer.state.cards().getTotalScore()).isEqualTo(15);
    }

    @Test
    @DisplayName("17이상이면 카드를 뽑지 않는다.")
    void scoreMoreThan17DontReceiveCard(){
        //given
        Deck mockDeck = mock(Deck.class);
        Dealer dealer = new Dealer(new Cards());

        //when
        when(mockDeck.getDeckSize()).thenReturn(52);
        when(mockDeck.drawCard(Mockito.anyInt())).thenReturn(new Card(ACE, DIAMOND), new Card(SIX, SPADE));
        dealer.firstDrawTwoCard(mockDeck);
        dealer.lastDraw(mockDeck);

        //then
        assertThat(dealer.state.getClass()).isEqualTo(Stay.class);
        assertThat(dealer.getCards().getCards().size()).isEqualTo(2);
        assertThat(dealer.state.cards().getTotalScore()).isEqualTo(17);
    }

    @Test
    @DisplayName("딜러의 블랙잭")
    void dealerHasBlackJack(){
        //given
        Deck mockDeck = mock(Deck.class);
        Dealer dealer = new Dealer(new Cards());

        //when
        when(mockDeck.getDeckSize()).thenReturn(52);
        when(mockDeck.drawCard(Mockito.anyInt())).thenReturn(new Card(ACE, DIAMOND), new Card(JACK, SPADE));
        dealer.firstDrawTwoCard(mockDeck);
        dealer.lastDraw(mockDeck);

        //then
        assertThat(dealer.state.getClass()).isEqualTo(BlackJack.class);
        assertThat(dealer.getCards().getCards().size()).isEqualTo(2);
        assertThat(dealer.state.cards().getTotalScore()).isEqualTo(21);
    }

    @Test
    @DisplayName("딜러의 버스트")
    void dealerHasBust(){
        //given
        Deck mockDeck = mock(Deck.class);
        Dealer dealer = new Dealer(new Cards());

        //when
        when(mockDeck.getDeckSize()).thenReturn(52);
        when(mockDeck.drawCard(Mockito.anyInt())).thenReturn(new Card(SIX, DIAMOND), new Card(JACK, SPADE), new Card(KING, HEART));
        dealer.firstDrawTwoCard(mockDeck);
        dealer.lastDraw(mockDeck);

        assertThat(dealer.state.getClass()).isEqualTo(Bust.class);
        assertThat(dealer.getCards().getCards().size()).isEqualTo(3);
        assertThat(dealer.state.cards().getTotalScore()).isEqualTo(26);
    }
}
