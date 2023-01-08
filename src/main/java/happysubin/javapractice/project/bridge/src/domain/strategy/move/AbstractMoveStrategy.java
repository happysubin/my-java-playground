package happysubin.javapractice.project.bridge.src.domain.strategy.move;

import happysubin.javapractice.project.bridge.src.domain.PositionRecord;

import java.util.Map;

public abstract class AbstractMoveStrategy implements MoveStrategy{

    protected boolean determineGameSuccess(int size, Map<Integer, PositionRecord> map){
        return map.keySet().size() == size;
    }
}
