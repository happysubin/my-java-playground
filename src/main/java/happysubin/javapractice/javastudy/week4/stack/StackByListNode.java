package happysubin.javapractice.javastudy.week4.stack;

import happysubin.javapractice.javastudy.week4.listnode.ListNode;


public class StackByListNode {
    ListNode head;

    public StackByListNode(){
        head = new ListNode(); //무조건 참조 객체로 보장된다.
    }

    public void push(int value){
        if(nodeIsHead(head)){
            ListNode newNode = new ListNode(value);
            head.setNextNode(newNode);
        }
        else{
            ListNode tail = moveToTail();
            ListNode newNode = new ListNode(value);
            tail.setNextNode(newNode);
        }
    }

    public int pop(){
        if(nodeIsHead(head)){
            throw new EmptyStackException("스택이 비었습니다.");
        }
        else{
            ListNode tail = moveToTail();
            ListNode tailBeforeNode = findTailBeforeNode(tail);
            int result = tail.getValue();
            tailBeforeNode.setNextNode(null);

            return result;
        }
    }

    ListNode moveToTail(){
        ListNode tail;
        for(tail = head; tail.getNextNode() != null; tail = tail.getNextNode());
        return tail;
    }

    ListNode findTailBeforeNode(ListNode tail){
        ListNode result;
        for(result = head; result.getNextNode() != null ; result = result.getNextNode()){
            if(result.getNextNode() == tail) return result;
        }
        return result;
    }

    boolean nodeIsHead(ListNode head){
        if(head.getNextNode() == null) return true;
        else return false;
    }

    public ListNode getHead() {
        return head;
    }

    public static void main(String[] args) {
        StackByListNode stack = new StackByListNode();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());

    }

}
