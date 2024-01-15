package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter12.problem02;

import java.util.List;

public class PayService {

    private List<Payment> payments = List.of(new KakaoPay(), new NaverPay(), new DefaultPay());

    public void processPay(String option, int amount) {

        System.out.println("결제를 시작합니다: option=" + option + ", amount=" + amount);

        Payment pay = PayFactory.createPay(option);

        boolean result = pay.pay(amount);

        if(result) {
            System.out.println("결제가 성공했습니다.");
            return;
        }
        System.out.println("결제가 실패했습니다.");
    }
}
