package happysubin.javapractice.book.realworld.SecondChapter.step1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

//kiss원칙을 지키며 개발한다. Kiss원칙이란 keep it short and simple이다. 그냥 간단하게!!!!!
//은행 입출금 내역의 총 수입과 총 지출은 각각 얼마인가
//특정 달엔 몇 건의 입출금 내역이 발생했는가?
//위 2건에 대해서 구현
public class BankExampleV1 {

    private static final String RESOURCES = "/Users/ansubin/Desktop/source/bank.csv";
    public static void main(String[] args) throws IOException {
        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path);
        double total = 0d;
        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for (String line : lines) {
            final String[] columns = line.split(",");
            final LocalDate date = LocalDate.parse(columns[0],DATE_PATTERN);
            if(date.getMonth() == Month.JANUARY){
                final double amount = Double.parseDouble(columns[1]);
                total += amount;
            }
        }


        System.out.println("total = " + total);
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
