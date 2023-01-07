package happysubin.javapractice.project.bridge.src.utils;

import java.util.Scanner;

public class ScannerWrapper {

    private ScannerWrapper(){}

    private static class ScannerSingleton{
        private static final Scanner scanner = new Scanner(System.in);
    }

    private static Scanner getInstance() {
        return ScannerSingleton.scanner;
    }

    public static String input(){
        return getInstance().next();
    }
}
