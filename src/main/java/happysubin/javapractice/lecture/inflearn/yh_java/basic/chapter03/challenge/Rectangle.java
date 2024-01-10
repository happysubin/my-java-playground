package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter03.challenge;

public class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    int calculateArea() {
        return this.width * this.height;
    }
    int calculatePerimeter() {
        return 2 * (this.width + this.height);
    }
    boolean isSquare() {
        return this.width == this.height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
