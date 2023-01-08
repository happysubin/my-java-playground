package happysubin.javapractice.project.bridge.src.domain.strategy.move;

import happysubin.javapractice.project.bridge.src.domain.GameStatus;
import happysubin.javapractice.project.bridge.src.domain.Pass;
import happysubin.javapractice.project.bridge.src.domain.PositionRecord;

import java.util.List;
import java.util.Map;

public class DownMoveStrategy extends AbstractMoveStrategy {

    @Override
    public boolean isMove(String command) {
        return command.equals("D");
    }

    @Override
    public GameStatus move(List<String> bridge, int nowPlace, Map<Integer, PositionRecord> map) {
        if(bridge.get(nowPlace).equals("1")){
            map.put(nowPlace, new PositionRecord("1", Pass.PASS));
            if(super.determineGameSuccess(bridge.size(), map)){
                return GameStatus.SUCCESS;
            }
            return GameStatus.ONGOING;
        }
        map.put(nowPlace, new PositionRecord("1", Pass.DONT_PASS));
        return GameStatus.FAIL;
    }
}
