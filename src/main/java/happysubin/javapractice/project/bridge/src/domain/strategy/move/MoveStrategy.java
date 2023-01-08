package happysubin.javapractice.project.bridge.src.domain.strategy.move;

import happysubin.javapractice.project.bridge.src.domain.GameStatus;
import happysubin.javapractice.project.bridge.src.domain.PositionRecord;

import java.util.List;
import java.util.Map;

public interface MoveStrategy {

    boolean isMove(String command);

    GameStatus move(List<String> bridge, int nowPlace, Map<Integer, PositionRecord> map);
}
