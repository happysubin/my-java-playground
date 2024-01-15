package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter12.problem02;

public class PayMain0 {

    public static void main(String[] args) {
        PayService payService = new PayService();
        //kakao 결제
        String payOption1 = "kakao";
        int amount1 = 5000;
        payService.processPay(payOption1, amount1);
        //naver 결제
        String payOption2 = "naver";
        int amount2 = 10000;
        payService.processPay(payOption2, amount2);

        //잘못된 결제 수단 선택
        String payOption3 = "bad";
        int amount3 = 15000;
        payService.processPay(payOption3, amount3);
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
