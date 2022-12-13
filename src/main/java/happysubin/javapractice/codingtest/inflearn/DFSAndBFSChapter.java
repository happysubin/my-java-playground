package happysubin.javapractice.codingtest.inflearn;

/**
 * 재귀 함수
 * 답 1 2 3 4 5 6 7 8 9
 *
 * public class DFSAndBFSChapter {
 *
 *     public static void recursive(int n){
 *         if(n == 0) return;
 *         else {
 *             recursive(n - 1);
 *             System.out.print(n + " ");
 *             //recursive(n - 1);
 *         }
 *     }
 *
 *     public static void main(String[] args) {
 *         recursive(9);
 *     }
 *
 * }
 */

/**
 * 이진수 출력
 *
 * 답: 1 0 1 1
 *
 * public class DFSAndBFSChapter {
 *
 *     public static void recursive(int n){
 *         if(n == 0) return;
 *         else {
 *             recursive(n /2);
 *             System.out.print(n % 2 + " ");
 *         }
 *     }
 *
 *     public static void main(String[] args) {
 *         recursive(11);
 *     }
 *
 * }
 */

/**
 * 팩토리얼
 * 답: 120
 * public class DFSAndBFSChapter {
 *
 *     public static int recursive(int n){
 *         if(n == 1) return 1;
 *         else return n *= recursive(n - 1);
 *     }
 *
 *     public static void main(String[] args) {
 *         int recursive = recursive(5);
 *         System.out.println("recursive = " + recursive);
 *     }
 * }
 */

/**
 * 피보나치 수열
 * 답: 1 1 2 3 5 8 13 21 34 55
 *
 * public class DFSAndBFSChapter {
 *
 *     public static int recursive(int n){
 *         if(n == 1) return 1;
 *         else if(n == 2) return 1;
 *         else return recursive(n -1) + recursive(n - 2);
 *     }
 *
 *     public static void main(String[] args) {
 *         for (int i = 1; i <= 10; i++) {
 *             System.out.println(recursive(i));
 *         }
 *     }
 * }
 */

//이진트리 순회까지

/**
 * public class DFSAndBFSChapter {
 *
 *     Node root;
 *     public void DFS(Node root){
 *         if(root==null)
 *             return;
 *         else{
 *             DFS(root.lt);
 *             System.out.print(root.data+" ");
 *             DFS(root.rt);
 *         }
 *     }
 *
 *     public static void main(String args[]) {
 *         DFSAndBFSChapter tree=new DFSAndBFSChapter();
 *         tree.root=new Node(1);
 *         tree.root.lt=new Node(2);
 *         tree.root.rt=new Node(3);
 *         tree.root.lt.lt=new Node(4);
 *         tree.root.lt.rt=new Node(5);
 *         tree.root.rt.lt=new Node(6);
 *         tree.root.rt.rt=new Node(7);
 *         tree.DFS(tree.root);
 *     }
 * }
 *
 *
 * class Node{
 *     int data;
 *     Node lt, rt;
 *     public Node(int val) {
 *         data=val;
 *         lt=rt=null;
 *     }
 * }
 */

class DFSAndBFSChapter {
    static int n;
    static int[] ch;
    public void DFS(int L){
        if(L==n+1){
            String tmp="";
            for(int i=1; i<=n; i++){
                if(ch[i]==1) tmp+=(i+" ");
            }
            if(tmp.length()>0) System.out.println(tmp);
        }
        else{
            ch[L]=1; //사용한다.
            DFS(L+1);
            ch[L]=0; //사용하지 않는다.
            DFS(L+1);
        }
    }

    public static void main(String[] args){
        DFSAndBFSChapter T = new DFSAndBFSChapter();
        n=3;
        ch=new int[n+1];
        T.DFS(1);
    }
}