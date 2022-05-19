package happysubin.javapractice.javastudy.week4.queue;

import happysubin.javapractice.javastudy.week4.listnode.ListNode;

public class QueueByListNode {

    private ListNode head;

    public QueueByListNode() {
        this.head = new ListNode();
    }

    public void offer(int value){ //값을 넣는다
        if(queueIsEmpty()){
            ListNode newNode = new ListNode(value);

            this.head.setNextNode(newNode);
        }
        else{
            ListNode newNode = new ListNode(value);
            ListNode tail = findTailNode();
            tail.setNextNode(newNode);
        }
    }

    public int poll(){
        if(queueIsEmpty()){
            throw new EmptyQueueException("큐가 비었습니다.");
        }
        else{
            int value = head.getNextNode().getValue();
            this.head.setNextNode(this.head.getNextNode().getNextNode());
            return value;
        }
    }

    ListNode findTailNode(){
        ListNode result;
        for(result = this.head; result.getNextNode()!=null; result = result.getNextNode());
        return result;
    }

    boolean queueIsEmpty(){
        if(this.head.getNextNode() == null ) return true;
        else return false;
    }

    public static void main(String[] args) {
        QueueByListNode queue = new QueueByListNode();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());

    }

    public ListNode getHead() {
        return head;
    }
}
