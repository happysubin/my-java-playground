package happysubin.javapractice.project.bridge.src.domain;

import happysubin.javapractice.project.bridge.src.domain.move.MoveStrategy;
import happysubin.javapractice.project.bridge.src.view.InputView;

import java.util.List;

public class BridgeGame {

    private Bridge bridge;
    private Integer count;

    public BridgeGame(BridgeMaker bridgeMaker, int bridgeSize, Integer count) {
        validateBridgeSize(bridgeSize);
        this.bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        this.count = count;
    }

    private void validateBridgeSize(int bridgeSize) {
        if(bridgeSize < 3 || bridgeSize > 20 ) throw new RuntimeException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    public boolean move(MoveStrategy moveStrategy) {
        if(bridge.arriveBridgeFinishLine()){
            return false;
        }

        //TODO 입력 값을 기준으로 건넜는데 못 건너면 실패함.
        String moveCommand = moveStrategy.getMoveCommand();
        return bridge.move(moveCommand);
    }

    public void retry() {
    }
}