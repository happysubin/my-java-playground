package happysubin.javapractice.project.bridge.src.view;

import happysubin.javapractice.project.bridge.src.utils.ScannerWrapper;

public class InputView {

    public static void printStartGameMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public static int readBridgeSize() {
        printStartGameMessage();
        System.out.println("다리의 길이를 입력해주세요.");
        String input = ScannerWrapper.input();
        validateNumberFormat(input);
        return Integer.parseInt(input);
    }

    public static String readMoving() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = ScannerWrapper.input();
        validateMoveInputFormat(input);
        return input;
    }

    public static String readGameCommand(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = ScannerWrapper.input();
        validateRetryInputFormat(input);
        return input;
    }

    private static void validateNumberFormat(String input){
        if(!input.matches("\\d+")) throw new RuntimeException("[ERROR] 숫자 형식으로 입력해주세요.");
    }

    private static void validateMoveInputFormat(String input){
        if(!input.equals("D") && !input.equals("U")) throw new RuntimeException("[ERROR] U 또는 D를 입력해주세요.");
    }

    private static void validateRetryInputFormat(String input){
        if(!input.equals("R") && !input.equals("Q")) throw new RuntimeException("[ERROR] R 또는 Q를 입력해주세요.");
    }
}