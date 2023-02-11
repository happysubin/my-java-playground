package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.card.Level;
import happysubin.javapractice.project.blackjack.src.domain.card.Suit;
import happysubin.javapractice.project.blackjack.src.domain.player.state.State;
import happysubin.javapractice.project.blackjack.src.utils.RandomUtil;
import happysubin.javapractice.project.blackjack.src.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class StateTest {


    MockedStatic<RandomUtil> mockedStatic;
    MockedStatic<InputView> inputViewMockedStatic;

    @BeforeEach
    void beforeEach(){
        mockedStatic = mockStatic(RandomUtil.class);
        inputViewMockedStatic = mockStatic(InputView.class);
    }

    @AfterEach
    void afterEach(){
        mockedStatic.close();
        inputViewMockedStatic.close();
    }


    @Test
    @DisplayName("모든 플레이어가 첫 번째 기회에 블랙잭")
    void allPlayerBlackJackWithoutDealerWhenFirstDraw(){

        //given
        Players players = createPlayers();
        Deck mockDeck = Mockito.mock(Deck.class);

        //when
        given(RandomUtil.getRandomNumber(Mockito.anyInt())).willReturn(46);
        given(mockDeck.drawCard(Mockito.anyInt())).willReturn(
                new Card(Level.ACE, Suit.SPADE), new Card(Level.JACK, Suit.SPADE),
                new Card(Level.ACE, Suit.SPADE), new Card(Level.JACK, Suit.SPADE),
                new Card(Level.ACE, Suit.SPADE), new Card(Level.JACK, Suit.SPADE)
        );
        players.allPlayerHasTwoCard(mockDeck);

        //when
        players.compareDealerAndGameParticipants();


        //then
        assertThat(players.getDealer().getPlayerInfo().getName()).isEqualTo("딜러");
        assertThat(players.getDealer().getPlayerInfo().getBettingMoney()).isEqualTo(0);
        assertThat(players.getDealer().getState()).isSameAs(State.BLACK_JACK);

        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getName()).isEqualTo("subin");
        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getBettingMoney()).isEqualTo(0);
        assertThat(players.getGameParticipants().get(0).getState()).isEqualTo(State.BLACK_JACK);

        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getName()).isEqualTo("bin");
        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getBettingMoney()).isEqualTo(0);
        assertThat(players.getGameParticipants().get(1).getState()).isEqualTo(State.BLACK_JACK);
    }

    @Test
    @DisplayName("딜러빼고 모두 첫 번째 기회에 블랙잭")
    void allPlayerBlackJackWhenFirstDraw(){

        //given
        Players players = createPlayers();
        Deck mockDeck = Mockito.mock(Deck.class);
        given(RandomUtil.getRandomNumber(Mockito.anyInt())).willReturn(46);
        given(mockDeck.drawCard(Mockito.anyInt())).willReturn(
                new Card(Level.FOUR, Suit.SPADE), new Card(Level.JACK, Suit.SPADE), // 14 딜러
                new Card(Level.ACE, Suit.SPADE), new Card(Level.JACK, Suit.SPADE), // 21
                new Card(Level.ACE, Suit.SPADE), new Card(Level.JACK, Suit.SPADE) // 21
        );
        players.allPlayerHasTwoCard(mockDeck);

        //when
        players.compareDealerAndGameParticipants();

        //then
        assertThat(players.getDealer().getPlayerInfo().getName()).isEqualTo("딜러");
        assertThat(players.getDealer().getPlayerInfo().getBettingMoney()).isEqualTo(-30000);
        assertThat(players.getDealer().getState()).isEqualTo(State.RUNNING);

        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getName()).isEqualTo("subin");
        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getBettingMoney()).isEqualTo(15000);
        assertThat(players.getGameParticipants().get(0).getState()).isEqualTo(State.BLACK_JACK);

        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getName()).isEqualTo("bin");
        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getBettingMoney()).isEqualTo(15000);
        assertThat(players.getGameParticipants().get(1).getState()).isEqualTo(State.BLACK_JACK);
    }

    @Test
    @DisplayName("1명만 첫 기회에 블랙잭")
    void onlyOnePlayerBlackJackWhenFirstDraw(){

        //given
        Players players = createPlayers();
        Deck mockDeck = Mockito.mock(Deck.class);

        given(RandomUtil.getRandomNumber(Mockito.anyInt())).willReturn(46);
        given(mockDeck.drawCard(Mockito.anyInt())).willReturn(
                new Card(Level.SIX, Suit.SPADE), new Card(Level.JACK, Suit.SPADE), // 14
                new Card(Level.KING, Suit.SPADE), new Card(Level.JACK, Suit.SPADE), // 20
                new Card(Level.ACE, Suit.SPADE), new Card(Level.JACK, Suit.SPADE) // 21
        );
        players.allPlayerHasTwoCard(mockDeck);

        //when

        players.compareDealerAndGameParticipants();

        //then
        assertThat(players.getDealer().getPlayerInfo().getName()).isEqualTo("딜러");
        assertThat(players.getDealer().getPlayerInfo().getBettingMoney()).isEqualTo(-25000);
        assertThat(players.getDealer().getState()).isEqualTo(State.RUNNING);

        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getName()).isEqualTo("subin");
        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getBettingMoney()).isEqualTo(10000);
        assertThat(players.getGameParticipants().get(0).getState()).isEqualTo(State.RUNNING);

        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getName()).isEqualTo("bin");
        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getBettingMoney()).isEqualTo(15000);
        assertThat(players.getGameParticipants().get(1).getState()).isEqualTo(State.BLACK_JACK);
    }


    @Test
    @DisplayName("1명만 첫 기회에 블랙잭")
    void onlyOnePlayerBlackJackWhenFirstDra(){

        //given
        Players players = createPlayers();
        Deck mockDeck = Mockito.mock(Deck.class);

        given(RandomUtil.getRandomNumber(Mockito.anyInt())).willReturn(46);
        given(mockDeck.drawCard(Mockito.anyInt())).willReturn(
                new Card(Level.SIX, Suit.SPADE), new Card(Level.JACK, Suit.SPADE), // 14
                new Card(Level.KING, Suit.SPADE), new Card(Level.JACK, Suit.SPADE), // 20
                new Card(Level.ACE, Suit.SPADE), new Card(Level.JACK, Suit.SPADE) // 21
        );
        players.allPlayerHasTwoCard(mockDeck);

        //when

        players.compareDealerAndGameParticipants();

        //then
        assertThat(players.getDealer().getPlayerInfo().getName()).isEqualTo("딜러");
        assertThat(players.getDealer().getPlayerInfo().getBettingMoney()).isEqualTo(-25000);
        assertThat(players.getDealer().getState()).isEqualTo(State.RUNNING);

        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getName()).isEqualTo("subin");
        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getBettingMoney()).isEqualTo(10000);
        assertThat(players.getGameParticipants().get(0).getState()).isEqualTo(State.RUNNING);

        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getName()).isEqualTo("bin");
        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getBettingMoney()).isEqualTo(15000);
        assertThat(players.getGameParticipants().get(1).getState()).isEqualTo(State.BLACK_JACK);
    }


    private Players createPlayers() {
        return new Players(
                List.of(
                        new GameParticipant(new PlayerInfo("subin", 10000)),
                        new GameParticipant(new PlayerInfo("bin", 10000))
                ), new Dealer()
        );
    }
}
