package happysubin.javapractice.project.blackjack.src.view;

import happysubin.javapractice.project.blackjack.src.utils.ScannerWrapper;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    private final static String INPUT_NAME_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private final static String NAME_VALIDATION_FAIL_MESSAGE = "입력할 이름 형식과 틀립니다.";

    private static final String SPLIT_STANDARD = ",";

    public static List<String> inputPlayerName (){
        System.out.println(INPUT_NAME_MESSAGE);
        String names= ScannerWrapper.getInput();
        validateNameFormat(names);
        return Arrays.asList(names.split(SPLIT_STANDARD));
    }

    private static void validateNameFormat(String names) {
        Pattern pattern = Pattern.compile("[a-zA-z]*?(,[a-zA-z]*)*");
        Matcher matcher = pattern.matcher(names);
        if(!matcher.matches()){
            throw new IllegalStateException(NAME_VALIDATION_FAIL_MESSAGE);
        }
    }
}
