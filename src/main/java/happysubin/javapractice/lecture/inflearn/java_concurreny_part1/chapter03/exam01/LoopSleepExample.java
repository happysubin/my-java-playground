package happysubin.javapractice.lecture.inflearn.java_concurreny_part1.chapter03.exam01;

public class LoopSleepExample {

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            try{
                System.out.println("반복: " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
