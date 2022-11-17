package happysubin.javapractice.javastudy.week4.queue;

import happysubin.javapractice.javastudy.week4.listnode.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class QueueByListNodeTest {

    @Test
    @DisplayName("빈 큐에서 point을 하면 EmptyQueueException 발생")
    void occurEmptyQueueException(){
        Assertions.assertThrows(EmptyQueueException.class,()->{
            QueueByListNode queue = new QueueByListNode();
            queue.point();
        });
    }
    @Test
    @DisplayName("정상적인 큐 offer 실행 로직")
    void offerTest(){
        //given
        QueueByListNode queue = new QueueByListNode();

        //when
        queue.offer(1);
        queue.offer(2);

        //then
        ListNode head = queue.getHead();

        assertThat(head.getNextNode().getValue()).isEqualTo(1);
        assertThat(head.getNextNode().getNextNode().getValue()).isEqualTo(2);

    }

    @Test
    @DisplayName("정상적인 큐 point 실행 로직")
    void pointTest(){
        //given
        QueueByListNode queue = new QueueByListNode();
        queue.offer(1);
        queue.offer(2);

        //when
        int result1 = queue.point();
        int result2 = queue.point();

        //then
        assertThat(result1).isEqualTo(1);
        assertThat(result2).isEqualTo(2);
    }

}