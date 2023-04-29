package happysubin.javapractice.codingtest.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalNode = sc.nextInt();
        int totalEdge = sc.nextInt();
        int startNode = sc.nextInt();
        int[][] graph = new int[totalNode + 1][totalNode + 1];
        for(int i = 0; i < totalEdge; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = 1;
        }

        //dfs
        int[] dfsCheck = new int[graph.length];
        dfs(graph, dfsCheck, startNode);
        System.out.println();
        //bfs
        bfs(graph, totalNode, startNode);
    }

    private static void dfs(int[][] graph, int[] dfsCheck, int startNode){
//        dfsCheck[startNode] = 1;
//        System.out.print(startNode + " ");
//        for (int i = 1; i <= graph.length - 1; i++) {
//            if(graph[startNode][i] == 1 & dfsCheck[i] != 1){
//                dfs(graph, dfsCheck, i);
//            }
//        }
        dfsCheck[startNode]  = 1;
        System.out.print(startNode + " ");

        for(int i = 1; i <= graph.length - 1; i++){
            if(graph[startNode][i] == 1 & dfsCheck[i] != 1){
                dfs(graph, dfsCheck, i);
            }
        }
    }

    private static void bfs(int[][] graph, int totalNode, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        int[] bfsCheck = new int[totalNode + 1];
        queue.add(startNode);
        bfsCheck[startNode] = 1;
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            System.out.print(poll + " ");
            for (int i = 1; i <= graph.length - 1; i++) {
                if(graph[poll][i] == 1 & bfsCheck[i] != 1){
                    bfsCheck[i] = 1;
                    queue.add(i);
                }
            }
        }
    }
}
