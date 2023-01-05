package happysubin.javapractice.project.lotto.src;

import happysubin.javapractice.project.lotto.src.model.Lotto;
import happysubin.javapractice.project.lotto.src.model.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LottoTest {

    @Test
    @DisplayName("1등상")
    void testFirstPrize(){

        //given
        Lotto lotto = new Lotto(createList());

        //when
        Prize compare = lotto.compare(List.of(1, 2, 3, 4, 5, 6), 9);

        //then
        Assertions.assertThat(compare).isEqualTo(Prize.FIRST);
    }

    @Test
    @DisplayName("2등상. 보너스를 인증 받는 경우")
    void testSecondPrize(){

        //given
        Lotto lotto = new Lotto(createList());

        //when
        Prize compare = lotto.compare(List.of(1, 2, 3, 4, 5, 7), 6);

        //then
        Assertions.assertThat(compare).isEqualTo(Prize.SECOND);
    }

    @Test
    @DisplayName("3등상")
    void testThirdPrize(){

        //given
        Lotto lotto = new Lotto(createList());

        //when
        Prize compare = lotto.compare(List.of(1, 2, 3, 4, 5, 7), 9);

        //then
        Assertions.assertThat(compare).isEqualTo(Prize.THIRD);
    }

    @Test
    @DisplayName("4등상")
    void testFourthPrize(){

        //given
        Lotto lotto = new Lotto(createList());

        //when
        Prize compare = lotto.compare(List.of(1, 2, 3, 8, 5, 7), 9);

        //then
        Assertions.assertThat(compare).isEqualTo(Prize.FOURTH);
    }

    @Test
    @DisplayName("5등상")
    void testFifthPrize(){

        //given
        Lotto lotto = new Lotto(createList());

        //when
        Prize compare = lotto.compare(List.of(1, 2, 4, 8, 5, 7), 9);

        //then
        Assertions.assertThat(compare).isEqualTo(Prize.FIFTH);
    }

    @Test
    @DisplayName("로또 꽝")
    void testFailCase(){

        //given
        Lotto lotto = new Lotto(createList());

        //when
        Prize compare = lotto.compare(List.of(9, 8, 7, 6, 5, 4), 3);
        //then
        Assertions.assertThat(compare).isEqualTo(Prize.FAIL);
    }

    private List<Integer> createList() {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            result.add(i);
        }
        return result;
    }
}