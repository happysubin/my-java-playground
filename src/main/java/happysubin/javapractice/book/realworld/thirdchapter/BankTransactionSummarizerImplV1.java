package happysubin.javapractice.book.realworld.thirdchapter;

import happysubin.javapractice.book.realworld.secondchapter.step4.BankTransaction;


public class  BankTransactionSummarizerImplV1 implements BankTransactionSummarizer {
    @Override
    public double summarize(double accumulator, BankTransaction bankTransaction) {
        return accumulator += bankTransaction.getAmount();
    }
}
