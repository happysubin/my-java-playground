package happysubin.javapractice.project.blackjack.src.view;

import happysubin.javapractice.project.blackjack.src.domain.PlayerInfo;
import happysubin.javapractice.project.blackjack.src.utils.ScannerWrapper;
import org.assertj.core.api.AbstractThrowableAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

class InputViewTest {

    MockedStatic<ScannerWrapper> mockedStatic;

    @BeforeEach
    void beforeEach(){
        mockedStatic = mockStatic(ScannerWrapper.class); //매번 모킹해야 한다.
    }

    @AfterEach
    void afterEach(){
        mockedStatic.close();
    }

    @Test
    void successInputNameCase1(){
        //given
        given(ScannerWrapper.getInput()).willReturn("su,bin,bean");

        //when
        List<String> result = InputView.inputPlayerName();

        //then
        assertThat(result).containsExactly("su","bin","bean");
    }

    @Test
    void successInputNameCase2(){
        //given
        given(ScannerWrapper.getInput()).willReturn("su");

        //when
        List<String> result = InputView.inputPlayerName();

        //then
        assertThat(result).containsExactly("su");
    }

    @Test
    void failInputNameCase1(){
        //given
        given(ScannerWrapper.getInput()).willReturn("su,bin!!!bean");

        //when
        AbstractThrowableAssert<?, ? extends Throwable> result = assertThatThrownBy(() -> {
            InputView.inputPlayerName();
        });

        //then
        result.hasMessage("입력할 이름 형식과 틀립니다.");
    }

    @Test
    void failInputNameCase2(){
        //given
        given(ScannerWrapper.getInput()).willReturn("su123");

        //when
        AbstractThrowableAssert<?, ? extends Throwable> result = assertThatThrownBy(() -> {
            InputView.inputPlayerName();
        });

        //then
        result.hasMessage("입력할 이름 형식과 틀립니다.");
    }

    @Test
    void successCreatePlayerInfo(){
        //given
        given(ScannerWrapper.getInput()).willReturn("10000");

        //when
        PlayerInfo result = InputView.inputPlayerBettingMoney("subin");

        //then
        assertThat(result.getName()).isEqualTo("subin");
        assertThat(result.getBettingMoney()).isEqualTo(10000);
    }

    @Test
    void failCreatePlayerInfo(){
        //given
        given(ScannerWrapper.getInput()).willReturn("kiki");

        //when
        AbstractThrowableAssert<?, ? extends Throwable> result = assertThatThrownBy(() -> {
            InputView.inputPlayerBettingMoney("subin");
        });

        //then
        assertThat(result.hasMessage("숫자 형식이 아닙니다."));
    }
}