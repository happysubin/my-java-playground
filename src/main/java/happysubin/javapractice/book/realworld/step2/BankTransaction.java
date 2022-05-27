package happysubin.javapractice.book.realworld.step2;

import java.time.LocalDate;
import java.util.Objects;

//입출금 내역 도메인 클래스
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
}
