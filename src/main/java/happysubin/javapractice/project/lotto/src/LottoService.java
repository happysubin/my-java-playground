package happysubin.javapractice.project.lotto.src;

import happysubin.javapractice.project.lotto.src.factory.LottoFactory;

import java.util.List;

public class LottoService {

    public void start() {

        Money inputMoney = InputView.createMoney((Money money) -> {
            if (money.getValue() < 1000) throw new RuntimeException("로또를 구입할 금액이 부족합니다.");
            if (money.getValue() % 1000 != 0) throw new RuntimeException("거스름이 없도록 입력해주세요.");
        });

        List<Lotto> lotto = LottoFactory.createLotto(inputMoney);

        System.out.println(lotto.size() + "개를 구매했습니다.");
        for (Lotto l : lotto) {
            System.out.println(l.getNumbers());
        }

        WinningLotto winningLotto = InputView.createWinningLotto();

        List<Prize> prizes = winningLotto.compareLotto(lotto);

        //TODO 저 리스트를 가지고 출력해야함.

    }
}
