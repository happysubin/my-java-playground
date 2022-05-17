package happysubin.javapractice.javastudy.week4.queue;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class QueueByArrayTest {

    @Test
    @DisplayName("enqueue 정상적인 로직 테스트")
    void enqueueTest(){
        //given
        QueueByArray queue = new QueueByArray();

        //when
        queue.enqueue(1);
        queue.enqueue(2);

        //then
        int[] getQueue = queue.getQueue();

        assertEquals(1,getQueue[0]);
        assertEquals(2,getQueue[1]);
    }

    @Test
    @DisplayName("dequeue 정상적인 로직 테스트")
    void dequeueTest(){
        //given
        QueueByArray queue = new QueueByArray();

        //when
        queue.enqueue(1);
        queue.enqueue(2);

        //then
        assertThat(1).isEqualTo(queue.dequeue());
        assertThat(2).isEqualTo(queue.dequeue());
    }

    @Test
    @DisplayName("빈 큐에서  dequeue를 실행하면 EmptyQueueException 발생.")
    void occurEmptyQueueException(){
        assertThatThrownBy(()->{
            QueueByArray queue = new QueueByArray();
            queue.dequeue();
        }).isInstanceOf(EmptyQueueException.class);
    }

    @Test
    @DisplayName("큐가 가득차고 enqueue를 실행하면 FullQueueException 발생.")
    void occurFullQueueException(){
        assertThrows(FullQueueException.class,()->{
            QueueByArray queue = new QueueByArray();
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            queue.enqueue(4);
            queue.enqueue(5);
            queue.enqueue(6);
        });
    }




}