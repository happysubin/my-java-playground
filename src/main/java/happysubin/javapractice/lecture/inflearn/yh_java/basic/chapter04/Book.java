package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter04;

public class Book {
    private String title;
    private String author;
    private int page;

    public Book() {
        this("", "");
    }

    public Book(String title, String author) {
        this(title, author, 0);
    }

    public Book(String title, String author, int page) {
        this.title = title;
        this.author = author;
        this.page = page;
    }

    public void displayInfo() {
        System.out.println("저자: " + author + ", 제목: " + author + ", 페이지: " + page);
    }
}
