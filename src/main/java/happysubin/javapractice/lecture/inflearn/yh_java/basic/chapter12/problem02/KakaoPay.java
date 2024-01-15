package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter12.problem02;

public class KakaoPay implements Payment {

    public boolean pay(int amount) {
        System.out.println("카카오페이 시스템과 연결합니다.");
        System.out.println(amount + "원 결제를 시도합니다.");
        return true;
    }
}
