package happysubin.javapractice.project.blackjack.src.domain.card;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Suit {
    HEART(){
        @Override
        public String toString() {
            return "하트";
        }
    },
    SPADE(){
        @Override
        public String toString() {
            return "스페이드";
        }
    },
    CLOVER(){
        @Override
        public String toString() {
            return "클로버";
        }
    },
    DIAMOND(){
        @Override
        public String toString() {
            return "다이아몬드";
        }
    };

    private String name;

    public static List<Suit> getSuitList(){
        return Arrays
                .stream(values())
                .collect(Collectors.toList());
    }
}
