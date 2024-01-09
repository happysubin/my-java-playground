package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter01;

public class MovieReview {

    private final String title;
    private final String review;

    public MovieReview(String title, String review) {
        this.title = title;
        this.review = review;
    }

    public String getTitle() {
        return title;
    }

    public String getReview() {
        return review;
    }


    public static void main(String[] args) {
        MovieReview inceptionReview = new MovieReview("인셉션", "인생은 무한 루프");
        MovieReview aboutTimeReview = new MovieReview("어바웃타임", "인생 시간 영화!");

        MovieReview[] reviews = {inceptionReview, aboutTimeReview};


        for (MovieReview review : reviews) {
            System.out.println("영화 제목: " + review.getTitle() + ", 리뷰: " + review.getReview());
        }

    }
}
