package happysubin.javapractice.project.blackjack.src.view;

import java.util.List;

public class OutputView {

    private static final String NOTIFICATIONS_RECEIVE_TWO_CARD = "에게 2장의 카드를 나누어줬습니다.\n";
    private static final String COMMA_WITH_SPACE = ", ";

    public static void printReceiveTwoCardNotifications(List<String> names) {
        System.out.println();
        for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i));
            printComma(names, i);
        }
        System.out.print(NOTIFICATIONS_RECEIVE_TWO_CARD);
    }

    private static void printComma(List<String> names, int i) {
        if(i != names.size() - 1) System.out.print(COMMA_WITH_SPACE);
    }
}
