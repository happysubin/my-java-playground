package happysubin.javapractice.book.realworld.secondchapter.step2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

//SRP 단일 책임 원칙을 지킨다.
//한 클래스는 한 가지 기능만 책임진다.
//클래스가 바뀌어야하는 이유는 오직 하나다.

/**
 * 1. 입력 읽기
 * 2. 주어진 형식의 입력 파싱
 * 3. 결과 처리
 * 4. 결과요약 리포트
 */

public class BankExampleV2 {

    private static final String RESOURCES = "/Users/ansubin/Desktop/source/bank.csv";
    public static void main(String[] args) throws IOException {
        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path); //입력


        BankStatementCSVParser csvParser = new BankStatementCSVParser();
        List<BankTransaction> bankTransactions = csvParser.parseLinesFromCSV(lines);//파싱

        System.out.println("The total for all transactions is = " + calculateTotalAmount(bankTransactions));
        System.out.println("selectMonth(bankTransactions,Month.JANUARY) = " + selectMonth(bankTransactions,Month.JANUARY));
    }


    public static double calculateTotalAmount(List<BankTransaction> bankTransactions){

        double total = 0d;
        for (BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public static List<BankTransaction> selectMonth(final List<BankTransaction> bankTransactions, final Month month){
        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
        for (BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getLocalDate().getMonth()==month){
                bankTransactionsInMonth.add(bankTransaction);
            }
        }
        return bankTransactionsInMonth;
    }

}

/**
 * 요구사항
 * 은행 입출금 내역의 총 수입과 총 지출은 각각 얼마인가? 결과가 양수인가 음수인가
 * 특정 달엔 몇 건의 입출금 내역이 발생했는가?
 * 지출이 가장 높은 상위 10건은 무엇인가?
 * 돈을 가장 많이 소비하는 항목은 무엇인가?
 *
 *
 */
