package happysubin.javapractice.project.bridge.src;

import happysubin.javapractice.project.bridge.src.domain.BridgeGame;
import happysubin.javapractice.project.bridge.src.domain.BridgeMaker;
import happysubin.javapractice.project.bridge.src.domain.GameStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;


import static org.mockito.Mockito.mockStatic;

public class BridgeGameTest {

    MockedStatic<BridgeMaker> bridgeMakerMockedStatic;

    @BeforeEach
    void beforeEach(){
        bridgeMakerMockedStatic = mockStatic(BridgeMaker.class); //매번 모킹해야 한다.
    }

    @AfterEach
    void afterEach(){
        bridgeMakerMockedStatic.close(); //매번 닫아줘야 한다.
    }

    @Test
    @DisplayName("다리 건너기 게임을 재시도해 count가 올라간 다리 건너기 게임을 리턴을 확인하는 테스트")
    void retrySuccess(){
        BridgeGame bridgeGame = new BridgeGame(3, 0, GameStatus.ONGOING);
        BridgeGame retryBridgeGame = bridgeGame.retry(() -> "R");
        Assertions.assertThat(retryBridgeGame.getCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("다리 건너기 게임을 그만둠.")
    void retryFail(){
        BridgeGame bridgeGame = new BridgeGame(3, 0, GameStatus.ONGOING);
        BridgeGame retryBridgeGame = bridgeGame.retry(() -> "Q");
        Assertions.assertThat(bridgeGame == retryBridgeGame).isTrue();
        Assertions.assertThat(bridgeGame.getCount()).isEqualTo(retryBridgeGame.getCount());
    }

    @Test
    @DisplayName("아래 다리 이동을 성공")
    void downMoveSuccess(){
        BDDMockito.given(BridgeMaker.makeBridge(Mockito.any(Integer.class))).willReturn(List.of("1","0","1"));
        BridgeGame bridgeGame = new BridgeGame(3, 0, GameStatus.ONGOING);
        bridgeGame.move(()->"D");
        Assertions.assertThat(bridgeGame.bridgeGameIsOngoing()).isTrue();
    }

    @Test
    @DisplayName("아래 다리 이동을 실패")
    void downMoveFail(){
        BDDMockito.given(BridgeMaker.makeBridge(Mockito.any(Integer.class))).willReturn(List.of("0","0","1"));
        BridgeGame bridgeGame = new BridgeGame(3, 0, GameStatus.ONGOING);
        bridgeGame.move(()->"D");
        Assertions.assertThat(bridgeGame.bridgeGameIsFail()).isTrue();
    }

    @Test
    @DisplayName("윗 다리 이동을 성공")
    void upMoveSuccess(){
        BDDMockito.given(BridgeMaker.makeBridge(Mockito.any(Integer.class))).willReturn(List.of("0","0","1"));
        BridgeGame bridgeGame = new BridgeGame(3, 0, GameStatus.ONGOING);
        bridgeGame.move(()->"U");
        Assertions.assertThat(bridgeGame.bridgeGameIsOngoing()).isTrue();
    }

    @Test
    @DisplayName("윗 다리 이동을 실패")
    void upMoveFail(){
        BDDMockito.given(BridgeMaker.makeBridge(Mockito.any(Integer.class))).willReturn(List.of("1","0","1"));
        BridgeGame bridgeGame = new BridgeGame(3, 0, GameStatus.ONGOING);
        bridgeGame.move(()->"U");
        Assertions.assertThat(bridgeGame.bridgeGameIsFail()).isTrue();
    }

    @Test
    @DisplayName("다리 게임 완주")
    void bridgeGameSuccess(){
        BDDMockito.given(BridgeMaker.makeBridge(Mockito.any(Integer.class))).willReturn(List.of("1","0","1"));
        BridgeGame bridgeGame = new BridgeGame(3, 0, GameStatus.ONGOING);
        bridgeGame.move(()->"D");
        bridgeGame.move(()->"U");
        bridgeGame.move(()->"D");
        Assertions.assertThat(bridgeGame.bridgeGameIsSuccess()).isTrue();
    }
}
