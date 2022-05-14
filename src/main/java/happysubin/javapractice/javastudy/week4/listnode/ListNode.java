package happysubin.javapractice.javastudy;


//정수를 저장하는 ListNode 클래스를 구현하세요.
//ListNode add(ListNode head, ListNode nodeToAdd, int position)를 구현하세요.
//ListNode remove(ListNode head, int positionToRemove)를 구현하세요.
//boolean contains(ListNode head, ListNode nodeTocheck)를 구현하세요.

public class ListNode {

    Node pointer;

    class Node{
        private Node nextNode;
        private int value;

        public Node(int value){
            this.value = value;
            this.nextNode = null;
        }
    }

    ListNode add(ListNode head, ListNode nodeToAdd, int position ){ //포지션이 3이면 세 번째에 넣는다.

        if(position == 0){ //포인터 바로 뒤에 놓는다는 의미
            //헤드 링크드 리스트의 포인터가 가리키는 값에 다음에 오는 포인터가 가리키는 헤드를 넣는다.
            head.pointer.nextNode = nodeToAdd.pointer.nextNode;


        }
        for()


        return head; //포지션이 0이면 헤드가 바뀐다

    }
    ListNode remove다ListNode head, int positionToRemove){ //포지션이 3이면 세번 째를 지운다.

    }

    boolean contains(ListNode head, ListNode nodeTocheck){ //해당 노드가 있는지 체크

    }

    Node findTail(ListNode head){
        Node tail;
        for(tail = head.pointer; tail!=null; tail = tail.nextNode ); //

        return tail;
    }
}
