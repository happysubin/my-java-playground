package happysubin.javapractice.project.bridge.src.factory;

import happysubin.javapractice.project.bridge.src.domain.strategy.move.DownMoveStrategy;
import happysubin.javapractice.project.bridge.src.domain.strategy.move.MoveStrategy;
import happysubin.javapractice.project.bridge.src.domain.strategy.move.UpMoveStrategy;

import java.util.List;

public class MoveStrategiesFactory {

    public static List<MoveStrategy> createMoveStrategies(){
        return List.of(new UpMoveStrategy(), new DownMoveStrategy());
    }
}
