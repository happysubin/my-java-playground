package happysubin.javapractice.project.blackjack.src.domain.card;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DeckTest {

    @Test
    void createDeck(){
        Deck deck = new Deck();

        Assertions.assertThat(deck.getCardList().size()).isEqualTo(52);
    }

}