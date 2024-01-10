package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter03.challenge;

public class Account {
    private int balance;

    void deposit(int amount) {
        this.balance += amount;
    }

    void withdraw(int amount) {
        if(this.balance < amount) {
            System.out.println("잔액부족");
            return;
        }
        this.balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
