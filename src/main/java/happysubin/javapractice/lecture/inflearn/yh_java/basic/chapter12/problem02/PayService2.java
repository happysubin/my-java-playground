package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter12.problem02;

import java.util.List;
import java.util.Scanner;

public class PayService2 {

    public void processPay(String option, int amount) {

        Payment pay = PayFactory.createPay(option);

        boolean result = pay.pay(amount);

        if(result) {
            System.out.println("결제가 성공했습니다.");
            return;
        }
        System.out.println("결제가 실패했습니다.");
    }
}
