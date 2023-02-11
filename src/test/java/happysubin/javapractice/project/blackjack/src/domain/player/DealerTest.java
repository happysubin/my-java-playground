package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.*;
import happysubin.javapractice.project.blackjack.src.utils.RandomUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;


import static org.mockito.BDDMockito.*;

public class DealerTest {

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
    @DisplayName("16이하면 카드를 한장 더 뽑는다.")
    void selectiveReceiveCard(){

        //given
        Deck deck = new Deck();
        given(RandomUtil.getRandomNumber(Mockito.any(Integer.class))).willReturn(0);
        Dealer dealer = new Dealer(){
            @Override
            public void firstDrawTwoCard(Deck deck) {
                super.firstDrawTwoCard(deck);
            }
        };

        //when
        dealer.lastDraw(deck);

        //then
        Assertions.assertThat(dealer.getCards().getCards().size()).isEqualTo(1);
    }
}
