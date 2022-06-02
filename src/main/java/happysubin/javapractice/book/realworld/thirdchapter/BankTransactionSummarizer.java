package happysubin.javapractice.book.realworld.ThirdChapter;

import happysubin.javapractice.book.realworld.SecondChapter.step4.BankTransaction;

@FunctionalInterface
public interface BankTransactionSummarizer {
    double summarize(double accumulator, BankTransaction bankTransaction);
}
