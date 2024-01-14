package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter08;


public class Movie extends Item {

    private final String director;
    private final String actor;

    public Movie(String name, int price, String director, String actor) {
        super(name, price);
        this.director = director;
        this.actor = actor;
    }

    @Override
    protected void printDetail() {
        System.out.println("- 감독: " + director + ", 배우: " + actor);
    }
}
