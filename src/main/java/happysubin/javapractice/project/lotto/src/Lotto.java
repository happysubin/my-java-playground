package happysubin.javapractice.project.lotto.src;

import happysubin.javapractice.project.lotto.src.constant.LottoConst;
import happysubin.javapractice.project.lotto.src.factory.PrizeFactory;
import happysubin.javapractice.project.lotto.src.service.BonusService;

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

    public Prize compare(List<Integer> numbers, int bonusNumber, BonusService bonusService) {
        int count = calculateSameNumbers(numbers);
        boolean bonus = bonusService.checkBonus(this.numbers, numbers, bonusNumber);
        return PrizeFactory.createPrize(count, bonus);
    }

    private int calculateSameNumbers(List<Integer> numbers) {
        int count = 0;
        for (int i = 0; i < LottoConst.LOTTO_SIZE; i++) {
            if(numbers.get(i) == this.numbers.get(i)) count++;
        }
        return count;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
