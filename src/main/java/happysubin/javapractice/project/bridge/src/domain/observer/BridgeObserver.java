package happysubin.javapractice.project.bridge.src.domain.observer;

import happysubin.javapractice.project.bridge.src.domain.Bridge;
import happysubin.javapractice.project.bridge.src.domain.Pass;
import happysubin.javapractice.project.bridge.src.domain.PositionRecord;

import java.util.List;
import java.util.Map;

public class BridgeObserver {

    private Bridge bridge;

    public BridgeObserver(Bridge bridge) {
        this.bridge = bridge;
    }

    /**
     * 옵저버는 풀 방식이 더 좋다고 해서 게터를 사용.
     */
    public void printBridgeStatus(){
        int nowPlace = bridge.getNowPlace();
        Map<Integer, PositionRecord> map = this.bridge.getResultMap();
        List<String> bridge = this.bridge.getBridge();
        System.out.println("bridge = " + bridge);
        extracted(nowPlace, map, bridge, "0");
        extracted(nowPlace, map, bridge, "1");
    }

    private void extracted(int nowPlace, Map<Integer, PositionRecord> map, List<String> bridge, String position) {
        System.out.print("[ ");
        for (int i = 0; i < nowPlace; i++) {
            PositionRecord positionRecord = map.get(i);
            if(i != 0 && i != bridge.size()) System.out.print(" | ");
            if(positionRecord.getPosition().equals(position) && positionRecord.getPass() == Pass.PASS) System.out.print("O");
            else if(positionRecord.getPosition().equals(position) && positionRecord.getPass() == Pass.DONT_PASS)System.out.print("X");
            else System.out.print(" ");
        }
        System.out.println(" ]");
    }
}
