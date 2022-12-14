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

import java.awt.image.DataBufferDouble;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 부분 집합 구하기
 *
 * class DFSAndBFSChapter {
 *     static int n;
 *     static int[] ch;
 *     public void DFS(int L){
 *         if(L==n+1){
 *             String tmp="";
 *             for(int i=1; i<=n; i++){
 *                 if(ch[i]==1) tmp+=(i+" ");
 *             }
 *             if(tmp.length()>0) System.out.println(tmp);
 *         }
 *         else{
 *             ch[L]=1; //사용한다.
 *             DFS(L+1);
 *             ch[L]=0; //사용하지 않는다.
 *             DFS(L+1);
 *         }
 *     }
 *
 *     public static void main(String[] args){
 *         DFSAndBFSChapter T = new DFSAndBFSChapter();
 *         n=3;
 *         ch=new int[n+1];
 *         T.DFS(1);
 *     }
 * }
 */

//이진트리 레벨 탐색

/**
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
 *     Node root;
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
 *         DFSAndBFSChapter tree = new DFSAndBFSChapter();
 *         tree.root=new Node(1);
 *         tree.root.lt=new Node(2);
 *         tree.root.rt=new Node(3);
 *         tree.root.lt.lt=new Node(4);
 *         tree.root.lt.rt=new Node(5);
 *         tree.root.rt.lt=new Node(6);
 *         tree.root.rt.rt=new Node(7);
 *         tree.BFS(tree.root);
 *     }
 * }
 */


/** 끝까지 시도한 첫 풀이
 * public class DFSAndBFSChapter{
 *
 *     class Node{
 *         int level;
 *         int value;
 *
 *         public Node(int value, int level) {
 *             this.level = level;
 *             this.value = value;
 *         }
 *     }
 *
 *     public int BFS(int start, int goal){
 *         Queue<Node> queue = new LinkedList<>();
 *         int[] pos = new int[100001];
 *         queue.add(new Node(start, 0));
 *         Node result = null;
 *         while(true){
 *             Node node = queue.poll();
 *             pos[node.value] = 1;
 *             if(node.value == goal){
 *                 result = node;
 *                 break;
 *             }
 *             else{
 *                 if(node.value + 1 <= 10000 && node.value > 1 && pos[node.value + 1] == 0 )  queue.add(new Node(node.value + 1, node.level + 1));
 *                 if(node.value + 1 <= 10000 && node.value > 1 && pos[node.value - 1] == 0 )  queue.add(new Node(node.value - 1, node.level + 1));
 *                 if(node.value + 1 <= 10000 && node.value > 1 && pos[node.value + 5] == 0 )  queue.add(new Node(node.value + 5, node.level + 1));
 *             }
 *         }
 *
 *         return result.level;
 *     }
 *
 *     public static void main(String args[]) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *         String[] s = br.readLine().split(" ");
 *         int start = Integer.parseInt(s[0]);
 *         int goal = Integer.parseInt(s[1]);
 *
 *         DFSAndBFSChapter tree = new DFSAndBFSChapter();
 *         int bfs = tree.BFS(start, goal);
 *         bw.write(bfs + "");
 *         bw.flush();
 *     }
 * }
 */




import java.util.*;
public class DFSAndBFSChapter {
    int answer=0;
    int[] dis={1, -1, 5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();
    public int BFS(int s, int e){
        ch=new int[10001];
        ch[s]=1;
        Q.offer(s);
        int L=0;
        while(!Q.isEmpty()){
            int len=Q.size();
            for(int i=0; i<len; i++){
                int x = Q.poll();
                for(int j=0; j<3; j++){
                    int nx=x+dis[j];
                    if(nx==e){
                        return L+1;
                    }
                    if(nx>=1 && nx<=10000 && ch[nx]==0){
                        ch[nx]=1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args){
        DFSAndBFSChapter T = new DFSAndBFSChapter();
        Scanner kb = new Scanner(System.in);
        int s=kb.nextInt();
        int e=kb.nextInt();
        System.out.println(T.BFS(s, e));
    }
}

