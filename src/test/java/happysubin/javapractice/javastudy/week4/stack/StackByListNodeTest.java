package happysubin.javapractice.javastudy.week4.stack;

import happysubin.javapractice.javastudy.week4.listnode.ListNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackByListNodeTest {

    @Test
    @DisplayName("빈 스택에서 pop 하면 EmptyStackException 발생")
    void occurEmptyStackException(){
        assertThrows(EmptyStackException.class,()->{
            StackByListNode stack = new StackByListNode();
            stack.pop();
        });
    }

    @Test
    @DisplayName("스택 push 하는 로직")
    void pushTest(){
        //given
        StackByListNode stack = new StackByListNode();

        //when
        stack.push(1);
        stack.push(2);

        //then
        ListNode head = stack.getHead();
        Assertions.assertThat(head.getNextNode().getValue()).isEqualTo(1);
        Assertions.assertThat(head.getNextNode().getNextNode().getValue()).isEqualTo(2);
    }

    @Test
    @DisplayName("스택 pop 하는 로직")
    void popTest(){
        //given
        StackByListNode stack = new StackByListNode();
        stack.push(1);
        stack.push(2);

        //when
        int result1 = stack.pop();
        int result2= stack.pop();


        //then
        Assertions.assertThat(2).isEqualTo(result1);
        Assertions.assertThat(1).isEqualTo(result2);
    }

}