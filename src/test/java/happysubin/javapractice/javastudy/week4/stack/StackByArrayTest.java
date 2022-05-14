package happysubin.javapractice.javastudy.week4.stack;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class StackByArrayTest {

    @Test
    @DisplayName("정상적인 pop 로직")
    void stackIntegrationTest(){
        //given
        StackByArray stack = new StackByArray();

        //when
        stack.push(1);
        stack.push(2);
        //stack.push(3);
        

        //then
        //System.out.println("stack.pop() = " + stack.pop());
        assertEquals(2,stack.pop());
        assertEquals(1,stack.pop());
    }

    @Test
    @DisplayName("정상적인 push 로직")
    void pushTest(){
        //given
        StackByArray stack = new StackByArray();

        //when
        stack.push(1);
        stack.push(2);

        //then
        int[] getStack = stack.getStack();
        assertThat(getStack[0]).isEqualTo(1);
        assertThat(getStack[1]).isEqualTo(2);

    }

    @Test
    @DisplayName("빈 스택에 pop를 하면 오류가 발생")
    void occurEmptyStackException(){

        assertThatThrownBy(()->{
            StackByArray stack = new StackByArray();
            stack.pop();
        }).isInstanceOf(EmptyStackException.class);
    }

    @Test
    @DisplayName("가득찬 스택에 push를 하면 오류가 발생")
    void occurFullStackException(){
        assertThrows(FullStackException.class,()->{
            StackByArray stack = new StackByArray();
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);
            stack.push(6);
        });
    }

}