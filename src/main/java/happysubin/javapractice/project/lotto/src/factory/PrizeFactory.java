package happysubin.javapractice.project.lotto.src.factory;

import happysubin.javapractice.project.lotto.src.Prize;
import happysubin.javapractice.project.lotto.src.constant.LottoConst;

import java.util.List;

public class PrizeFactory {
    public static Prize createPrize(int count, Boolean bonus) {
        return Prize.getValue(count);
    }
}
