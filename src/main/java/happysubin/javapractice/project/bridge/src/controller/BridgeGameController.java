package happysubin.javapractice.project.bridge.src.controller;

import happysubin.javapractice.project.bridge.src.domain.BridgeGame;
import happysubin.javapractice.project.bridge.src.domain.BridgeMaker;
import happysubin.javapractice.project.bridge.src.view.InputView;

public class BridgeGameController {

    public void start() {
        InputView.printStartGameMessage();
        int bridgeSize = InputView.readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(), bridgeSize, 0);
        boolean flag = true;

        while(flag){
            flag = bridgeGame.move(()-> InputView.readMoving());
        }
    }
}
