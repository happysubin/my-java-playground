package happysubin.javapractice.project.bridge.src.view;

import happysubin.javapractice.project.bridge.src.domain.BridgeGame;

public class OutputView {

    public static void printMap() {
    }

    public static  void printResult(BridgeGame bridgeGame) {
        System.out.println("\n최종 게임 결과");
        bridgeGame.getBridge().printBridge();
        System.out.println("\n게임 성공 여부 : ");
        if(bridgeGame.bridgeGameIsFail()) System.out.print("실패");
        if(bridgeGame.bridgeGameIsSuccess()) System.out.print("성공");
        System.out.println("\n총 시도한 횟수 : " + bridgeGame.getCount());
    }
}
