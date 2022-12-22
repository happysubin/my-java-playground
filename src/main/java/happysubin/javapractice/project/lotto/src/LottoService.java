package happysubin.javapractice.project.lotto.src;

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

        //TODO 로또와 뽑은 번호들을 비교. 결과 객체를 리턴해서 결과 객체가 다 보여주자.
        winningLotto.compareLotto(lotto);

        //

    }
}
