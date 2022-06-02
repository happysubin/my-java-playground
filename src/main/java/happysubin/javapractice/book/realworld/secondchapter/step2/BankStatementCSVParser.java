package happysubin.javapractice.book.realworld.secondchapter.step2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//파싱을한다는 단일 책임 원칙을 지킨다.

public class BankStatementCSVParser {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private BankTransaction parseFromCsv(final String line){
        final String[] columns = line.split(",");
        final LocalDate date = LocalDate.parse(columns[0],DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new BankTransaction(date, amount, description);

    }

    public List<BankTransaction> parseLinesFromCSV(final List<String> lines){
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for (String line : lines) {
            bankTransactions.add(parseFromCsv(line));
        }
        return bankTransactions;
    }
}

//반복해서 파싱한다. 즉 이것도 2가지 일이다.
//1. 반복한다.
//2. 파싱한다.