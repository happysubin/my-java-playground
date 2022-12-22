package happysubin.javapractice.project.lotto.src.validation;

import happysubin.javapractice.project.lotto.src.Money;

@FunctionalInterface
public interface MoneyValidationStrategy<T extends Money> {
   void validate(T money);
}
