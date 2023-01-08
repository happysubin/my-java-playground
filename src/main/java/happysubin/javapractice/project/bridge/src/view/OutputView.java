package happysubin.javapractice.project.bridge.src.view;

import happysubin.javapractice.project.bridge.src.domain.BridgeGame;
import happysubin.javapractice.project.bridge.src.domain.Pass;
import happysubin.javapractice.project.bridge.src.domain.PositionRecord;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printMap (int nowPlace, Map<Integer, PositionRecord> map, List<String> bridge, String position) {
        System.out.print("[ ");
        for (int i = 0; i < nowPlace; i++) {
            PositionRecord positionRecord = map.get(i);
            if(i != 0 && i != bridge.size()){
                System.out.print(" | ");
            }
            if(positionRecord.getPosition().equals(position) && positionRecord.getPass() == Pass.PASS) {
                System.out.print("O");
            }
            else if(positionRecord.getPosition().equals(position) && positionRecord.getPass() == Pass.DONT_PASS){
                System.out.print("X");
            }
            else System.out.print(" ");
        }
        System.out.println(" ]");
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
