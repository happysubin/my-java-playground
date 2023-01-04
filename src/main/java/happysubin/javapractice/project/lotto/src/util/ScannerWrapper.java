package happysubin.javapractice.project.lotto.src.util;

import java.util.Scanner;

public class ScannerWrapper {

    private ScannerWrapper(){};

    private static class getInnerScanner {
        // 클래스 로딩 시점에서 생성
        private static final Scanner scanner = new Scanner(System.in);
    }

    private static Scanner getInstance() {
        return getInnerScanner.scanner;
    }

    public static String input(){
        Scanner scanner = getInstance();
        return scanner.next();
    }

}
