package happysubin.javapractice.codingtest.baekjoon;

import java.io.*;
import java.util.*;

public class Graph {
    static void dfs(int[][] graph, int startNode, int[] visitedLocation ){
        visitedLocation[startNode]  = 1;
        System.out.print(startNode + " ");

        for(int i = 1; i <= graph.length - 1; i++){
            if(graph[startNode][i] == 1 & visitedLocation[i] != 1){
                dfs(graph, i,visitedLocation);
            }
        }
    }

    static void bfs(int[][] graph, int startNode){
        Queue<Integer> queue = new LinkedList<>();

        int[] visitedLocation = new int[graph.length]; //4개면 1 2 3 4
        visitedLocation[startNode]  = 1;
        System.out.print(startNode + " ");
        queue.add(startNode);

        while(!queue.isEmpty()){
            int poll = queue.poll();
            for(int i = 1; i <= graph.length - 1 ; i++ ){
                if(graph[poll][i] == 1 & visitedLocation[i] != 1){
                    visitedLocation[i] = 1;
                    System.out.print(i + " ");
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int totalToken = Integer.parseInt(token.nextToken());
        int totalLine = Integer.parseInt(token.nextToken());
        int startNode = Integer.parseInt(token.nextToken());

        int[][] graph = new int[totalToken + 1][totalToken + 1];

        for(int i = 0; i < totalLine; i++){
            StringTokenizer token2 = new StringTokenizer(br.readLine()," ");
            int row = Integer.parseInt(token2.nextToken());
            int col = Integer.parseInt(token2.nextToken());
            graph[col][row] = 1;
            graph[row][col] = 1;
        }

        int[] visitedLocation = new int [graph.length];
        dfs(graph, startNode, visitedLocation);
        System.out.println();
        bfs(graph, startNode);
    }
}
