package happysubin.javapractice.book.realworld.thirdchapter;

import happysubin.javapractice.book.realworld.secondchapter.step4.BankTransaction;

@FunctionalInterface
public interface BankTransactionSummarizer {
    double summarize(double accumulator, BankTransaction bankTransaction);
}
