//package happysubin.javapractice.book.realworld.secondchapter.step4;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//import java.time.Month;
//
//class BankStatementCSVParserTest {
//
//    private BankStatementParser bankStatementParser;
//
//
//    @BeforeEach
//    void beforeEach(){
//      bankStatementParser = new BankStatementCSVParser();
//    }
//
//    @Test
//    void shouldParseOneCorrectLine(){
//        //given
//        String line = "30-01-2017,-50,Tesco";
//        BankTransaction expected =
//                new BankTransaction(LocalDate.of(2017, Month.JANUARY,30),-50,"Tesco");
//        double tolerance = 0.0d;
//
//        //when
//        BankTransaction result = bankStatementParser.parseFrom(line);
//
//        //then
//        Assertions.assertEquals(expected.getAmount(),result.getAmount());
//        Assertions.assertEquals(expected.getLocalDate(),result.getLocalDate());
//        Assertions.assertEquals(expected.getDescription(),result.getDescription());
//    }
//
//}