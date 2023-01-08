package happysubin.javapractice.project.bridge.src.domain;

import happysubin.javapractice.project.bridge.src.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    //private BridgeMaker(){}

    public static List<String> makeBridge(int size) {

        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bridge.add(String.valueOf(RandomUtils.getRandomNumber()));
        }
        return bridge;
    }
}
