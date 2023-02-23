package happysubin.javapractice.project.blackjack.src.domain;

import happysubin.javapractice.project.blackjack.src.domain.card.*;
import happysubin.javapractice.project.blackjack.src.domain.player.state.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static happysubin.javapractice.project.blackjack.src.domain.card.Level.*;
import static happysubin.javapractice.project.blackjack.src.domain.card.Suit.*;

public class StateTest {

    @Test
    void blackJackTest(){
        RightAfterStarted state = new RightAfterStarted(new Cards(), 0);

        State state1 = state.draw(new Card(ACE, DIAMOND));
        State state2 = state1.draw(new Card(KING, DIAMOND));

        Assertions.assertThat(state1).isInstanceOf(RightAfterStarted.class);
        Assertions.assertThat(state2).isInstanceOf(BlackJack.class);
    }

    @Test
    void hitTest(){
        RightAfterStarted state = new RightAfterStarted(new Cards(), 0);

        State state1 = state.draw(new Card(ACE, DIAMOND));
        State state2 = state1.draw(new Card(FIVE, DIAMOND));

        Assertions.assertThat(state1).isInstanceOf(RightAfterStarted.class);
        Assertions.assertThat(state2).isInstanceOf(Hit.class);
    }

    @Test
    void bustTest(){
        RightAfterStarted state = new RightAfterStarted(new Cards(), 0);

        State state1 = state.draw(new Card(TWO, DIAMOND));
        State state2 = state1.draw(new Card(KING, DIAMOND));
        State state3 = state2.draw(new Card(JACK, DIAMOND));

        Assertions.assertThat(state1).isInstanceOf(RightAfterStarted.class);
        Assertions.assertThat(state2).isInstanceOf(Hit.class);
        Assertions.assertThat(state3).isInstanceOf(Bust.class);

    }

    @Test
    void scoreIs21ButNotBlackJackTest(){
        RightAfterStarted state = new RightAfterStarted(new Cards(), 0);

        State state1 = state.draw(new Card(ACE, DIAMOND));
        State state2 = state1.draw(new Card(FIVE, DIAMOND));
        State state3 = state2.draw(new Card(FIVE, HEART));

        Assertions.assertThat(state1).isInstanceOf(RightAfterStarted.class);
        Assertions.assertThat(state2).isInstanceOf(Hit.class);
        Assertions.assertThat(state3).isInstanceOf(Hit.class);
    }
}
