package happysubin.javapractice.javastudy.week4.listnode;

public class ListNode {
    private int value;
    private ListNode nextNode;

    public ListNode(){

    }

    public ListNode(int value){
        this.value = value;
        this.nextNode = null;
    }

    public int getValue() {
        return value;
    }

    public ListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(ListNode nextNode) {
        this.nextNode = nextNode;
    }

}
