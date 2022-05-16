package happysubin.javapractice.javastudy.week4.listnode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ListNodeLinkedListTest {

    @Test
    @DisplayName("ListNodeLinkedList add 메소드 매개변수로 Null값의 ListNode가 할당되면 안된다")
    void occurNodeIsNullExceptionInAddMethod(){
        assertThrows(NodeIsNullException.class,()->{
            ListNodeLinkedList linkedList = new ListNodeLinkedList();
            ListNode node = new ListNode(1);
            linkedList.add(node,null,1);
        });

        assertThrows(NodeIsNullException.class,()->{
            ListNodeLinkedList linkedList = new ListNodeLinkedList();
            ListNode node = new ListNode(1);
            linkedList.add(null,node,1);
        });

        assertThrows(NodeIsNullException.class,()->{
            ListNodeLinkedList linkedList = new ListNodeLinkedList();
            ListNode node = new ListNode(1);
            linkedList.add(null,null,1);
        });
    }

    @Test
    @DisplayName("ListNodeLinkedList remove 메소드 매개변수로 Null값의 ListNode가 할당되면 안된다")
    void occurNodeIsNullExceptionInRemoveMethod(){
        assertThrows(NodeIsNullException.class,()->{
            ListNodeLinkedList linkedList = new ListNodeLinkedList();
            ListNode node = new ListNode(1);
            linkedList.remove(null,1);
        });
    }

    @Test
    @DisplayName("ListNodeLinkedList contains 메소드 매개변수로 Null값의 ListNode가 할당되면 안된다")
    void occurNodeIsNullExceptionInContainsMethod(){
        assertThrows(NodeIsNullException.class,()->{
            ListNodeLinkedList linkedList = new ListNodeLinkedList();
            ListNode node = new ListNode(1);
            linkedList.contains(null,null);
        });

        assertThrows(NodeIsNullException.class,()->{
            ListNodeLinkedList linkedList = new ListNodeLinkedList();
            ListNode node = new ListNode(1);
            linkedList.contains(node,null);
        });

        assertThrows(NodeIsNullException.class,()->{
            ListNodeLinkedList linkedList = new ListNodeLinkedList();
            ListNode node = new ListNode(1);
            linkedList.contains(null,node);
        });
    }

    @Test
    @DisplayName("ListNodeLinkedList contains 메소드 매개변수로 음수 값의 position이 할당되면 안된다")
    void occurPositionsMinusExceptionInAddMethod(){

        assertThatThrownBy(()->{
            ListNodeLinkedList linkedList = new ListNodeLinkedList();
            ListNode node1 = new ListNode(1);
            ListNode node2 = new ListNode(2);
            linkedList.add(node1,node2,-1);

        }).isInstanceOf(PositionIsMinusException.class);
    }

    @Test
    @DisplayName("ListNodeLinkedList contains 메소드 매개변수로 음수 값의 position이 할당되면 안된다")
    void occurPositionsMinusExceptionInRemoveMethod(){

        assertThatThrownBy(()->{
            //given
            ListNodeLinkedList linkedList = new ListNodeLinkedList();
            ListNode node1 = new ListNode(1);
            ListNode node2 = new ListNode(2);
            ListNode head = linkedList.add(node1, node2, 1);

            //when
            linkedList.remove(head,-1);

            //then

        }).isInstanceOf(PositionIsMinusException.class);
    }

    //-위에는 예외 테스트, 아래는 정상 로직 테스트

    @Test
    @DisplayName("정상적인 ListNode add 로직")
    void successAddLogic(){
        //given
        ListNodeLinkedList linkedList = new ListNodeLinkedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.setNextNode(node2);
        node3.setNextNode(node4);

        //when
        linkedList.add(node1,node3,1);

        //then
        assertThat(node1.getNextNode()).isSameAs(node3);
        assertThat(node4.getNextNode()).isSameAs(node2);
    }

    //ToDo remove 로직
    @Test
    @DisplayName("정상적인 ListNode add 로직")
    void successRemoveLogic(){
        //given
        ListNodeLinkedList linkedList = new ListNodeLinkedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5= new ListNode(5);

        linkedList.add(node1, node2, 1);
        linkedList.add(node1,node3,2);
        linkedList.add(node1,node4,3);
        linkedList.add(node1,node5,2);
        // 1 -> 2 -> 5 -> 3 -> 4 -> null

        //when
        ListNode remove = linkedList.remove(node1, 0); // 2 -> 5 -> 3 -> 4 -> null
        linkedList.remove(remove,2);// 2 -> 5 -> 4 -> null

        //then
        for (ListNode node = remove; node != null ; node = node.getNextNode()) {
            System.out.print(node.getValue() + " -> ");
        }

        assertThat(remove).isSameAs(node2);
        assertThat(node5.getNextNode()).isSameAs(node4);

    }

    @Test
    @DisplayName("contains 리턴 값이 true")
    void containsReturnIsTrue(){
        //given
        ListNodeLinkedList linkedList = new ListNodeLinkedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5= new ListNode(5);

        //when

        linkedList.add(node1,node2,1);
        linkedList.add(node1,node3,2);
        linkedList.add(node1,node4,3);
        linkedList.add(node1,node5,4);

        //then

        assertThat(linkedList.contains(node1,node5)).isEqualTo(true);
    }

    @Test
    @DisplayName("contains 리턴 값이 true")
    void containsReturnIsFalse(){

        //given
        ListNodeLinkedList linkedList = new ListNodeLinkedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5= new ListNode(5);

        //when

        linkedList.add(node1,node2,1);
        linkedList.add(node1,node3,2);
        linkedList.add(node1,node4,3);
        linkedList.add(node1,node5,4);

        linkedList.remove(node1,1);

        //then

        assertThat(linkedList.contains(node1,node2)).isEqualTo(false);
    }
}