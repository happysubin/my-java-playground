package happysubin.javapractice.project.lotto.src;

import happysubin.javapractice.project.lotto.src.validation.MoneyValidationStrategy;

public class InputView {

    private InputView() {}

    public static Money createMoney(MoneyValidationStrategy moneyValidationStrategy){
        String input = ScannerWrapper.input();
        validateNumberFormat(input);
        Money result = new Money(Integer.valueOf(input));
        moneyValidationStrategy.validate(result);
        return result;
    }


    private static void validateNumberFormat(String input) {
        if(!input.chars().allMatch(Character::isDigit)) throw new RuntimeException("숫자 형식으로 입력해주세요.");
        //아래는 다른 버전
        //input.matches("\\d+");
        // 정규식 "\\d+"는 하나 이상의 숫자로 구성된 문자열과 일치합니다.
    }
}
