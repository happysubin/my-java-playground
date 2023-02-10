package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.player.state.State;
import happysubin.javapractice.project.blackjack.src.utils.ScannerWrapper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

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
        Deck deck = new Deck();
        GameParticipant player = new GameParticipant(new PlayerInfo("subin", 10000));

        //when
        player.firstDrawTwoCard(deck);

        //then
        assertThat(player.getCardList().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("카드를 받지 않는 테스트")
    void receiveSelectiveCardCase1(){

        //given
        given(ScannerWrapper.getInput()).willReturn("n");
        Deck deck = new Deck();
        GameParticipant gameParticipant = new GameParticipant(new PlayerInfo("subin", 1000));

        //when
        gameParticipant.lastSelectiveDraw(deck);

        //then
        assertThat(gameParticipant.getCardList().size()).isEqualTo(0);
    }

    @Test
    @DisplayName("카드를 2장 받는 테스트")
    void receiveSelectiveCardCase2(){

        //given
        given(ScannerWrapper.getInput()).willReturn("y", "y", "n");
        Deck deck = new Deck();
        GameParticipant gameParticipant = new GameParticipant(new PlayerInfo("subin", 1000));

        //when
        gameParticipant.lastSelectiveDraw(deck);

        //then
        assertThat(gameParticipant.getCardList().size()).isEqualTo(2);
    }
}
