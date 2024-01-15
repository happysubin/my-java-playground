package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter12.problem01;

public class EmailSender implements Sender {
    @Override
    public void sendMessage(String message) {
        System.out.println("메일을 발송합니다: " + message);
    }
}
