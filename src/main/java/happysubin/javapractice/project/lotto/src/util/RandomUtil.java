package happysubin.javapractice.project.lotto.src.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomUtil {


    private RandomUtil(){}

    public static List<Integer> pickUniqueNumbersInRange(int start, int end, int count) {

        validateRange(start, end);
        validateCount(start, end, count);
        List<Integer> list = IntStream.rangeClosed(start, end)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(list);
        return list.subList(0, count);
    }

    private static void validateRange(final int startInclusive, final int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException("startInclusive cannot be greater than endInclusive.");
        }
        if (endInclusive == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("endInclusive cannot be greater than Integer.MAX_VALUE.");
        }
        if (endInclusive - startInclusive >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("the input range is too large.");
        }
    }

    private static void validateCount(final int startInclusive, final int endInclusive, final int count) {
        if (count < 0) {
            throw new IllegalArgumentException("count cannot be less than zero.");
        }
        if (endInclusive - startInclusive + 1 < count) {
            throw new IllegalArgumentException("count cannot be greater than the input range.");
        }
    }

}

//1부터 46 사이의 숫자에서 6개를 중복 없이 뽑아야함.

/**
 * Collections.shuffle
 * 지정된 랜덤성 소스를 사용하여 지정된 목록을 랜덤하게 순열합니다. 즉 리스트를 랜덤하게 섞어버림.
 *
 * 검증 로직은 아래에서 가져옴.
 * https://github.com/woowacourse-projects/mission-utils/blob/main/src/main/java/camp/nextstep/edu/missionutils/Randoms.java 참고함.
 */