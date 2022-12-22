package happysubin.javapractice.project.lotto.src;

import happysubin.javapractice.project.lotto.src.util.RandomUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomUtilTest {

    @Test
    void test(){
        List<Integer> result = RandomUtil.pickUniqueNumbersInRange(1, 46, 6);

        result.stream().forEach(System.out::println);
        Assertions.assertThat(result.size()).isEqualTo(6);
    }

}