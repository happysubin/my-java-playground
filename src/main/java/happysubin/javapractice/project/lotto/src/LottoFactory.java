package happysubin.javapractice.project.lotto.src;

import happysubin.javapractice.project.lotto.src.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoFactory {

    private static final int LOTTO_PRICE = 1000;

    private LottoFactory(){}

    public static List<Lotto> createLotto(Money money){
        List<Lotto> result = new ArrayList<>();
        int totalMoney = money.getValue();
        int numOfLotto = totalMoney / LOTTO_PRICE;

        for (int i = 0; i < numOfLotto; i++) {
            result.add(new Lotto(RandomUtil.pickUniqueNumbersInRange(1, 46, 6)));
        }

        return result;
    }
}

