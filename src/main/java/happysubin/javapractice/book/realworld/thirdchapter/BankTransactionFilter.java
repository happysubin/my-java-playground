package happysubin.javapractice.book.realworld.thirdchapter;

import happysubin.javapractice.book.realworld.secondchapter.step4.BankTransaction;

@FunctionalInterface
public interface BankTransactionFilter {
    boolean test (BankTransaction bankTransaction);
}
