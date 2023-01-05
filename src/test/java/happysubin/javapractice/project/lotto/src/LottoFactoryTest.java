package happysubin.javapractice.project.lotto.src;

import happysubin.javapractice.project.lotto.src.constant.LottoConst;
import happysubin.javapractice.project.lotto.src.model.Lotto;
import happysubin.javapractice.project.lotto.src.model.Money;
import happysubin.javapractice.project.lotto.src.factory.LottoFactory;
import happysubin.javapractice.project.lotto.src.util.RandomUtil;
import org.assertj.core.api.AbstractThrowableAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.MockedStatic;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class LottoFactoryTest {

    MockedStatic<RandomUtil> scanner;

    @BeforeEach
    void beforeEach(){
        scanner = mockStatic(RandomUtil.class); //매번 모킹해야 한다.
    }

    @AfterEach
    void afterEach(){
        scanner.close(); //매번 닫아줘야 한다.
    }

    @Test
    void createLottoList(){

        //given
        BDDMockito.given(RandomUtil.pickUniqueNumbersInRange(any(Integer.class), any(Integer.class), any(Integer.class)))
                .willReturn(Arrays.asList(1, 2, 3, 4, 5, 6));
        Money money = new Money(6000);

        //when
        List<Lotto> lotto = LottoFactory.createLotto(money);

        //then
        Assertions.assertThat(lotto.size()).isEqualTo(LottoConst.LOTTO_SIZE);
    }

    @Test
    void createFailLottoList(){

        //given
        BDDMockito.given(RandomUtil.pickUniqueNumbersInRange(any(Integer.class), any(Integer.class), any(Integer.class)))
                .willReturn(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        Money money = new Money(8000);

        //when
        AbstractThrowableAssert<?, ? extends Throwable> result = Assertions.assertThatThrownBy(() -> {
            List<Lotto> lotto = LottoFactory.createLotto(money);
        });

        //then
        result.isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("생성한 Integer List와 Lotto Integer List 비교 성공")
    void compareList(){

        //given
        BDDMockito.given(RandomUtil.pickUniqueNumbersInRange(any(Integer.class), any(Integer.class), any(Integer.class)))
                .willReturn(Arrays.asList(1, 2, 3, 4, 5, 6));
        Money money = new Money(1000);

        //when
        List<Lotto> lotto = LottoFactory.createLotto(money);

        Assertions.assertThat(lotto.size()).isEqualTo(1);
        Assertions.assertThat(lotto.get(0).getNumbers()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));

    }
}