package happysubin.javapractice.book.realworld.SecondChapter.step3;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static happysubin.javapractice.book.realworld.SecondChapter.step2.BankExampleV2.calculateTotalAmount;

//기존 V2클래스는 다양한 응용프로그램을 연결하는 지점이였다.
//그러나 이전에 클래스에서 계산 관련작업이나 파싱이나 결과 전송과는 직접적인 관련이 없다.
//그래서 별도의 클래스를 추출했다.

public class BankExampleV3 {

    private static final String RESOURCES = "/Users/ansubin/Desktop/source/bank.csv";
    private static final BankStatementCSVParser parser = new BankStatementCSVParser();


    public static void main(String[] args) throws IOException {
        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path); //입력

        List<BankTransaction> bankTransactions = parser.parseLinesFromCSV(lines);
        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println("bankStatementProcessor.calculateTotalAmount() = "
                + bankStatementProcessor.calculateTotalAmount());
        System.out.println("bankStatementProcessor.calculateTotalInMonth() = "
                + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("bankStatementProcessor.calculateTotalForCategory() = "
                + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }


}

/**
 * 요구사항
 * 은행 입출금 내역의 총 수입과 총 지출은 각각 얼마인가? 결과가 양수인가 음수인가
 * 특정 달엔 몇 건의 입출금 내역이 발생했는가?
 *
 *
 *
 * 지출이 가장 높은 상위 10건은 무엇인가?
 * 돈을 가장 많이 소비하는 항목은 무엇인가?
 */
