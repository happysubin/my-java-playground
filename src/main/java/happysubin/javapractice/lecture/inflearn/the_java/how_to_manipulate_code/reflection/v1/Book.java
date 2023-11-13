package happysubin.javapractice.lecture.inflearn.the_java.how_to_manipulate_code.reflection.v1;

@MyAnnotation(value = "hello")
public class Book {

    private static String B = "BOOK";
    private static final String C = "BOOK";

    private String a;

    public String d = "d";

    protected String e = "e";

    public Book() {
    }

    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    private void f(){
        System.out.println("F");
    }

    public void g(){
        System.out.println("G");
    }

    public int h(){
        return 100;
    }



}
