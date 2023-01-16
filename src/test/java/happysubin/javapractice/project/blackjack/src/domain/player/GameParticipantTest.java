package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameParticipantTest {

    @Test
    void receiveFirstTwoCard(){

        //given
        Deck deck = new Deck();
        GameParticipant player = new GameParticipant(new PlayerInfo("subin", 10000));

        //when
        player.receiveFirstTwoCards(deck);

        //then
        Assertions.assertThat(player.getCardList().size()).isEqualTo(2);

    }
}
