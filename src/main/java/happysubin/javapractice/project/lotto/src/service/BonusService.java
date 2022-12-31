package happysubin.javapractice.project.lotto.src.service;

import java.util.List;

public interface BonusService {
    boolean checkBonus(List<Integer> numbers, List<Integer> numbers1, int bonusNumber);
}
