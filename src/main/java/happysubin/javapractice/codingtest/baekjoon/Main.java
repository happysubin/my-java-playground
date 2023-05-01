import java.util.*;
import java.io.*;

//바이러스
//public class Main{
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int node = Integer.parseInt(br.readLine());
//        int edge = Integer.parseInt(br.readLine());
//        int[][] graph = new int[node][node];
//        boolean[] visited = new boolean[node];
//
//        for(int i = 0; i < edge; i++){
//            String[] str = br.readLine().split(" ");
//            int x = Integer.parseInt(str[0]) - 1;
//            int y = Integer.parseInt(str[1]) - 1;
//            graph[x][y] = 1;
//            graph[y][x] = 1;
//        }
//
//        //bfs 시작
//        visited[0] = true;
//        Queue<Integer> queue = new LinkedList<>();
//        graph[0][0] = 1;
//        queue.add(0);
//        int cnt = 0;
//        while(!queue.isEmpty()){
//            Integer poll = queue.poll();
//            for(int i = 0; i < node; i++){
//                if(visited[i] == false && graph[poll][i] == 1){
//                    visited[i] = true;
//                    queue.add(i);
//                    cnt++;
//                }
//            }
//        }
//        bw.write(String.valueOf(cnt));
//        bw.flush();
//    }
//}

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine()); //지도 길이
        int[][] map = new int[size][size]; //전체 지도
        boolean[][] visited = new boolean[size][size]; //방문 추적
        int answer = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < size; i++){
            String[] temp = br.readLine().split("");
            for(int j = 0; j < temp.length; j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        //초기화 끝
        //1번부터 출발해야함.

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(map[i][j] == 1 & visited[i][j] == false){
                    int num = bfs(map, visited, i ,j);
                    result.add(num);
                    answer++;
                }
            }
        }

        Collections.sort(result);
        bw.write(String.valueOf(answer) + "\n");
        for(Integer s : result){
            bw.write(String.valueOf(s) + "\n");
        }
        bw.flush();
    }

    static private int bfs(int[][] map, boolean[][] visited, int x, int y){
        int count = 0;
        Queue<Position> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new Position(x, y));

        while(!queue.isEmpty()){
            Position poll = queue.poll();
            count++;
            int tx = poll.x;
            int ty = poll.y;
            visited[tx][ty] = true;

            //위쪽
            if(tx + 1 < map.length && map[tx + 1][ty] == 1 && visited[tx + 1][ty] ==false){
                queue.add(new Position(tx + 1, ty));
            }
            //오른쪽
            if(ty + 1 < map.length && map[tx][ty + 1] == 1 && visited[tx][ty + 1] ==false){
                queue.add(new Position(tx, ty + 1));
            }
            //아래쪽
            if(tx - 1 >= 0 && map[tx - 1][ty] == 1 && visited[tx - 1][ty] ==false){
                queue.add(new Position(tx - 1, ty));
            }
            //왼쪽
            if(ty - 1 >= 0 && map[tx][ty - 1] == 1 && visited[tx][ty - 1] ==false){
                queue.add(new Position(tx, ty - 1));
            }
        }
        return count;
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