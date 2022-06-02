package happysubin.javapractice.book.realworld.secondchapter.step4;





import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;



public class BankStatementAnalyzer {

    private static final String RESOURCES = "/Users/ansubin/Desktop/source/bank.csv";

    public void analyze(String resources, final BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(resources);
        final List<String> lines = Files.readAllLines(path);

        List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

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
