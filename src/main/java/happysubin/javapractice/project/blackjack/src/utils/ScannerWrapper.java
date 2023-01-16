package happysubin.javapractice.project.blackjack.src.utils;

import java.util.Scanner;

public class ScannerWrapper {

    private static class ScannerSingleton{
        private static final Scanner scanner = new Scanner(System.in);
    }

    private static Scanner getInstance() {
        return ScannerSingleton.scanner;
    }

    public static String getInput(){
        return getInstance().next();
    }
}
