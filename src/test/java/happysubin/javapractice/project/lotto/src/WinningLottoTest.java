package happysubin.javapractice.project.lotto.src;

import happysubin.javapractice.project.lotto.src.factory.LottoListFactory;
import happysubin.javapractice.project.lotto.src.model.Lotto;
import happysubin.javapractice.project.lotto.src.model.Prize;
import happysubin.javapractice.project.lotto.src.model.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningLottoTest {

    @Test
    @DisplayName("당첨 로또 테스트. 1등상, 꽝, 2등 상")
    void testCase1(){

        //given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottoList = LottoListFactory.createLottoList();

        //when
        List<Prize> prizes = winningLotto.compareLotto(lottoList);

        //then
        Assertions.assertThat(prizes).containsExactly(Prize.FIRST, Prize.FAIL, Prize.SECOND);
    }
}
