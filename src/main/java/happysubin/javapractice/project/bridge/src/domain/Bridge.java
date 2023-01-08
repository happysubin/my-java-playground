package happysubin.javapractice.project.bridge.src.domain;

import happysubin.javapractice.project.bridge.src.domain.observer.BridgeObserver;
import happysubin.javapractice.project.bridge.src.domain.strategy.move.MoveStrategy;

import java.util.*;

public class Bridge {

    private final List<String> bridge;
    private final Map<Integer, PositionRecord> resultMap = new LinkedHashMap<>();
    private int nowPlace = 0;

    private final List<MoveStrategy> moveStrategies = new ArrayList<>();
    private final BridgeObserver observer;

    public Bridge(List<String> bridge, List<MoveStrategy> moveStrategies) {
        this.bridge = bridge;
        this.moveStrategies.addAll(moveStrategies);
        this.observer = new BridgeObserver(this);
    }

    public GameStatus move(String moveCommand) {
        for (MoveStrategy moveStrategy : moveStrategies) {
            if(moveStrategy.isMove(moveCommand)){
                return moveStrategy.move(bridge, nowPlace++, resultMap);
            }
        }
        return GameStatus.FAIL;
    }

    public void printBridge(){
        observer.printBridgeStatus();
    }

    public int getNowPlace() {
        return nowPlace;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public Map<Integer, PositionRecord> getResultMap() {
        return resultMap;
    }

    public Bridge initBridge(){
        return new Bridge(this.bridge, moveStrategies);
    }
}

/**
 * U - 0
 * D - 1
 */