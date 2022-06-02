package happysubin.javapractice.book.realworld.SecondChapter.step4;

import happysubin.javapractice.book.realworld.ThirdChapter.Notification;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;


public class BankTransaction {

    private final LocalDate localDate;
    private final double amount;
    private final String description;

    public BankTransaction(LocalDate localDate, double amount, String description) {
        this.localDate = localDate;
        this.amount = amount;
        this.description = description;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankTransaction that = (BankTransaction) o;
        return Double.compare(that.getAmount(), getAmount()) == 0 && Objects.equals(getLocalDate(), that.getLocalDate()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocalDate(), getAmount(), getDescription());
    }

    @Override
    public String toString() {
        return "BankTransaction{" +
                "localDate=" + localDate +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }


    //노티피케이션 패턴을 적용.
    //노티피케이션 패턴은 너무 많은 미확인 예외를 사용하는 상황에 적합한 해결책을 제공한다.
    //이 패턴에서는 도메인 클래스로 오류를 수집한다.

    public Notification validate(){
        final Notification notification = new Notification();
        if(this.description.length() > 100){
            notification.addError("The description is too long");
        }

        final LocalDate parsedDate;
        try{
            parsedDate = LocalDate.parse(this.localDate.format());
            if(parsedDate.isAfter(LocalDate.now())){
                notification.addError("date cannot be int the future");
            }
        }
        catch(DateTimeParseException e){
            notification.addError("Invalid format for date");
        }

    }
}
