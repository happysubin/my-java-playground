package happysubin.javapractice.project.lotto.src;

import java.util.Arrays;

public enum Prize {

    FIRST(2_000_000_000, 1),
    SECOND(30_000_000, 2),
    THIRD(1_500_000, 3),
    FOURTH(50_000, 4),
    FIFTH(5_000, 5);


    Prize(int prizeMoney, int rank) {
        this.prizeMoney = prizeMoney;
        this.rank = rank;
    }

    private int prizeMoney;
    private int rank;


    public static Prize getValue(int rank){
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.rank == rank)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("해당하는 로또 등수는 없습니다"));
    }



}
