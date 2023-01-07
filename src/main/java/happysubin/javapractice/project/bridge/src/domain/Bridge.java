package happysubin.javapractice.project.bridge.src.domain;

import java.util.List;

public class Bridge {

    private List<String> bridge;
    private int nowPlace;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.nowPlace = 0;
    }

    public boolean arriveBridgeFinishLine(){
        return nowPlace == bridge.size();
    }

    public boolean move(String moveCommand) {
    }
}
