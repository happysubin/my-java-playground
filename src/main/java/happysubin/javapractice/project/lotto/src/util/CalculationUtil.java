package happysubin.javapractice.project.lotto.src.util;

import happysubin.javapractice.project.lotto.src.model.Money;
import happysubin.javapractice.project.lotto.src.model.Prize;

import java.util.List;

public class CalculationUtil {

    public static double calculateRateOfReturn(List<Prize> prizes, Money inputMoney){
        double sum = prizes.stream().map(Prize::getPrizeMoney).reduce(0, (a, b) -> (a + b)) * 100.0;
        return Math.round( sum / inputMoney.getValue());
    }
}
