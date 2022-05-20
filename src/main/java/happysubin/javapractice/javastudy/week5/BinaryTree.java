package happysubin.javapractice.javastudy.week5;

import java.util.LinkedList;

public class BinaryTree  {


    public BinaryTree() {

    }

    public void dfs(Node node){ //사실상 스택을 사용한 것

        if(node.getLeft()!= null) dfs(node.getLeft());
        System.out.println(node.getValue());
        if(node.getRight() != null) dfs(node.getRight());

    }

    public void bfs(Node node){
        LinkedList<Node> queue = new LinkedList();

        queue.add(node);

        while(!queue.isEmpty()){
            node  = queue.poll();
            System.out.println(node.getValue());

            if(node.getLeft() != null) queue.add(node.getLeft());
            if(node.getRight() !=null) queue.add(node.getRight());
        }
    }

    public static void main(String[] args) {
        Node root = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);

        node2.setLeft(node5);
        node2.setRight(node6);
        node3.setLeft(node7);
        node4.setLeft(node8);
        node4.setRight(node9);
        node6.setRight(node10);
            /**
             *        0
             *    1       2
             *  3   4   5   6
             *7   8  9       10   모양의 트리
             *
             */
        BinaryTree tree = new BinaryTree();
        System.out.println("dfs");
        tree.dfs(root);

        System.out.println("bfs");
        tree.bfs(root);
    }
}
