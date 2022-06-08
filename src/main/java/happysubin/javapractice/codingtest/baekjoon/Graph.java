package happysubin.javapractice.codingtest.baekjoon;

import java.io.*;
import java.util.*;

/*
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


 */


public class Graph {

    class Position{
        int x;
        int y;
        int count;

        public Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    void solution(int[][] graph, int row, int col){
        Queue<Position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];

        visited[0][0] = true;

        queue.add(new Position(0,0,0));

        while(!queue.isEmpty()){
            Position poll = queue.poll();
            if( poll.x + 1 < row && graph[poll.x + 1][poll.y] == 1 && !visited[poll.x + 1][poll.y] ){
                visited[poll.x + 1][poll.y] = true;
                queue.add(new Position(poll.x + 1, poll.y, poll.count + 1));
            }
            if( poll.x - 1 >= 0 && graph[poll.x - 1][poll.y] == 1 && !visited[poll.x - 1][poll.y] ){
                visited[poll.x - 1][poll.y] = true;
                queue.add(new Position(poll.x - 1, poll.y, poll.count + 1));
            }
            if( poll.y + 1 < col && graph[poll.x][poll.y + 1] == 1 && !visited[poll.x][poll.y + 1] ){
                visited[poll.x][poll.y + 1] = true;
                queue.add(new Position(poll.x, poll.y + 1, poll.count + 1));
            }
            if( poll.y - 1 >= 0 && graph[poll.x][poll.y - 1] == 1 && !visited[poll.x][poll.y - 1] ){
                visited[poll.x][poll.y - 1] = true;
                queue.add(new Position(poll.x, poll.y - 1, poll.count + 1));
            }

            if(poll.x == row - 1 & poll.y == col -1){
                System.out.println(poll.count + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        Graph g = new Graph();

        int row = Integer.parseInt(s[0]);
        int col = Integer.parseInt(s[1]);

        int[][] arr = new int[row][col];

        for (int i = 0; i < row ; i++ ) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < col ; j++ ) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        g.solution(arr, row, col);
    }
}
