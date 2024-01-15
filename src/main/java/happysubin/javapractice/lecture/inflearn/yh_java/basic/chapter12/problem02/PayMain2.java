package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter12.problem02;

import java.util.Scanner;

public class PayMain2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PayService payService = new PayService();

        while (true) {
            System.out.print("결제 수단을 입력하세요:");
            String payOption = scanner.nextLine();
            if (payOption.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                return;
            }
            System.out.print("결제 금액을 입력하세요:");
            int amount = scanner.nextInt();
            scanner.nextLine();
            payService.processPay(payOption, amount);
        }

    }
    /**
     * 결제를 시작합니다: option=kakao, amount=5000 카카오페이 시스템과 연결합니다.
     * 5000원 결제를 시도합니다.
     * 결제가 성공했습니다.
     * 결제를 시작합니다: option=naver, amount=10000 네이버페이 시스템과 연결합니다.
     * 10000원 결제를 시도합니다.
     * 결제가 성공했습니다.
     * 결제를 시작합니다: option=bad, amount=15000 결제 수단이 없습니다.
     * 결제가 실패했습니다.
     */
}
