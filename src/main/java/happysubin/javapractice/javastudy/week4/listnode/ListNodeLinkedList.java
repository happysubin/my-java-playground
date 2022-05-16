package happysubin.javapractice.javastudy.week4.listnode;

public class ListNodeLinkedList{

    ListNode add(ListNode head, ListNode nodeToAdd, int position){ //제일 헤드를 리턴한다.

        if(listNodeIsNull(head) | listNodeIsNull(nodeToAdd)){
            throw new NodeIsNullException();
        }

        if(positionIsMinus(position)){
            throw new PositionIsMinusException();
        }

        //- 위에는 Validation 아래는 프로그램 로직

        if(positionIsZero(position)){ //맨 앞에 넣는다면
            ListNode tail = moveToTail(nodeToAdd); //꼬리를 찾는다.
            tail.setNextNode(head);//꼬리에 노드 리스트를 넣는다.
            return nodeToAdd; //앞으로간 노드 리스트를 리턴한다.
        }
        else {
            ListNode findNode = moveToNextNodeByPosition(head, position); // position 만큼 이동해서 노드를 찾는다.
            ListNode tmp = findNode.getNextNode(); //발견한 노드의 nextNode 참조 값을 임시로 저장
            findNode.setNextNode(nodeToAdd); //발견한 노드에다가 새로운 노드들을 연결
            ListNode tail = moveToTail(nodeToAdd); //새로운 노드, 즉 연결한 노드들의 꼬리를 찾는다
            tail.setNextNode(tmp); //찾아서 임시로 저장한 tmp 값을 nextNode로 연결
            return head;
        }
    }

    ListNode remove(ListNode head, int positionToRemove){

        if(listNodeIsNull(head)){
            throw new NodeIsNullException();
        }

        if(positionIsMinus(positionToRemove)){
            throw new PositionIsMinusException();
        }

        //- 위에는 Validation 아래는 프로그램 로직

        if(positionIsZero(positionToRemove)){
            head = head.getNextNode();
            return head;
        }
        else{
            ListNode findNode = moveToNextNodeByPosition(head, positionToRemove);
            ListNode willConnectNode=findNode.getNextNode().getNextNode();
            findNode.setNextNode(willConnectNode);
            return head;
        }
    }

    boolean contains(ListNode head, ListNode nodeTocheck){

        if(listNodeIsNull(head) | listNodeIsNull(nodeTocheck)){
            throw new NodeIsNullException();
        }

        //- 위에는 Validation 아래는 프로그램 로직

        for(ListNode node = head;node != null ; node = node.getNextNode()){
            if(node == nodeTocheck) return true;
        }
        return false;
    }

    ListNode moveToTail(ListNode head){//head.pointer.nextNode가 들어온다.
        ListNode tail;
        for(tail = head; tail.getNextNode() !=null; tail = tail.getNextNode() );
        return tail;
    }

    ListNode moveToNextNodeByPosition(ListNode node,int position){
        for(int i=0; i < position -1 ; i++){ //1이 들어오면 그냥 node의 nextNode를 변경해야 한다.
            node = node.getNextNode();
            if(node == null){
                throw new OutOfRangeLinkedListException();
            }
        }
        return node;
    }

    boolean positionIsZero(int position){
        if(position == 0) return true;
        else return false;
    }

    boolean listNodeIsNull(ListNode node){
        if(node == null) return true;
        else return false;
    }

    boolean positionIsMinus(int position){
        if(position < 0) return true;
        else return false;
    }

    public static void main(String[] args) {
        ListNodeLinkedList linkedList = new ListNodeLinkedList();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);


        node1.setNextNode(node2);
        node2.setNextNode(node3);


        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node4.setNextNode(node5);
        node5.setNextNode(node6);

        ListNode list = linkedList.add(node1, node4, 3);

        for (ListNode node = list; node != null ; node = node.getNextNode()) {
            System.out.print(node.getValue() + " -> ");
        }

        System.out.println();
        ListNode remove = linkedList.remove(list, 5);

        for (ListNode node = remove; node != null ; node = node.getNextNode()) {
            System.out.print(node.getValue() + " -> ");
        }

        ListNode node7 = new ListNode(7);

        System.out.println();
        System.out.println(linkedList.contains(remove,node7));
        System.out.println(linkedList.contains(remove,node5));

    }

}