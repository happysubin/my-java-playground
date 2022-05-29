package happysubin.javapractice.book.realworld.ThirdChapter;

import happysubin.javapractice.book.realworld.SecondChapter.step4.BankTransaction;

import java.util.List;

@FunctionalInterface
public interface BankTransactionFilter {
    boolean test (BankTransaction bankTransaction);
}
