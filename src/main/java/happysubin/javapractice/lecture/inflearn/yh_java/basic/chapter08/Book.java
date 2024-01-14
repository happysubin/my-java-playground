package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter08;

public class Book extends Item {

    private final String author;
    private final String isbn;

    public Book(String name, int price, String author, String isbn) {
        super(name, price);
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    protected void printDetail() {
        System.out.println("- 저자: " + author + ", isbn: " + isbn);
    }
}
