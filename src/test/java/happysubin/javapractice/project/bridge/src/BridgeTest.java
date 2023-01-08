package happysubin.javapractice.project.bridge.src;

import happysubin.javapractice.project.bridge.src.domain.Bridge;
import happysubin.javapractice.project.bridge.src.domain.GameStatus;
import happysubin.javapractice.project.bridge.src.domain.Pass;
import happysubin.javapractice.project.bridge.src.factory.MoveStrategiesFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeTest {

    @Test
    @DisplayName("기본적인 윗 다리를 건너는 성공 테스트")
    void basicUpMoveSuccessTest(){
        Bridge bridge = new Bridge(List.of("0", "0", "1"), MoveStrategiesFactory.createMoveStrategies());
        GameStatus gameStatus = bridge.move("U");
        Assertions.assertThat(gameStatus).isEqualTo(GameStatus.ONGOING);
        Assertions.assertThat(bridge.getResultMap().get(0).getPass()).isEqualTo(Pass.PASS);
    }

    @Test
    @DisplayName("기본적인 윗 다리를 건너는 실패 테스트")
    void basicUpMoveFailTest(){
        Bridge bridge = new Bridge(List.of("1", "0", "1"), MoveStrategiesFactory.createMoveStrategies());
        GameStatus gameStatus = bridge.move("U");
        Assertions.assertThat(gameStatus).isEqualTo(GameStatus.FAIL);
        Assertions.assertThat(bridge.getResultMap().get(0).getPass()).isEqualTo(Pass.DONT_PASS);
    }


    @Test
    @DisplayName("기본적인 윗 다리를 건너는 성공 테스트")
    void basicDownMoveSuccessTest(){
        Bridge bridge = new Bridge(List.of("1", "0", "1"), MoveStrategiesFactory.createMoveStrategies());
        GameStatus gameStatus = bridge.move("D");
        Assertions.assertThat(gameStatus).isEqualTo(GameStatus.ONGOING);
        Assertions.assertThat(bridge.getResultMap().get(0).getPass()).isEqualTo(Pass.PASS);
    }

    @Test
    @DisplayName("기본적인 윗 다리를 건너는 실패 테스트")
    void basicDownMoveFailTest(){
        Bridge bridge = new Bridge(List.of("0", "0", "1"), MoveStrategiesFactory.createMoveStrategies());
        GameStatus gameStatus = bridge.move("D");
        Assertions.assertThat(gameStatus).isEqualTo(GameStatus.FAIL);
        Assertions.assertThat(bridge.getResultMap().get(0).getPass()).isEqualTo(Pass.DONT_PASS);
    }

    @Test
    @DisplayName("다리 완주 테스트")
    void moveBridgeSuccessTest(){
        Bridge bridge = new Bridge(List.of("1", "1", "1"), MoveStrategiesFactory.createMoveStrategies());
        bridge.move("D");
        bridge.move("D");
        GameStatus gameStatus = bridge.move("D");
        Assertions.assertThat(gameStatus).isEqualTo(GameStatus.SUCCESS);
        Assertions.assertThat(bridge.getResultMap().get(0).getPass()).isEqualTo(Pass.PASS);
        Assertions.assertThat(bridge.getResultMap().get(1).getPass()).isEqualTo(Pass.PASS);
        Assertions.assertThat(bridge.getResultMap().get(2).getPass()).isEqualTo(Pass.PASS);

    }
}
