package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PlayersTest {

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

}
