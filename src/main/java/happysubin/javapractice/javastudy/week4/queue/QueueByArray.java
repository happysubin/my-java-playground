package happysubin.javapractice.javastudy.week4.queue;

public class QueueByArray {
    private int max = 5;
    private int[] queue = new int [max];
    private int front = -1; //뺄 값의 위치
    private int rear = -1; //넣은 값의 위치

    public boolean isEmpty(){
        if(front == rear) return true;
        else return false;
    }

    public boolean isFull(){
        if(rear == max - 1) return true;
        else return false;
    }

    public void enqueue(int value){
        if(isFull()){
            throw new FullQueueException("큐가 가득찼습니다");
        }
        queue[++rear] = value;
    }

    public int dequeue(){
        if(isEmpty()){
            throw new EmptyQueueException("큐가 비었습니다");
        }
        int result = queue[++front];
        return result;
    }

    public int[] getQueue() {
        return queue;
    }
}
