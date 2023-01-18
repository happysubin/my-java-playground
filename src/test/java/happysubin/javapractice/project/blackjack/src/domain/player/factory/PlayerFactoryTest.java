package happysubin.javapractice.project.blackjack.src.domain.player.factory;

import happysubin.javapractice.project.blackjack.src.domain.player.GameParticipant;
import happysubin.javapractice.project.blackjack.src.domain.player.GameParticipantImpl;
import happysubin.javapractice.project.blackjack.src.domain.player.Player;
import happysubin.javapractice.project.blackjack.src.utils.ScannerWrapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.MockedStatic;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

class PlayerFactoryTest {

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
    void createPlayers(){
        //given
        BDDMockito.given(ScannerWrapper.getInput()).willReturn("su,bin", "1000", "2000");

        //when
        List<GameParticipantImpl> player = PlayerFactory.createPlayer();

        //then
        assertThat(player.size()).isEqualTo(2);
    }
}