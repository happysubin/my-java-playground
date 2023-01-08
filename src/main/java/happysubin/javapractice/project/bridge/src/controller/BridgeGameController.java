package happysubin.javapractice.project.bridge.src.controller;

import happysubin.javapractice.project.bridge.src.domain.BridgeGame;
import happysubin.javapractice.project.bridge.src.view.InputView;
import happysubin.javapractice.project.bridge.src.view.OutputView;

import static happysubin.javapractice.project.bridge.src.domain.GameStatus.*;

public class BridgeGameController {

    public void start() {
        int bridgeSize = InputView.readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeSize, 1, ONGOING);;
        while(bridgeGame.bridgeGameIsOngoing()){
            bridgeGame.move(InputView::readMoving);
            bridgeGame = judgeRetryBridgeGame(bridgeGame);
        }
        OutputView.printResult(bridgeGame);
    }

    private BridgeGame judgeRetryBridgeGame(BridgeGame bridgeGame) {
        if(bridgeGame.bridgeGameIsFail()){
            bridgeGame = bridgeGame.retry(InputView::readGameCommand);
        }
        return bridgeGame;
    }
}

/**
 * 이넘 변수에는 매개변수로 들어올때 다른 값을 넣을 수가 없나??
 * 매개변수로 enum을 가져와서 값을 넣는데 값이 제대로 안들어간다.
 */
