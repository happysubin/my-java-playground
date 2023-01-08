package happysubin.javapractice.project.bridge.src.domain.strategy.move;

import happysubin.javapractice.project.bridge.src.domain.GameStatus;
import happysubin.javapractice.project.bridge.src.domain.Pass;
import happysubin.javapractice.project.bridge.src.domain.PositionRecord;
import happysubin.javapractice.project.bridge.src.domain.strategy.move.MoveStrategy;

import java.util.List;
import java.util.Map;

public class UpMoveStrategy extends AbstractMoveStrategy {

    @Override
    public boolean isMove(String command) {
        return command.equals("U");
    }

    @Override
    public GameStatus move(List<String> bridge, int nowPlace, Map<Integer, PositionRecord> map) {
        if(bridge.get(nowPlace).equals("0")){
            map.put(nowPlace, new PositionRecord("0", Pass.PASS));
            if(super.determineGameSuccess(bridge.size(), map)){
                return GameStatus.SUCCESS;
            }
            return GameStatus.ONGOING;
        }
        map.put(nowPlace, new PositionRecord("0", Pass.DONT_PASS));
        return GameStatus.FAIL;
    }
}
