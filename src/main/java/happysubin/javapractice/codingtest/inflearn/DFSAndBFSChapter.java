package happysubin.javapractice.codingtest.inflearn;

/**
 * 재귀함수
 *
 * class DFSAndBFSChapter {
 *     public void DFS(int n){
 *         if(n==0) return;
 *         else{
 *             DFS(n-1);
 *             System.out.print(n+" ");
 *         }
 *     }
 *
 *     public void solution(int n){
 *         DFS(n);
 *     }
 *     public static void main(String[] args){
 *         DFSAndBFSChapter T = new DFSAndBFSChapter();
 *         T.solution(3);
 *         //System.out.println(T.solution(3));
 *     }
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
 *     private int recursive(int n) {
 *         if(n == 1) return 1;
 *         else return n * recursive(n - 1);
 *     }
 *
 *     public static void main(String[] args) {
 *         DFSAndBFSChapter T = new DFSAndBFSChapter();
 *         int recursive = T.recursive(5);
 *         System.out.println("recursive = " + recursive);
 *     }
 * }
 */



/**
 * 피보나치 수열
 * 답: 1 1 2 3 5 8 13 21 34 55
 * public class DFSAndBFSChapter {
 *
 *     private int recursive(int n) {
 *         if(n == 1) return 1;
 *         if(n == 2) return 1;
 *         else return recursive(n - 2) + recursive(n - 1) ;
 *     }
 *
 *     public static void main(String[] args) {
 *         DFSAndBFSChapter T = new DFSAndBFSChapter();
 *         for(int i = 1; i <= 10 ; i++) {
 *             System.out.println(T.recursive(i));
 *         }
 *     }
 * }
 *
 */






/** 이진트리 순회까지
 *
 * class Node{
 *     int data;
 *     Node lt, rt;
 *     public Node(int val) {
 *         data=val;
 *         lt=rt=null;
 *     }
 * }
 *
 * class DFSAndBFSChapter {
 *     Node root;
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
 *
 *     private void DFS(Node root) {
 *         if(root != null){
 *             System.out.println(root.data);
 *             DFS(root.lt);
 *             DFS(root.rt);
 *         }
 *     }
 * }
 */


/**
 * 부분 집합 구하기
 *
 * class DFSAndBFSChapter {
 *
 *     static int n;
 *     static int[] ch;
 *
 *     private void DFS(int L) {
 *         if(L==n+1){
 *             String tmp="";
 *             for(int i=1; i<=n; i++){
 *                 if(ch[i]==1) tmp+=(i+" ");
 *             }
 *             if(tmp.length()>0) System.out.println(tmp);
 *         }
 *         else{
 *             ch[L]=1;
 *             DFS(L+1);
 *             ch[L]=0;
 *             DFS(L+1);
 *         }
 *     }
 *
 *     public static void main(String[] args) {
 *         DFSAndBFSChapter T = new DFSAndBFSChapter();
 *         n = 3;
 *         ch = new int[n + 1];
 *         T.DFS(1);
 *     }
 * }
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 이진트리 레벨 탐색
 *
 * class Node{
 *     int data;
 *     Node lt, rt;
 *     public Node(int val) {
 *         data=val;
 *         lt=rt=null;
 *     }
 * }
 *
 * public class DFSAndBFSChapter{
 *     private Node root;
 *
 *     public void BFS(Node root){
 *         Queue<Node> Q=new LinkedList<>();
 *         Q.add(root);
 *         int L=0;
 *         while(!Q.isEmpty()){
 *             int len = Q.size();
 *             System.out.print(L+" : ");
 *             for(int i=0; i<len; i++){
 *                 Node cur = Q.poll();
 *                 System.out.print(cur.data+" ");
 *                 if(cur.lt!=null) Q.add(cur.lt);
 *                 if(cur.rt!=null) Q.add(cur.rt);
 *             }
 *             L++;
 *             System.out.println();
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
 *         tree.BFS(tree.root);
 *     }
 *
 * }
 */


/**
 * 송아지 찾기
 */

public class DFSAndBFSChapter{

    private int BFS(int start, int goal, int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        arr[start] = 1;
        queue.offer(start);
        int cnt = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if(poll == goal) return cnt;
                if(poll - 1 >0 && poll - 1 < 10000 && arr[poll - 1] == 0){
                    arr[poll - 1] = 1;
                    queue.add(poll - 1);
                }
                if(poll + 1 >0 && poll + 1 < 10000 && arr[poll + 1] == 0){
                    arr[poll + 1] = 1;
                    queue.add(poll + 1);
                }
                if(poll + 5 >0 && poll + 5 < 10000 && arr[poll + 5] == 0){
                    arr[poll + 5] = 1;
                    queue.add(poll + 5);
                }
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int start = Integer.parseInt(str[0]);
        int goal = Integer.parseInt(str[1]);

        DFSAndBFSChapter T = new DFSAndBFSChapter();

        int[] arr = new int[10001];

        int result = T.BFS(start, goal, arr);
        System.out.println(result);
    }
}