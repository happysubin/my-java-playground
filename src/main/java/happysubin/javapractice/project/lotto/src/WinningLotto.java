package happysubin.javapractice.project.lotto.src;

import java.util.List;

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

    public void compareLotto(List<Lotto> lotto) {
        //TODO 비교
    }
}
