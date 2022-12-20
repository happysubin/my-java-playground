package happysubin.javapractice.project.lotto.src.strategy;

import happysubin.javapractice.project.lotto.src.Money;

@FunctionalInterface
public interface MoneyValidationStrategy<T extends Money> {
   void validate(T money);
}
