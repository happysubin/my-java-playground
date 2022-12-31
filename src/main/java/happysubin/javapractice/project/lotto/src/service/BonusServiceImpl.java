package happysubin.javapractice.project.lotto.src.service;

import java.util.List;

public class BonusServiceImpl implements BonusService {

    @Override
    public boolean checkBonus(List<Integer> list1, List<Integer> list2, int bonusNumber) {

        ///리스트를 비교
        compareTwoList(list1, list2);

        if (notSameSixNumebers(list1, list2)) {
            return false;
        }

        if (isNotSameBonusNumber(list1, bonusNumber)) {
            return false;
        }
        return true;
    }

    private boolean isNotSameBonusNumber(List<Integer> list1, int bonusNumber) {
        return list1.get(0) != bonusNumber;
    }


    private boolean notSameSixNumebers(List<Integer> list1, List<Integer> list2) {
        return list1.size() == 1 && list2.size() == 1;
    }

    private void compareTwoList(List<Integer> numbers1, List<Integer> numbers2) {
        numbers1.removeAll(numbers2);
    }
}
