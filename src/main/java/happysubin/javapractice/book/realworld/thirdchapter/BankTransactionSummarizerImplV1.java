package happysubin.javapractice.book.realworld.ThirdChapter;

import happysubin.javapractice.book.realworld.SecondChapter.step4.BankTransaction;


public class  BankTransactionSummarizerImplV1 implements BankTransactionSummarizer {
    @Override
    public double summarize(double accumulator, BankTransaction bankTransaction) {
        return accumulator += bankTransaction.getAmount();
    }
}
