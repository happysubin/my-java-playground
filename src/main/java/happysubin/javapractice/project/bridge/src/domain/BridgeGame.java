package happysubin.javapractice.project.bridge.src.domain;

import happysubin.javapractice.project.bridge.src.domain.strategy.move.DownMoveStrategy;
import happysubin.javapractice.project.bridge.src.domain.strategy.command.MoveCommandStrategy;
import happysubin.javapractice.project.bridge.src.domain.strategy.command.RetryCommandStrategy;
import happysubin.javapractice.project.bridge.src.domain.strategy.move.UpMoveStrategy;

import java.util.List;

public class BridgeGame {

    private final Bridge bridge;
    private final Integer count;
    private GameStatus gameStatus;

    public BridgeGame(int bridgeSize, Integer count, GameStatus gameStatus) {
        validateBridgeSize(bridgeSize);
        this.bridge = new Bridge(new BridgeMaker().makeBridge(bridgeSize), List.of(new DownMoveStrategy(), new UpMoveStrategy()));
        this.count = count;
        this.gameStatus = gameStatus;
    }

    private BridgeGame(Bridge bridge, Integer count, GameStatus gameStatus) {
        this.bridge = bridge;
        this.count = count;
        this.gameStatus = gameStatus;
    }

    private void validateBridgeSize(int bridgeSize) {
        if(bridgeSize < 3 || bridgeSize > 20 ) throw new RuntimeException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    public void move(MoveCommandStrategy moveStrategy) {
        this.gameStatus = bridge.move(moveStrategy.getMoveCommand());
        bridge.printBridge();
    }

    public BridgeGame retry(RetryCommandStrategy commandStrategy) {
        if(stopGame(commandStrategy.getRetryCommand())){
            this.gameStatus = GameStatus.FAIL;
            return this;
        }
        //this.gameStatus =  GameStatus.ONGOING;
        return new BridgeGame(this.bridge.initBridge(), count + 1, GameStatus.ONGOING);
    }

    private boolean stopGame(String command) {
        return command.equals("Q");
    }

    public boolean bridgeGameIsOngoing(){
        return this.gameStatus == GameStatus.ONGOING;
    }

    public boolean bridgeGameIsFail(){
        return this.gameStatus == GameStatus.FAIL;
    }

    public boolean bridgeGameIsSuccess(){
        return this.gameStatus == GameStatus.SUCCESS;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Integer getCount() {
        return count;
    }

    public Bridge getBridge() {
        return bridge;
    }
}