package happysubin.javapractice.codingtest.programmers.java.level_three;

import java.util.*;

/**
 * 네트워크 BFS 방식
 */
import java.util.*;
class Solution {

    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        for(int i = 0; i < n; i++){ //1번 노드 부터 9번 노드까지는 일단 확인해야 함.
            if(visited[i] == false){ //방문한적이 없다면
                bfs(computers, visited, i); //그래프 색칠을 해준다.
                answer++;
            }
        }
        return answer;
    }

    private void bfs(int[][] computers, boolean[] visited, int start){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            for(int i = 0; i < computers.length; i++){
                //방문한적이 없고, 연결이 되어 있다면
                if(computers[poll][i] == 1 && visited[i] == false ){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}

/**
 * 네트워크 DFS 방식
 */
