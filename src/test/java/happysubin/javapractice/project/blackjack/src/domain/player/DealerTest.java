package happysubin.javapractice.project.blackjack.src.domain.player;

import happysubin.javapractice.project.blackjack.src.domain.card.Deck;
import happysubin.javapractice.project.blackjack.src.domain.draw.DealerStrategy;
import happysubin.javapractice.project.blackjack.src.utils.RandomUtil;
import happysubin.javapractice.project.blackjack.src.utils.ScannerWrapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
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
    void selectiveReceiveCard(){

        //given
        Deck deck = new Deck();
        given(RandomUtil.getRandomNumber(Mockito.any(Integer.class))).willReturn(0);
        Dealer dealer = new Dealer();

        //when
        dealer.selectivelyReceiveCard(deck);

        //then
        Assertions.assertThat(dealer.getCardList().size()).isEqualTo(10);
    }
    /**
     * 일단 에이스 1 또는 10으로 생각하지 말고 진행
     */
}
