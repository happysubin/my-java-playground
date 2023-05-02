package happysubin.javapractice.codingtest.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//public class BFS {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int totalNode = sc.nextInt();
//        int totalEdge = sc.nextInt();
//        int startNode = sc.nextInt();
//        int[][] graph = new int[totalNode + 1][totalNode + 1];
//        for(int i = 0; i < totalEdge; i++){
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            graph[x][y] = 1;
//        }
//
//        //dfs
//        int[] dfsCheck = new int[graph.length];
//        dfs(graph, dfsCheck, startNode);
//        System.out.println();
//        //bfs
//        bfs(graph, totalNode, startNode);
//    }
//
//    private static void dfs(int[][] graph, int[] dfsCheck, int startNode){
////        dfsCheck[startNode] = 1;
////        System.out.print(startNode + " ");
////        for (int i = 1; i <= graph.length - 1; i++) {
////            if(graph[startNode][i] == 1 & dfsCheck[i] != 1){
////                dfs(graph, dfsCheck, i);
////            }
////        }
//        dfsCheck[startNode]  = 1;
//        System.out.print(startNode + " ");
//
//        for(int i = 1; i <= graph.length - 1; i++){
//            if(graph[startNode][i] == 1 & dfsCheck[i] != 1){
//                dfs(graph, dfsCheck, i);
//            }
//        }
//    }
//
//    private static void bfs(int[][] graph, int totalNode, int startNode) {
//        Queue<Integer> queue = new LinkedList<>();
//        int[] bfsCheck = new int[totalNode + 1];
//        queue.add(startNode);
//        bfsCheck[startNode] = 1;
//        while(!queue.isEmpty()){
//            Integer poll = queue.poll();
//            System.out.print(poll + " ");
//            for (int i = 1; i <= graph.length - 1; i++) {
//                if(graph[poll][i] == 1 & bfsCheck[i] != 1){
//                    bfsCheck[i] = 1;
//                    queue.add(i);
//                }
//            }
//        }
//    }
//}

import java.io.*;
import java.util.*;

class BFS{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int total = Integer.parseInt(br.readLine()); //전체 케이스

        for(int i = 0; i < total; i++){
            String[] arr = br.readLine().split(" "); //파싱
            int m = Integer.parseInt(arr[1]);
            int n = Integer.parseInt(arr[0]);
            int[][] map = new int[m][n]; //전체 배추 지도
            boolean[][] visited = new boolean[m][n]; //방문 추적
            int cabbage = Integer.parseInt(arr[2]); //배추 총 개수
            for(int j = 0; j < cabbage; j++){
                String[] po = br.readLine().split(" ");
                map[Integer.parseInt(po[1])][Integer.parseInt(po[0])] = 1; //초기화를 시킨다.
            }
            //로직 시작
            int answer = 0;
            for(int j = 0; j < m; j++){
                for(int z = 0; z < n; z++){
                    if(map[j][z] == 1 && visited[j][z] == false){
                        answer ++;
                        bfs(map, visited, j, z);
                    }
                }
            }
            bw.write(String.valueOf(answer) + "\n");
        }
        bw.flush();
    }

    static void bfs(int[][] map, boolean[][] visited, int m, int n){
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(m,n));
        visited[m][n] = true;
        while(!queue.isEmpty()){
            Position poll = queue.poll();
            int x = poll.x;
            int y = poll.y;
            int[] xArr = {1, -1, 0, 0};
            int[] yArr = {0, 0, 1, -1};
            for(int i = 0; i < 4; i++){
                if(x + xArr[i] >= 0 & x + xArr[i] < visited.length & y + yArr[i] >=0 & y + yArr[i] < map[0].length){
                    int tempX = x + xArr[i];
                    int tempY = y + yArr[i];
                    if(visited[tempX][tempY] == false && map[tempX][tempY] == 1){
                        queue.add(new Position(tempX, tempY));
                        visited[tempX][tempY] = true;
                    }
                }
            }
        }
    }

    static class Position{
        int x;
        int y;

        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}