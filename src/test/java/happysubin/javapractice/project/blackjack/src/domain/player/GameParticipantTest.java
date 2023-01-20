package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.state.State;
import happysubin.javapractice.project.blackjack.src.utils.ScannerWrapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

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
    void receiveFirstTwoCard(){

        //given
        Deck deck = new Deck();
        GameParticipant player = new GameParticipant(new PlayerInfo("subin", 10000));

        //when
        player.firstDrawTwoCard(deck, State.RUNNING);

        //then
        Assertions.assertThat(player.getCardList().size()).isEqualTo(2);

    }

    @Test
    void receiveSelectiveCardCase1(){

        //given
        given(ScannerWrapper.getInput()).willReturn("n");
        Deck deck = new Deck();
        GameParticipant gameParticipant = new GameParticipant(new PlayerInfo("subin", 1000));

        //when
        gameParticipant.lastSelectiveDraw(deck);

        //then
        Assertions.assertThat(gameParticipant.getCardList().size()).isEqualTo(0);
    }

    @Test
    void receiveSelectiveCardCase2(){

        //given
        given(ScannerWrapper.getInput()).willReturn("y", "y", "n");
        Deck deck = new Deck();
        GameParticipant gameParticipant = new GameParticipant(new PlayerInfo("subin", 1000));

        //when
        gameParticipant.lastSelectiveDraw(deck);

        //then

        Assertions.assertThat(gameParticipant.getCardList().size()).isEqualTo(2);

    }
}
