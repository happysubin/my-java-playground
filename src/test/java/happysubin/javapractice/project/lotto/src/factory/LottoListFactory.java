package happysubin.javapractice.project.lotto.src.factory;

import happysubin.javapractice.project.lotto.src.model.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoListFactory {

    public static List<Lotto> createLottoList(){
        List<Integer> list1 = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            list1.add(i);
        }
        Lotto lotto = new Lotto(list1);

        List<Integer> list2 = new ArrayList<>();

        for (int i = 7; i <= 12; i++) {
            list2.add(i);
        }
        Lotto lotto2 = new Lotto(list2);

        List<Integer> list3 = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            list3.add(i);
        }
        list3.add(7);
        Lotto lotto3 = new Lotto(list3);

        return Arrays.asList(lotto, lotto2, lotto3);
    }
}
