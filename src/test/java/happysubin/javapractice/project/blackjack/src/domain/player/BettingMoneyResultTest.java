package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Card;
import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.card.Level;
import happysubin.javapractice.project.blackjack.src.domain.card.Suit;
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

public class BettingMoneyResultTest {

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
        assertThat(players.getDealer().getCards().isBlackJack()).isTrue();

        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getName()).isEqualTo("subin");
        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getBettingMoney()).isEqualTo(0);
        assertThat(players.getGameParticipants().get(0).getCards().isBlackJack()).isTrue();

        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getName()).isEqualTo("bin");
        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getBettingMoney()).isEqualTo(0);
        assertThat(players.getGameParticipants().get(1).getCards().isBlackJack()).isTrue();

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
        assertThat(players.getDealer().getCards().isRunning()).isTrue();

        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getName()).isEqualTo("subin");
        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getBettingMoney()).isEqualTo(15000);
        assertThat(players.getGameParticipants().get(0).getCards().isBlackJack()).isTrue();

        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getName()).isEqualTo("bin");
        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getBettingMoney()).isEqualTo(15000);
        assertThat(players.getGameParticipants().get(1).getCards().isBlackJack()).isTrue();
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
        assertThat(players.getDealer().getCards().isRunning()).isTrue();

        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getName()).isEqualTo("subin");
        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getBettingMoney()).isEqualTo(10000);
        assertThat(players.getGameParticipants().get(0).getCards().isRunning()).isTrue();

        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getName()).isEqualTo("bin");
        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getBettingMoney()).isEqualTo(15000);
        assertThat(players.getGameParticipants().get(1).getCards().isBlackJack()).isTrue();
    }


    @Test
    @DisplayName("1명만 첫 기회에 블랙잭")
    void onlyDealerBlackJackWhenFirstDraw(){

        //given
        Players players = createPlayers();
        Deck mockDeck = Mockito.mock(Deck.class);

        given(RandomUtil.getRandomNumber(Mockito.anyInt())).willReturn(46);
        given(mockDeck.drawCard(Mockito.anyInt())).willReturn(
                new Card(Level.ACE, Suit.SPADE), new Card(Level.JACK, Suit.SPADE),
                new Card(Level.SIX, Suit.SPADE), new Card(Level.JACK, Suit.SPADE),
                new Card(Level.KING, Suit.SPADE), new Card(Level.JACK, Suit.SPADE)
        );
        players.allPlayerHasTwoCard(mockDeck);

        //when

        players.compareDealerAndGameParticipants();

        //then
        assertThat(players.getDealer().getPlayerInfo().getName()).isEqualTo("딜러");
        assertThat(players.getDealer().getPlayerInfo().getBettingMoney()).isEqualTo(20000);
        assertThat(players.getDealer().getCards().isBlackJack()).isTrue();

        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getName()).isEqualTo("subin");
        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getBettingMoney()).isEqualTo(-10000);
        assertThat(players.getGameParticipants().get(0).getCards().isRunning()).isTrue();

        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getName()).isEqualTo("bin");
        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getBettingMoney()).isEqualTo(-10000);
        assertThat(players.getGameParticipants().get(1).getCards().isRunning()).isTrue();
    }


    @Test
    @DisplayName("딜러가 모든 참가자에게 패배")
    void defeatDealerByAllGameParticipants(){

        //given
        Players players = createPlayers();
        Deck mockDeck = Mockito.mock(Deck.class);

        given(RandomUtil.getRandomNumber(Mockito.anyInt())).willReturn(46);
        given(InputView.inputDrawCommand()).willReturn("y","n","y","n");
        given(mockDeck.drawCard(Mockito.anyInt())).willReturn(
                 new Card(Level.SIX, Suit.SPADE), new Card(Level.KING, Suit.SPADE),new Card(Level.TWO, Suit.SPADE)
        );
        players.hasLastChanceGetCard(mockDeck);

        //when
        players.compareDealerAndGameParticipants();

        //then
        assertThat(players.getDealer().getPlayerInfo().getName()).isEqualTo("딜러");
        assertThat(players.getDealer().getPlayerInfo().getBettingMoney()).isEqualTo(-20000);
        assertThat(players.getDealer().getCards().isFinish()).isTrue();

        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getName()).isEqualTo("subin");
        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getBettingMoney()).isEqualTo(10000);
        assertThat(players.getGameParticipants().get(0).getCards().isFinish()).isTrue();


        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getName()).isEqualTo("bin");
        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getBettingMoney()).isEqualTo(10000);
        assertThat(players.getGameParticipants().get(1).getCards().isFinish()).isTrue();
    }

    @Test
    @DisplayName("오직 한 명의 참가자가 딜러에게 승리")
    void onlyOnePlayerWinFromDealer(){

        //given
        Players players = createPlayers();
        Deck mockDeck = Mockito.mock(Deck.class);

        given(RandomUtil.getRandomNumber(Mockito.anyInt())).willReturn(46);
        given(InputView.inputDrawCommand()).willReturn("y","n","y","n");
        given(mockDeck.drawCard(Mockito.anyInt())).willReturn(
                new Card(Level.THREE, Suit.SPADE), new Card(Level.SEVEN, Suit.SPADE),new Card(Level.SIX, Suit.SPADE)
        );
        players.hasLastChanceGetCard(mockDeck);

        //when
        players.compareDealerAndGameParticipants();

        //then
        assertThat(players.getDealer().getPlayerInfo().getName()).isEqualTo("딜러");
        assertThat(players.getDealer().getPlayerInfo().getBettingMoney()).isEqualTo(0);
        assertThat(players.getDealer().getCards().isFinish()).isTrue();

        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getName()).isEqualTo("subin");
        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getBettingMoney()).isEqualTo(-10000);
        assertThat(players.getGameParticipants().get(0).getCards().isFinish()).isTrue();


        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getName()).isEqualTo("bin");
        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getBettingMoney()).isEqualTo(10000);
        assertThat(players.getGameParticipants().get(1).getCards().isFinish()).isTrue();
    }


    @Test
    @DisplayName("모든 참가자, 딜러가 게임 오버")
    void allMemberGameOver(){

        //given
        Players players = createPlayers();
        Deck mockDeck = Mockito.mock(Deck.class);

        given(RandomUtil.getRandomNumber(Mockito.anyInt())).willReturn(46);
        given(InputView.inputDrawCommand()).willReturn("y");
        given(mockDeck.drawCard(Mockito.anyInt())).willReturn(
                new Card(Level.JACK, Suit.SPADE), new Card(Level.FOUR, Suit.SPADE),new Card(Level.JACK, Suit.SPADE),
                new Card(Level.JACK, Suit.SPADE), new Card(Level.JACK, Suit.SPADE),new Card(Level.JACK, Suit.SPADE),
                new Card(Level.JACK, Suit.SPADE), new Card(Level.JACK, Suit.SPADE),new Card(Level.JACK, Suit.SPADE)
                );
        players.allPlayerHasTwoCard(mockDeck);
        players.hasLastChanceGetCard(mockDeck);

        //when
        players.compareDealerAndGameParticipants();

        //then
        assertThat(players.getDealer().getPlayerInfo().getName()).isEqualTo("딜러");
        assertThat(players.getDealer().getPlayerInfo().getBettingMoney()).isEqualTo(20000);
        assertThat(players.getDealer().getCards().isGameOver()).isTrue();

        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getName()).isEqualTo("subin");
        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getBettingMoney()).isEqualTo(-10000);
        assertThat(players.getGameParticipants().get(0).getCards().isGameOver()).isTrue();


        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getName()).isEqualTo("bin");
        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getBettingMoney()).isEqualTo(-10000);
        assertThat(players.getGameParticipants().get(1).getCards().isGameOver()).isTrue();
    }

    @Test
    @DisplayName("모든 참가자가 딜러에게 승리")
    void allMemberWin(){

        //given
        Players players = createPlayers();
        Deck mockDeck = Mockito.mock(Deck.class);

        given(RandomUtil.getRandomNumber(Mockito.anyInt())).willReturn(46);
        given(InputView.inputDrawCommand()).willReturn("y","n","y","n");
        given(mockDeck.drawCard(Mockito.anyInt())).willReturn(
                new Card(Level.JACK, Suit.SPADE), new Card(Level.SEVEN, Suit.SPADE),new Card(Level.JACK, Suit.SPADE),
                new Card(Level.JACK, Suit.SPADE), new Card(Level.JACK, Suit.SPADE),new Card(Level.JACK, Suit.SPADE),
                new Card(Level.ACE, Suit.SPADE), new Card(Level.ACE, Suit.HEART)
        );
        players.allPlayerHasTwoCard(mockDeck);
        players.hasLastChanceGetCard(mockDeck);

        //when
        players.compareDealerAndGameParticipants();

        //then
        assertThat(players.getDealer().getPlayerInfo().getName()).isEqualTo("딜러");
        assertThat(players.getDealer().getPlayerInfo().getBettingMoney()).isEqualTo(-20000);
        assertThat(players.getDealer().getCards().isFinish()).isTrue();

        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getName()).isEqualTo("subin");
        assertThat(players.getGameParticipants().get(0).getPlayerInfo().getBettingMoney()).isEqualTo(10000);
        assertThat(players.getGameParticipants().get(0).getCards().isFinish()).isTrue();


        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getName()).isEqualTo("bin");
        assertThat(players.getGameParticipants().get(1).getPlayerInfo().getBettingMoney()).isEqualTo(10000);
        assertThat(players.getGameParticipants().get(1).getCards().isFinish()).isTrue();
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
