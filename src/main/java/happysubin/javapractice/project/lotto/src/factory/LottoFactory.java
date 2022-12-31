package happysubin.javapractice.project.lotto.src.factory;

import happysubin.javapractice.project.lotto.src.Lotto;
import happysubin.javapractice.project.lotto.src.Money;
import happysubin.javapractice.project.lotto.src.constant.LottoConst;
import happysubin.javapractice.project.lotto.src.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static happysubin.javapractice.project.lotto.src.constant.LottoConst.*;

public class LottoFactory {

    private LottoFactory(){}

    public static List<Lotto> createLotto(Money money){

        List<Lotto> result = new ArrayList<>();
        int numOfLotto = getNumOfLotto(money);
        makeLotto(result, numOfLotto);
        return result;
    }

    private static void makeLotto(List<Lotto> result, int numOfLotto) {
        for (int i = 0; i < numOfLotto; i++) {
            result.add(new Lotto(RandomUtil.pickUniqueNumbersInRange(START_INDEX, FINAL_INDEX, LOTTO_SIZE)));
        }
    }

    private static int getNumOfLotto(Money money) {
        int totalMoney = money.getValue();
        int numOfLotto = totalMoney / LOTTO_PRICE;
        return numOfLotto;
    }
}

