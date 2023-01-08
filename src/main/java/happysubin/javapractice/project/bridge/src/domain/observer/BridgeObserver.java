package happysubin.javapractice.project.bridge.src.domain.observer;

import happysubin.javapractice.project.bridge.src.domain.Bridge;
import happysubin.javapractice.project.bridge.src.domain.Pass;
import happysubin.javapractice.project.bridge.src.domain.PositionRecord;
import happysubin.javapractice.project.bridge.src.view.OutputView;

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
        OutputView.printMap(nowPlace, map, bridge, "0");
        OutputView.printMap(nowPlace, map, bridge, "1");
    }

}
