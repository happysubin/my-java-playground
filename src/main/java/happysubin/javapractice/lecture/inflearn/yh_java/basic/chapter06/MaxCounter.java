package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter06;

public class MaxCounter {


    private int count;
    private int max;

    public MaxCounter(int max) {
        this.count = 0;
        this.max = max;
    }

    public void increment() {
        if(count >= max) {
            System.out.println(max + " 최댓값보다 큰 숫자로 만들 수 없습니다. 현재 값: " + count);
            return;
        }
        count++;
    }

    public int getCount() {
        return count;
    }
}
