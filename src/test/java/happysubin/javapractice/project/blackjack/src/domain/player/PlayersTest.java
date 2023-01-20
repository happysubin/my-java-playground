package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.*;
import happysubin.javapractice.project.blackjack.src.domain.player.state.State;
import happysubin.javapractice.project.blackjack.src.utils.RandomUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.mockStatic;

public class PlayersTest {


    MockedStatic<RandomUtil> mockedStatic;

    @BeforeEach
    void beforeEach(){
        mockedStatic = mockStatic(RandomUtil.class); //매번 모킹해야 한다.
    }

    @AfterEach
    void afterEach(){
        mockedStatic.close();
    }

    @Test
    void receiveFirstTwoCard(){

        //given
        Deck deck = new Deck();
        Players players = createPlayers();

        //when
        players.allPlayerHasTwoCard(deck);

        //then
        assertThat(players.getPlayers().get(0).getCardList().size()).isEqualTo(2);
        assertThat(players.getPlayers().get(1).getCardList().size()).isEqualTo(2);
    }

    private Players createPlayers() {
        return new Players(
                List.of(
                        new GameParticipant(new PlayerInfo("subin", 10000)),
                        new GameParticipant(new PlayerInfo("subin", 10000))
                ), new Dealer()
        );
    }

    @Test
    @DisplayName("모든 플레이어가 첫 번째 기회에 블랙잭")
    void allPlayerBlackJackWithoutDealerWhenFirstDraw(){

        //given
        Players players = createPlayers();
        Deck mockDeck = Mockito.mock(Deck.class);

        //when
        when(RandomUtil.getRandomNumber(Mockito.anyInt())).thenReturn(46);
        when(mockDeck.drawCard(Mockito.anyInt())).thenReturn(
                new Card(Level.ACE, Suit.SPADE), new Card(Level.JACK, Suit.SPADE),
                new Card(Level.ACE, Suit.SPADE), new Card(Level.JACK, Suit.SPADE),
                new Card(Level.ACE, Suit.SPADE), new Card(Level.JACK, Suit.SPADE)
        );
        players.allPlayerHasTwoCard(mockDeck);

        //then
        assertThat(players.getDealer().getPlayerInfo().getBettingMoney()).isEqualTo(0);
        assertThat(players.getDealer().getState()).isEqualTo(State.BLACK_JACK);

        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getBettingMoney()).isEqualTo(10000);
        assertThat(players.getGameParticipants().get(0).getState()).isEqualTo(State.BLACK_JACK);

        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getBettingMoney()).isEqualTo(10000);
        assertThat(players.getGameParticipants().get(1).getState()).isEqualTo(State.BLACK_JACK);

    }

    @Test
    @DisplayName("딜러빼고 모두 첫 번째 기회에 블랙잭")
    void allPlayerBlackJackWhenFirstDraw(){

        //given
        Players players = createPlayers();
        Deck mockDeck = Mockito.mock(Deck.class);

        //when
        when(RandomUtil.getRandomNumber(Mockito.anyInt())).thenReturn(46);
        when(mockDeck.drawCard(Mockito.anyInt())).thenReturn(
                new Card(Level.FOUR, Suit.SPADE), new Card(Level.JACK, Suit.SPADE),
                new Card(Level.ACE, Suit.SPADE), new Card(Level.JACK, Suit.SPADE),
                new Card(Level.ACE, Suit.SPADE), new Card(Level.JACK, Suit.SPADE)
        );
        players.allPlayerHasTwoCard(mockDeck);

        //then
        assertThat(players.getDealer().getPlayerInfo().getBettingMoney()).isEqualTo(-10000);
        assertThat(players.getDealer().getState()).isEqualTo(State.RUNNING);

        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getBettingMoney()).isEqualTo(15000);
        assertThat(players.getGameParticipants().get(0).getState()).isEqualTo(State.BLACK_JACK);

        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getBettingMoney()).isEqualTo(15000);
        assertThat(players.getGameParticipants().get(1).getState()).isEqualTo(State.BLACK_JACK);

    }

    @Test
    @DisplayName("1명만 첫 기회에 블랙잭")
    void onlyOnePlayerBlackJackWhenFirstDraw(){

        //given
        Players players = createPlayers();
        Deck mockDeck = Mockito.mock(Deck.class);

        //when
        when(RandomUtil.getRandomNumber(Mockito.anyInt())).thenReturn(46);
        when(mockDeck.drawCard(Mockito.anyInt())).thenReturn(
                new Card(Level.FOUR, Suit.SPADE), new Card(Level.JACK, Suit.SPADE),
                new Card(Level.KING, Suit.SPADE), new Card(Level.JACK, Suit.SPADE),
                new Card(Level.ACE, Suit.SPADE), new Card(Level.JACK, Suit.SPADE)
        );
        players.allPlayerHasTwoCard(mockDeck);

        //then
        assertThat(players.getDealer().getPlayerInfo().getBettingMoney()).isEqualTo(-5000);
        assertThat(players.getDealer().getState()).isEqualTo(State.RUNNING);

        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getBettingMoney()).isEqualTo(10000);
        assertThat(players.getGameParticipants().get(0).getState()).isEqualTo(State.RUNNING);

        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getBettingMoney()).isEqualTo(15000);
        assertThat(players.getGameParticipants().get(1).getState()).isEqualTo(State.BLACK_JACK);
    }
}
