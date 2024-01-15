package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter12.problem01;

public class SmsSender implements Sender {
    @Override
    public void sendMessage(String message) {
        System.out.println("SMS를 발송합니다: " + message);
    }
}
