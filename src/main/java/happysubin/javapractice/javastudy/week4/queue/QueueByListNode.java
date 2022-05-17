package happysubin.javapractice.javastudy.week4.queue;

//ListNode를 사용해서 Stack을 구현하세요.

import happysubin.javapractice.javastudy.week4.listnode.ListNode;

public class QueueByListNode {

    private ListNode front;
    private ListNode rear;

    public QueueByListNode() {
        this.front = new ListNode();
        this.rear =  new ListNode();
    }

    public void enqueue(){

    }

    public int dequeue(){
        if(queueIsEmpty()){
            throw new EmptyQueueException("큐가 비었습니다.");
        }


    }

    boolean queueIsEmpty(){
        if(this.front == this.rear ) return true;
        else return false;
    }

}
