package happysubin.javapractice.project.bridge.src;

import happysubin.javapractice.project.bridge.src.domain.BridgeMaker;
import happysubin.javapractice.project.bridge.src.utils.RandomUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.when;

class BridgeMakerTest {

    @Test
    void bridgeSizeTest(){

        //given
        BridgeMaker bridgeMaker = new BridgeMaker();

        //when
        List<String> result = bridgeMaker.makeBridge(6);

        //then
        Assertions.assertThat(result.size()).isEqualTo(6);
    }


    @Test
    void bridgeInnerScanTest(){

        //given
        BridgeMaker bridgeMaker = new BridgeMaker();
        Mockito.mockStatic(RandomUtils.class);
        when(RandomUtils.getRandomNumber()).thenReturn(0,1,1,1);

        //when
        List<String> result = bridgeMaker.makeBridge(4);

        //then
        Assertions.assertThat(result.size()).isEqualTo(4);
        Assertions.assertThat(result).containsExactly("0","1","1","1");
    }
}