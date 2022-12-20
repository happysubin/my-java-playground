package happysubin.javapractice.project.lotto.src;

import org.assertj.core.api.AbstractThrowableAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.MockedStatic;
import org.mockito.Mockito;


public class InputViewTest {

    MockedStatic<ScannerWrapper> scanner;

    @BeforeEach
    void beforeEach(){
        scanner = Mockito.mockStatic(ScannerWrapper.class); //매번 모킹해야 한다.
    }

    @AfterEach
    void afterEach(){
        scanner.close(); //매번 닫아줘야 한다.
    }

    @Test
    @DisplayName("머니 객체 성공 테스트")
    void createSuccessMoneyWithInputView(){

        //given
        BDDMockito.given(ScannerWrapper.input()).willReturn("10000");

        //when
        Money result = InputView.createMoney((Money money) -> {
            validateMoney(money);
        });

        //then
        Assertions.assertThat(result.getValue()).isEqualTo(10000);
    }

    @Test
    @DisplayName("머니 객체 실패 태스트: 1000원 보다 부족한 금액이 문제")
    void createFailFirstCaseMoneyWithInputView(){

        //given
        BDDMockito.given(ScannerWrapper.input()).willReturn("999");

        //when
        AbstractThrowableAssert<?, ? extends Throwable> result = Assertions.assertThatThrownBy(() -> {
            InputView.createMoney((Money money) -> {
                validateMoney(money);
            });
        });

        //then
        result.hasMessage("로또를 구입할 금액이 부족합니다.");
    }

    @Test
    @DisplayName("머니 객체 실패 태스트: 나누어 떨어지지 않은 금액이 문제")
    void createFailSecondCaseMoneyWithInputView(){

        //given
        BDDMockito.given(ScannerWrapper.input()).willReturn("1007");

        //when
        AbstractThrowableAssert<?, ? extends Throwable> result = Assertions.assertThatThrownBy(() -> {
            InputView.createMoney((Money money) -> {
                validateMoney(money);
            });
        });

        result.hasMessage("거스름이 없도록 입력해주세요.");
    }

    private void validateMoney(Money money) {
        if (money.getValue() < 1000) throw new RuntimeException("로또를 구입할 금액이 부족합니다.");
        if (money.getValue() % 1000 != 0) throw new RuntimeException("거스름이 없도록 입력해주세요.");
    }

    @Test
    @DisplayName("머니 객체 실패 태스트: 콘솔에 입력한 값이 숫자 형식이 아니어서 실패.")
    void createFailMoneyWithInputViewInvalidNumberFormat(){

        //given
        BDDMockito.given(ScannerWrapper.input()).willReturn("ㅋㅋㅋㅋㅋ");

        //when
        AbstractThrowableAssert<?, ? extends Throwable> result = Assertions.assertThatThrownBy(() -> {
            InputView.createMoney((Money money) -> {
                validateMoney(money);
            });
        });

        //then
        result.hasMessage("숫자 형식으로 입력해주세요.");
    }
}