package happysubin.javapractice.project.blackjack.src.domain.card;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Suit {
    HEART, SPADE, CLOVER, DIAMOND;

    public static List<Suit> getSuitList(){
        return Arrays
                .stream(values())
                .collect(Collectors.toList());
    }
}
