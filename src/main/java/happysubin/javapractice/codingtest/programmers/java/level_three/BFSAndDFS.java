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

//단어 변환
class Solution {
    static boolean[] visited;
    static int answer = 0;

    public int solution(String begin, String target, String[] words) {
        //추적 값
        visited = new boolean[words.length];
        int cnt = 0;

        dfs(begin, target, words, cnt);
        return answer;
    }

    private void dfs(String begin, String target, String[] words, int cnt){
        //같다면 끝
        if(begin.equals(target)){
            answer = cnt;
            return;
        }
        //더 많은 곳을 탐색하면 의미가 없다.
        if(cnt >= words.length - 1){
            return;
        }
        for(int j = 0; j < words.length; j++){ //단어를 반복
            String s = words[j];
            String[] temp1 = s.split("");
            String[] temp2 = begin.split("");
            int check = 0;
            int i = 0;
            for(; i < temp1.length; i++){
                if(!temp1[i].equals(temp2[i])){
                    check++;
                }
            }
            if(check == 1 && visited[j] == false){
                visited[j] = true;
                dfs(s, target, words, cnt + 1);
                visited[j] = false; //이걸 안해서 고생함.
            }

        }

    }
}
