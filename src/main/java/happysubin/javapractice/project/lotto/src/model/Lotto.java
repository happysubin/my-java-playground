package happysubin.javapractice.project.lotto.src.model;

import happysubin.javapractice.project.lotto.src.constant.LottoConst;
import happysubin.javapractice.project.lotto.src.factory.PrizeFactory;


import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConst.LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public Prize compare(List<Integer> winningNumbers, int bonusNumber) {
        int count = calculateSameNumbers(winningNumbers);
        boolean bonus = checkBonus(winningNumbers, count, bonusNumber);
        return PrizeFactory.createPrize(count, bonus);
    }

    private int calculateSameNumbers(List<Integer> numbers) {
        int count = 0;
        for (int i = 0; i < LottoConst.LOTTO_SIZE; i++) {
            if(numbers.get(i) == this.numbers.get(i)) count++;
        }
        return count;
    }


    private boolean checkBonus(List<Integer> winningNumbers, int count, int bonusNumber) {

        if(isNotFiveCount(count)){
            return false;
        }

        removeListExceptBonusNumber(winningNumbers);

        if(isNotSameBonusNumber(bonusNumber)){
            return false;
        }

        return true;
    }

    private boolean isNotFiveCount(int count) {
        return count != 5;
    }

    private boolean isNotSameBonusNumber(int bonusNumber) {
        return numbers.get(0) != bonusNumber;
    }

    private void removeListExceptBonusNumber(List<Integer> winningNumbers) {
        numbers.removeAll(winningNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
