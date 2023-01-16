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

        @Override
        public String toString() {
            return "A";
        }
    },
    TWO{
        @Override
        public int score() {
            return 2;
        }

        @Override
        public String toString() {
            return "2";
        }
    }
    ,
    THREE{
        @Override
        public int score() {
            return 3;
        }

        @Override
        public String toString() {
            return "3";
        }
    },
    FOUR {
        @Override
        public int score() {
            return 4;
        }

        @Override
        public String toString() {
            return "4";
        }
    },
    FIVE {
        @Override
        public int score() {
            return 5;
        }

        @Override
        public String toString() {
            return "5";
        }
    },
    SIX {
        @Override
        public int score() {
            return 6;
        }

        @Override
        public String toString() {
            return "6";
        }
    },
    SEVEN {
        @Override
        public int score() {
            return 7;
        }

        @Override
        public String toString() {
            return "7";
        }
    },
    EIGHT {
        @Override
        public int score() {
            return 8;
        }

        @Override
        public String toString() {
            return "8";
        }
    },
    NINE {
        @Override
        public int score() {
            return 9;
        }

        @Override
        public String toString() {
            return "9";
        }
    },
    TEN {
        @Override
        public int score() {
            return 10;
        }

        @Override
        public String toString() {
            return "10";
        }
    },
    JACK {
        @Override
        public int score() {
            return 10;
        }

        @Override
        public String toString() {
            return "J";
        }
    },
    QUEEN {
        @Override
        public int score() {
            return 10;
        }

        @Override
        public String toString() {
            return "Q";
        }
    },
    KING {
        @Override
        public int score() {
            return 10;
        }

        @Override
        public String toString() {
            return "K";
        }
    };


    public abstract int score();

    public static List<Level> getLevelList(){
        return Arrays
                .stream(values())
                .collect(Collectors.toList());
    }
}
