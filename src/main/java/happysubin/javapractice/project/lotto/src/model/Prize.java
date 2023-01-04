package happysubin.javapractice.project.lotto.src.model;

import java.util.Arrays;

public enum Prize {


    FAIL(0, 0),
    FIFTH(5_000, 5){
        @Override
        public String toString() {
            return "3개 일치 (5,000원)";
        }
    },
    FOURTH(50_000, 4){
        @Override
        public String toString() {
            return "4개 일치 (50,000원)";
        }
    },
    THIRD(1_500_000, 3){
        @Override
        public String toString() {
            return "5개 일치 (1,500,000원)";
        }
    },
    SECOND(30_000_000, 2){
        @Override
        public String toString() {
            return "5개 일치, 보너스 볼 일치 (30,000,000원)";
        }
    },
    FIRST(2_000_000_000, 1){
        @Override
        public String toString() {
            return "6개 일치 (2,000,000,000원)";
        }
    };

    Prize(int prizeMoney, int rank) {
        this.prizeMoney = prizeMoney;
        this.rank = rank;
    }

    private int prizeMoney;
    private int rank;

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Prize getValue(int rank){
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.rank == rank)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("해당하는 로또 등수는 없습니다"));
    }
}
