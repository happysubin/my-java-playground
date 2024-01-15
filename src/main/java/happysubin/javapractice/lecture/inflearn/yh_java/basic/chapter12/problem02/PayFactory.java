package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter12.problem02;

public abstract class PayFactory {

    private PayFactory() {}

    public static Payment createPay(String option) {
        if(option.equals("kakao")) {
            return new KakaoPay();
        }
        else if (option.equals("naver")) {
            return new NaverPay();
        }

        return new DefaultPay();
    }
}
