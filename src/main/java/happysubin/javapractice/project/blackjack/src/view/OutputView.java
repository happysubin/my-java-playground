package happysubin.javapractice.project.blackjack.src.view;

import happysubin.javapractice.project.blackjack.src.domain.player.PlayerInfo;

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

    public static void notifyGameParticipantReceiveCommand(String name) {
        System.out.println(name + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
    }

    public static void notifyDealerReceiveCommandUnder16(String name) {
        System.out.println("\n" + name + "는 16이하라 한장의 카드를 더 받았습니다.\n");
    }

    public static void printResult(PlayerInfo playerInfo) {
        System.out.println(playerInfo.getName() + ": " + playerInfo.getBettingMoney());
    }
}
