package happysubin.javapractice.project.lotto.src;

import happysubin.javapractice.project.lotto.src.service.BonusService;
import happysubin.javapractice.project.lotto.src.service.BonusServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    @DisplayName("보너스를 인증 받는 경우")
    void test1(){

        //given
        BonusService bonusService = new BonusServiceImpl();
        List<Integer> list1 = createList1();
        List<Integer> list2 = createList2();
        int bonusNumber = 7;

        //when
        boolean b = bonusService.checkBonus(list1, list2, bonusNumber);

        //then
        Assertions.assertThat(b).isTrue();
    }
    
    private List<Integer> createList1(){
        List<Integer> result = new ArrayList<>();
        setList(result);
        result.add(7);
        return result;
    }

    private List<Integer> createList2(){
        List<Integer> result = new ArrayList<>();
        setList(result);
        result.add(8);
        return result;
    }

    private void setList(List<Integer> result) {
        for (int i = 1; i <= 6; i++) {
            result.add(i);
        }
    }

}