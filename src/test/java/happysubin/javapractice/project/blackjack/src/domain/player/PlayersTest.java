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
        assertThat(players.getPlayers().get(0).getCards().getCards().size()).isEqualTo(2);
        assertThat(players.getPlayers().get(1).getCards().getCards().size()).isEqualTo(2);
    }

    private Players createPlayers() {
        return new Players(
                List.of(
                        new GameParticipant(new PlayerInfo("subin", 10000)),
                        new GameParticipant(new PlayerInfo("subin", 10000))
                ), new Dealer()
        );
    }


}
