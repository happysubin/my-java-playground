package happysubin.javapractice.codingtest;
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Unit7 {
    public static void recursive(int n){
        if(n==0)return;
        else {
            System.out.println(n);
            recursive(n - 1);
        }

    }
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        recursive(num);
    }
}

//자연수 n이 입력되면 1부터 n까지 출력

 */


/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Unit7 {
    public static void recursive(int n){
        if(n==0)return;
        else {
            System.out.print(n%2);
            recursive(n/2);
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        recursive(num);
    }
}

//2진수 재귀함수로 출력하기



 */

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Unit7 {
    public static int recursive(int n){
        if(n==1)return 1;
        else return n*recursive(n-1);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        System.out.println(recursive(num));
    }
}
    팩토리얼 재귀로 풀기
*/

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Unit7 {
    static int[] fibo;
    public static int recursive(int n){
        if(fibo[n]>0) return fibo[n]; //0보다 크면 이미 구한 숫자들이다. 시간을 줄이기 위해서 이 코드를 삽입!
        if(n==1)return fibo[n]=1;
        else if(n==2)return fibo[n]=1;
        else return fibo[n]=recursive(n-2)+recursive(n-1);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        fibo=new int[num+1];
        recursive(num);
        for(int i=1;i<=num;i++)System.out.print(fibo[i]+" ");
    }
}
//피보나치 수열 재귀를 이용.


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*

class Node{
    int data;
    Node rt,lt;

    public Node(int value){
        data=value;
        lt=rt=null;
    }

}

public class Unit7 {
    Node root;
    public void DFS(Node root){
        if(root==null)return ;
        else {
            //System.out.print(root.data+" "); //전위 순회
            DFS(root.lt);
            //System.out.print(root.data+" "); //중위 순회
            DFS(root.rt);
            System.out.print(root.data+" "); //후위 순회
        }
    }
    public static void main(String[] args){
        Unit7 tree=new Unit7();
        tree.root=new Node(1);
        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        tree.root.rt.lt=new Node(6);
        tree.root.rt.rt=new Node(7);
        tree.DFS(tree.root);

    }
}

 */
/** 트리 모양
 *                1
 *             2     3
 *           4  5   6  7
 *
 */

//이진 트리 순회 DFS

    /*

class Node{
    int data;
    Node rt,lt;

    public Node(int value){
        data=value;
        lt=rt=null;
    }

}

public class Unit7 {
    static int n;
    static int[] ch;
    public void DFS(int L){
        if(L==n+1){
            String tmp="";
            for(int i=1;i<=n;i++){
                if(ch[i]==1)tmp+=(i+" ");
            }
            if(tmp.length()>0) System.out.println(tmp);
        }
        else {
            ch[L]=1;
            DFS(L+1); //왼쪽. 사용한다.
            ch[L]=0;
            DFS(L+1);//오른쪽. 사용하지 않는다.
        }
    }
    public static void main(String[] args){
        Unit7 tree=new Unit7();
        n=3;
        ch=new int[n+1];
        tree.DFS(1);// value가 1인 루트부터 시작
    }
}

//부분집합 구하기


class Node{
    int data;
    Node rt,lt;

    public Node(int value){
        data=value;
        lt=rt=null;
    }

}

public class Unit7{
    Node root;

    public void BFS(Node root){
        Queue<Node> queue=new LinkedList();
        queue.offer(root);
        int L=0;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.data+" ");

            if(node.lt!=null)queue.offer(node.lt);
            if(node.rt!=null)queue.offer(node.rt);

        }
    }

    public void BFS(Node root){
        Queue<Node> queue=new LinkedList();
        queue.offer(root);
        int L=0;
        while(!queue.isEmpty()){
            int len=queue.size();
            System.out.print(L + " : ");

            for(int i=0;i<len;i++){
                Node node = queue.poll();
                System.out.print(node.data+" ");
                if(node.lt!=null)queue.offer(node.lt);
                if(node.rt!=null)queue.offer(node.rt);
            }
            L++;
            System.out.println();

        }
    }

    public static void main(String[] args) {
        Unit7 tree=new Unit7();
        tree.root=new Node(1);
        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        tree.root.rt.lt=new Node(6);
        tree.root.rt.rt=new Node(7);

        tree.BFS(tree.root);
    }
}

     */

import java.util.*;

public class Unit7 {
    int answer = 0;
    int[] dist = {1, -1, 5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();

    public int BFS(int s, int e) {
        ch = new int[100001];
        ch[s] = 1;
        Q.offer(s);
        int L = 0; //루트 레벨은 0
        while (!Q.isEmpty()) {

        }
        String hello ="world";
        System.out.println("hello = " + hello);

        return 0;
    }



    public static void main(String[] args) {
        Unit7 T=new Unit7();
        //Scanner sc=new Scanner(System.in);
        //int s=sc.nextInt();//현수 위치
        //int e=sc.nextInt();//송아지 위치
        //System.out.println(T.BFS(s,e));
        String hello ="world";
        System.out.println("hello = " + hello);

    }
}