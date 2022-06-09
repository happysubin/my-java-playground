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

/*
//미로 탐색 bfs
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


 */


/*
//단지 탐색
public class Graph{
    class Position{
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }

    static ArrayList<Integer> answer = new ArrayList<>();

     void dfs(int[][] graph,boolean[][] dfsVisited, boolean[][] bfsVisited ,int x, int y){
            if(graph[x][y] == 1 & !dfsVisited[x][y] ){
                bfs(graph, bfsVisited, x, y);
            }

                dfsVisited[x][y] = true;
                if(x + 1 < graph.length && !dfsVisited[x + 1][y]) dfs(graph,dfsVisited, bfsVisited ,x + 1, y);
                if(x - 1 >= 0 && !dfsVisited[x - 1][y]) dfs(graph,dfsVisited, bfsVisited, x - 1, y);
                if(y + 1 < graph.length && !dfsVisited[x][y + 1]) dfs(graph,dfsVisited, bfsVisited, x, y + 1);
                if(y - 1 >= 0 && !dfsVisited[x][y - 1]) dfs(graph,dfsVisited, bfsVisited , x, y - 1);

    }

    public void bfs(int[][] graph,boolean[][] visited ,int x, int y){
        Queue<Position> queue = new LinkedList<>();
        visited[x][y] = true;
        int sum = 1;

        queue.add(new Position(x,y));

        while(!queue.isEmpty()){
            Position poll = queue.poll();
            graph[poll.x][poll.y] = 0;
            if( poll.x + 1 < graph.length && graph[poll.x + 1][poll.y] == 1 && !visited[poll.x + 1][poll.y] ){
                visited[poll.x + 1][poll.y] = true;
                queue.add(new Position(poll.x + 1, poll.y));
                sum++;
            }
            if( poll.x - 1 >= 0 && graph[poll.x - 1][poll.y] == 1 && !visited[poll.x - 1][poll.y] ){
                visited[poll.x - 1][poll.y] = true;
                queue.add(new Position(poll.x - 1, poll.y));
                sum++;
            }
            if( poll.y + 1 < graph.length && graph[poll.x][poll.y + 1] == 1 && !visited[poll.x][poll.y + 1] ){
                visited[poll.x][poll.y + 1] = true;
                queue.add(new Position(poll.x, poll.y + 1));
                sum++;
            }
            if( poll.y - 1 >= 0 && graph[poll.x][poll.y - 1] == 1 && !visited[poll.x][poll.y - 1] ){
                visited[poll.x][poll.y - 1] = true;
                queue.add(new Position(poll.x, poll.y - 1));
                sum++;
            }
        }
        answer.add(sum);
    }

    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Graph main = new Graph();

        int num = Integer.parseInt(br.readLine());
        int[][] graph = new int[num][num];

        for(int i = 0; i < num; i++){
            String[] str= br.readLine().split("");
            for(int j = 0; j < num; j++){
                graph[i][j] = Integer.parseInt(str[j]);
            }
        }
        boolean[][] dfsVisited = new boolean[graph.length][graph.length];
        boolean[][] bfsVisited = new boolean[graph.length][graph.length];

        main.dfs(graph, dfsVisited, bfsVisited, 0, 0);


        System.out.println(answer.size());
        Collections.sort(answer);
        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }
}

 */


//바이러스
public class Graph{
    static void bfs(int[][] graph, int edgeNum){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];

        int answer = 0;// 1번에 의해 감염된 것을 세야함
        graph[0][0] = 1;
        visited[0] = true;
        queue.add(0);

        while(!queue.isEmpty()){
            int x = queue.poll();
            for(int i = 1; i < graph.length; i ++){
                if(graph[x][i] == 1 && !visited[i] ){
                    visited[i] = true;
                    queue.add(i);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalNum = Integer.parseInt(br.readLine());
        int[][] graph = new int[totalNum][totalNum];
        int edgeNum = Integer.parseInt(br.readLine());

        for(int i = 0; i < edgeNum; i++){
            String[] split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]) - 1;
            int y = Integer.parseInt(split[1]) - 1;

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        bfs(graph, edgeNum);

    }
}