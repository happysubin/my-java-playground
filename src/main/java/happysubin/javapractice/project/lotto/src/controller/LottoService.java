package happysubin.javapractice.project.lotto.src.controller;

import happysubin.javapractice.project.lotto.src.model.Prize;
import happysubin.javapractice.project.lotto.src.model.WinningLotto;
import happysubin.javapractice.project.lotto.src.model.Lotto;
import happysubin.javapractice.project.lotto.src.model.Money;
import happysubin.javapractice.project.lotto.src.factory.LottoFactory;
import happysubin.javapractice.project.lotto.src.util.CalculationUtil;
import happysubin.javapractice.project.lotto.src.validation.MoneyValidationStrategyImpl;
import happysubin.javapractice.project.lotto.src.view.InputView;
import happysubin.javapractice.project.lotto.src.view.OutputView;

import java.util.List;

public class LottoService {

    public void start() {

        Money inputMoney = InputView.createMoney(new MoneyValidationStrategyImpl());
        List<Lotto> lotto = LottoFactory.createLotto(inputMoney);
        OutputView.printLottoList(lotto);
        WinningLotto winningLotto = InputView.createWinningLotto();
        List<Prize> prizes = winningLotto.compareLotto(lotto);
        OutputView.printPrizes(prizes);
        OutputView.printRateOfReturn(CalculationUtil.calculateRateOfReturn(prizes, inputMoney));
    }
}
