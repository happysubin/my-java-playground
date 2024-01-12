package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter04;

public class App {

    public static void main(String[] args) {

        Book book = new Book();
        book.displayInfo();

        Book book2 = new Book("Hello Java", "Seo");
        book2.displayInfo();

        Book book3 = new Book("JPA 프로그래밍", "kim", 700);
        book3.displayInfo();

    }
}
