package happysubin.javapractice.project.lotto.src;

import happysubin.javapractice.project.lotto.src.service.BonusServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private List<Integer> numbers;
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Prize> compareLotto(List<Lotto> lottoList) {
        return lottoList
                .stream()
                .map(lotto -> lotto.compare(numbers, bonusNumber, new BonusServiceImpl()))
                .collect(Collectors.toList());
    }
}
