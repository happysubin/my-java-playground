package happysubin.javapractice.book.realworld.secondchapter.step3;

import java.time.Month;
import java.util.List;

//응집도와 관련해서 클래스를 나눴다.
//응집도란 클래스나 메서드가 얼마나 서로 강하게 연결되어있는지를 측정한다.

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount(){
        double total = 0d;
        for (BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public double calculateTotalInMonth(Month month){
        double total = 0d;
        for (BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getLocalDate().getMonth() == month){
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalForCategory(String category){
        double total =0d;
        for (BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getDescription().equals(category)){
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }
}
