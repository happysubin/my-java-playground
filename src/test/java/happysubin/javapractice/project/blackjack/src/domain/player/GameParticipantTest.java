package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.*;
import happysubin.javapractice.project.blackjack.src.domain.player.state.BlackJack;
import happysubin.javapractice.project.blackjack.src.domain.player.state.Bust;
import happysubin.javapractice.project.blackjack.src.domain.player.state.Hit;
import happysubin.javapractice.project.blackjack.src.domain.player.state.Stay;
import happysubin.javapractice.project.blackjack.src.utils.ScannerWrapper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static happysubin.javapractice.project.blackjack.src.domain.card.Level.*;
import static happysubin.javapractice.project.blackjack.src.domain.card.Suit.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.mockStatic;

public class GameParticipantTest {

    MockedStatic<ScannerWrapper> mockedStatic;

    @BeforeEach
    void beforeEach(){
        mockedStatic = mockStatic(ScannerWrapper.class); //매번 모킹해야 한다.
    }

    @AfterEach
    void afterEach(){
        mockedStatic.close();
    }

    @Test
    @DisplayName("처음 2개의 카드를 뽑는다.")
    void receiveFirstTwoCard(){

        //given
        Deck deck = mock(Deck.class);
        GameParticipant gameParticipant = createGameParticipant(10000);

        //when
        when(deck.getDeckSize()).thenReturn(52);
        when(deck.drawCard(anyInt())).thenReturn(new Card(JACK,DIAMOND), new Card(NINE, CLOVER));
        gameParticipant.firstDrawTwoCard(deck);

        //then
        assertThat(gameParticipant.getCards().getCards().size()).isEqualTo(2);
        assertThat(gameParticipant.getTotalScore()).isSameAs(19);
        assertThat(gameParticipant.state.getClass()).isSameAs(Hit.class);
    }

    @Test
    @DisplayName("카드를 받지 않는 테스트")
    void receiveSelectiveCardCase1(){

        //given
        given(ScannerWrapper.getInput()).willReturn("n");
        Deck deck = new Deck();
        GameParticipant gameParticipant = createGameParticipant(1000);

        //when
        gameParticipant.firstDrawTwoCard(deck);
        gameParticipant.lastSelectiveDraw(deck);

        //then
        assertThat(gameParticipant.getCards().getCards().size()).isEqualTo(2);
        assertThat(gameParticipant.state.getClass()).isSameAs(Stay.class);
    }

    @Test
    @DisplayName("카드를 2장 받는 테스트")
    void receiveSelectiveCardCase2(){

        //given
        given(ScannerWrapper.getInput()).willReturn("y", "y", "n");
        Deck deck = mock(Deck.class);

        GameParticipant gameParticipant = createGameParticipant(1000);

        //when
        when(deck.getDeckSize()).thenReturn(52);
        when(deck.drawCard(anyInt())).thenReturn(new Card(FIVE, DIAMOND),new Card(FIVE, HEART),new Card(FIVE, SPADE),new Card(FIVE, CLOVER));
        gameParticipant.firstDrawTwoCard(deck);
        gameParticipant.lastSelectiveDraw(deck);

        //then
        assertThat(gameParticipant.getCards().getTotalScore()).isEqualTo(20);
        assertThat(gameParticipant.getCards().getCards().size()).isEqualTo(4);
        assertThat(gameParticipant.state.getClass()).isSameAs(Stay.class);
    }

    @Test
    void blackJack(){
        //given
        Deck deck = mock(Deck.class);
        GameParticipant gameParticipant = createGameParticipant(1000);


        //when
        when(deck.getDeckSize()).thenReturn(52);
        when(deck.drawCard(anyInt())).thenReturn(new Card(KING, CLOVER), new Card(ACE, SPADE));

        gameParticipant.firstDrawTwoCard(deck);
        gameParticipant.lastSelectiveDraw(deck);

        //then
        assertThat(gameParticipant.getCards().getTotalScore()).isEqualTo(21);
        assertThat(gameParticipant.getCards().getCards().size()).isEqualTo(2);
        assertThat(gameParticipant.state.getClass()).isSameAs(BlackJack.class);
    }

    @Test
    void bust(){
        //given
        Deck deck = mock(Deck.class);
        GameParticipant gameParticipant = createGameParticipant(1000);

        //then
        when(ScannerWrapper.getInput()).thenReturn("y","n");
        when(deck.getDeckSize()).thenReturn(52);
        when(deck.drawCard(anyInt())).thenReturn(new Card(KING, CLOVER), new Card(JACK, SPADE), new Card(QUEEN, HEART));

        gameParticipant.firstDrawTwoCard(deck);
        gameParticipant.lastSelectiveDraw(deck);

        //then
        assertThat(gameParticipant.getCards().getTotalScore()).isEqualTo(30);
        assertThat(gameParticipant.getCards().getCards().size()).isEqualTo(3);
        assertThat(gameParticipant.state.getClass()).isSameAs(Bust.class);
    }

    private GameParticipant createGameParticipant(int bettingMoney) {
        return new GameParticipant(new PlayerInfo("subin", bettingMoney), new Cards());
    }
}
