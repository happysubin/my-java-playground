package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter03.exam01;

public class BasicSleepExample {
    public static void main(String[] args) {
        try {
            System.out.println("2초 후에 메세지가 출력");
            Thread.sleep(2000);
            System.out.println("메시지");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
