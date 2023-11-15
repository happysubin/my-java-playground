package happysubin.javapractice.lab.datastructure.queue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class QueueTest {

    private Queue queue = new Queue();

    @Test
    void 하나의_요소를_넣고_뺀다() {

        queue.offer("a");

        Assertions.assertThat(queue.poll()).isEqualTo("a");
    }


    @Test
    void 여러_요소를_넣고_순차적으로_뺀다() {

        queue.offer("a");
        queue.offer("b");
        queue.offer("c");

        Assertions.assertThat(queue.poll()).isEqualTo("a");
        Assertions.assertThat(queue.poll()).isEqualTo("b");
        Assertions.assertThat(queue.poll()).isEqualTo("c");

    }

    @Test
    void offer과_poll을_여러번_섞어_진행한다() {
        queue.offer("a");
        queue.offer("b");

        String result1 = queue.poll();

        queue.offer("c");

        String result2 = queue.poll();

        queue.offer("d");

        String result3 = queue.poll();
        String result4 = queue.poll();


        assertThat(result1).isEqualTo("a");
        assertThat(result2).isEqualTo("b");
        assertThat(result3).isEqualTo("c");
        assertThat(result4).isEqualTo("d");


    }


    @Test
    void 큐가_비어있는데_poll을_진행하면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            queue.poll();
        }).isInstanceOf(RuntimeException.class)
                .hasMessage("큐가 비었습니다.");
    }

}