package happysubin.javapractice.lab.datastructure;

import happysubin.javapractice.lab.datastructure.stack.Stack;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * 큐 2개를 사용해 스택을 만든다.
 */

class StackTest {

    private Stack stack = new Stack();

    @Test
    void 스택에_1개_값을_집어넣고_뺀다() {

        stack.push("a");

        String result = stack.pop();
        assertThat(result).isEqualTo("a");
    }

    @Test
    void 스택에_2개_값을_집어넣고_순차적으로_뺀다() {
        stack.push("a", "b");

        String result1 = stack.pop();
        String result2 = stack.pop();


        assertThat(result1).isEqualTo("b");
        assertThat(result2).isEqualTo("a");
    }

    @Test
    void 스택에_4개_값을_집어넣고_순차적으로_뺀다() {
        stack.push("a", "b", "c", "d");

        String result1 = stack.pop();
        String result2 = stack.pop();
        String result3 = stack.pop();
        String result4 = stack.pop();


        assertThat(result1).isEqualTo("d");
        assertThat(result2).isEqualTo("c");
        assertThat(result3).isEqualTo("b");
        assertThat(result4).isEqualTo("a");
    }

    @Test
    void pop과_push를_여러번_섞어_진행한다() {
        stack.push("a", "b");

        String result1 = stack.pop();

        stack.push("c");
        String result2 = stack.pop();

        stack.push("d");
        String result3 = stack.pop();

        String result4 = stack.pop();

        assertThat(result1).isEqualTo("b");
        assertThat(result2).isEqualTo("c");
        assertThat(result3).isEqualTo("d");
        assertThat(result4).isEqualTo("a");
    }

    @Test
    void 스택이_비어있는데_pop을_진행하면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            stack.pop();
        }).isInstanceOf(RuntimeException.class)
                .hasMessage("스택이 비었습니다.");
    }
}