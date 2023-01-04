package happysubin.javapractice.project.lotto.src.view;

import happysubin.javapractice.project.lotto.src.model.Money;
import happysubin.javapractice.project.lotto.src.util.ScannerWrapper;
import happysubin.javapractice.project.lotto.src.model.WinningLotto;
import happysubin.javapractice.project.lotto.src.constant.LottoConst;
import happysubin.javapractice.project.lotto.src.validation.MoneyValidationStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private InputView() {}

    public static Money createMoney(MoneyValidationStrategy moneyValidationStrategy){
        
        System.out.println("구입금액을 입력해주세요.");
        String input = ScannerWrapper.input();
        validateNumberFormat(input);
        Money result = new Money(Integer.valueOf(input));
        moneyValidationStrategy.validate(result);
        return result;
    }

    public static WinningLotto createWinningLotto() {
        List<Integer> winningNumber = createWinningNumber();
        int bonusNumber = createBonusNumber();
        return new WinningLotto(winningNumber, bonusNumber);
    }

    private static List<Integer> createWinningNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = ScannerWrapper.input();
        validateLottoWinningNumberFormat(input);
        List<Integer> list = split(input);
        validateLottoWinning(list);
        return list;
    }

    private static void validateLottoWinningNumberFormat(String input) {
        Pattern pattern = Pattern.compile("[0-9]+(,[0-9]+)+");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("로또 번호 입력 형식과 다릅니다. 예시 (1,2,3,4,5,6) ");
        }
    }

    private static List<Integer> split(String input) {
        try{
            return Arrays.stream(input.split(","))
                    .map(s -> Integer.valueOf(s))
                    .collect(Collectors.toList());
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    private static void validateLottoWinning(List<Integer> list) {
        if(list.size() != LottoConst.LOTTO_SIZE){
            throw new RuntimeException("로또 사이즈가 기존 규격과 다릅니다");
        }
    }

    private static int createBonusNumber(){
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = ScannerWrapper.input();
        validateNumberFormat(input);
        return Integer.valueOf(input);
    }

    private static void validateNumberFormat(String input) {

        if(!input.chars().allMatch(Character::isDigit)) throw new RuntimeException("숫자 형식으로 입력해주세요.");
        //아래는 다른 버전
        //input.matches("\\d+");
        // 정규식 "\\d+"는 하나 이상의 숫자로 구성된 문자열과 일치합니다.
    }
}
