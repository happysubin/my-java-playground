package happysubin.javapractice.book.realworld.thirdchapter;

import happysubin.javapractice.book.realworld.secondchapter.step4.BankTransaction;

import java.time.Month;

public class BankTransactionIsInFebruaryAndExpensive implements BankTransactionFilter{
    @Override
    public boolean test(BankTransaction bankTransaction) {
        return bankTransaction.getLocalDate().getMonth() == Month.FEBRUARY
                && bankTransaction.getAmount() >= 1_000;
    }
}
