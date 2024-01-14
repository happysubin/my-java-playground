package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter08;

public class Album extends Item {

    private final String artist;

    public Album(String name, int price, String artist) {
        super(name, price);
        this.artist = artist;
    }


    @Override
    protected void printDetail() {
        System.out.println("- 아티스트: " + artist);
    }
}
