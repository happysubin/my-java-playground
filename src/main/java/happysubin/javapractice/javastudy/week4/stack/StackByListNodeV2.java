package happysubin.javapractice.javastudy.week4.stack;

import happysubin.javapractice.javastudy.week4.listnode.ListNode;

public class StackByListNodeV2 {

    private ListNode head;

    public StackByListNodeV2() {
        this.head = new ListNode();
    }

    public void push(int value){ //값을 넣는다
        if(queueIsEmpty()){
            ListNode newNode = new ListNode(value);
            this.head.setNextNode(newNode);
        }
        else{
            ListNode newNode = new ListNode(value);
            newNode.setNextNode(head.getNextNode());
            head.setNextNode(newNode);
        }
    }

    public int pop(){
        if(queueIsEmpty()){
            throw new EmptyStackException("스택이 비었습니다.");
        }
        else{
            int value = head.getNextNode().getValue();
            this.head.setNextNode(this.head.getNextNode().getNextNode());
            return value;
        }
    }

    boolean queueIsEmpty(){
        if(this.head.getNextNode() == null ) return true;
        else return false;
    }

    public static void main(String[] args) {
        StackByListNodeV2 stack = new StackByListNodeV2();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());

    }

}
