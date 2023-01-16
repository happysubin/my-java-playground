package happysubin.javapractice.project.blackjack.src.domain.card;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Level {
    ACE{
        @Override
        public int score() {
            return 1;
        }
    },
    TWO{
        @Override
        public int score() {
            return 2;
        }
    }
    ,
    THREE{
        @Override
        public int score() {
            return 3;
        }
    },
    FOUR {
        @Override
        public int score() {
            return 4;
        }
    },
    FIVE {
        @Override
        public int score() {
            return 5;
        }
    },
    SIX {
        @Override
        public int score() {
            return 6;
        }
    },
    SEVEN {
        @Override
        public int score() {
            return 7;
        }
    },
    EIGHT {
        @Override
        public int score() {
            return 8;
        }
    },
    NINE {
        @Override
        public int score() {
            return 9;
        }
    },
    TEN {
        @Override
        public int score() {
            return 10;
        }
    },
    JACK {
        @Override
        public int score() {
            return 10;
        }
    },
    QUEEN {
        @Override
        public int score() {
            return 10;
        }
    },
    KING {
        @Override
        public int score() {
            return 10;
        }
    };


    public abstract int score();

    public static List<Level> getLevelList(){
        return Arrays
                .stream(values())
                .collect(Collectors.toList());
    }
}
