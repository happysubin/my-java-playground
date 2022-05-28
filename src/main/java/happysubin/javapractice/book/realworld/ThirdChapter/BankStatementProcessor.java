package happysubin.javapractice.book.realworld.ThirdChapter;

import happysubin.javapractice.book.realworld.SecondChapter.step3.BankTransaction;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

//응집도와 관련해서 클래스를 나눴다.
//응집도란 클래스나 메서드가 얼마나 서로 강하게 연결되어있는지를 측정한다.

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;


    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }
    /*

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

     */
    //--여기가 이번장에서 추가한 요구사항 부분 --//

    //특정 금액 이상의 거래 찾기
    public List<BankTransaction> findTransactionGreaterThanEqual(final int amount){
        final List<BankTransaction> result = new ArrayList<>();
        for (BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getAmount() >= amount){
                result.add(bankTransaction);
            }
        }
        return result;
    }

    //특정 월의 거래 찾기
    public List<BankTransaction> findTransactionsInMonth(Month month){
        final List<BankTransaction> result = new ArrayList<>();
        for (BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getLocalDate().getMonth() == month){
                result.add(bankTransaction);
            }
        }
        return result;
    }

    //특정 월이나 금액으로 입출금 내역 검사하기
    public List<BankTransaction> findTransactionsInMonthAndGreater(Month month, int amount){
        final List<BankTransaction> result = new ArrayList<>();
        for (BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getLocalDate().getMonth() == month & bankTransaction.getAmount() > amount){
                result.add(bankTransaction);
            }
        }
        return result;
    }

    /**이렇게 계속 요구 사항을 추가하는데 문제가 있다.
     * 거래 내역의 여러 속성을 조합할수록 코드가 복잡해진다..즉 더러워진다.
     * 반복 로직과 비즈니스 로직이 결합되어 분리하기가 어려워진다.
     * 코드를 반복한다.
     *
     * 이럴 때 개방폐쇄 원칙을 적용해야한다.
     * 우리는 이제 BankTransactionFilter라는 인터페이스를 만들어 문제를 해결할 것이다.
     * BankTransactionFilter는 test라는 불린 값을 리턴하는 함수형 인터페이스다!
     *
     */
}
