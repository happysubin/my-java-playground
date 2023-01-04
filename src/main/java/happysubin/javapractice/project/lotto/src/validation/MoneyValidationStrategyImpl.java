package happysubin.javapractice.project.lotto.src.validation;

import happysubin.javapractice.project.lotto.src.model.Money;

public class MoneyValidationStrategyImpl implements MoneyValidationStrategy{
   @Override
   public void validate(Money money) {
      if (money.getValue() < 1000) throw new RuntimeException("로또를 구입할 금액이 부족합니다.");
      if (money.getValue() % 1000 != 0) throw new RuntimeException("거스름이 없도록 입력해주세요.");
   }
}
