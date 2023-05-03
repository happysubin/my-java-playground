package happysubin.javapractice.codingtest.programmers.java.level_three;

import java.util.*;

/**
 * 네트워크 BFS 방식
 */
import java.util.*;
//class Solution {
//
//    public int solution(int n, int[][] computers) {
//        boolean[] visited = new boolean[n];
//        int answer = 0;
//        for(int i = 0; i < n; i++){ //1번 노드 부터 9번 노드까지는 일단 확인해야 함.
//            if(visited[i] == false){ //방문한적이 없다면
//                bfs(computers, visited, i); //그래프 색칠을 해준다.
//                answer++;
//            }
//        }
//        return answer;
//    }
//
//    private void bfs(int[][] computers, boolean[] visited, int start){
//        Queue<Integer> queue = new LinkedList<>();
//
//        queue.add(start);
//        visited[start] = true;
//        while(!queue.isEmpty()){
//            Integer poll = queue.poll();
//            for(int i = 0; i < computers.length; i++){
//                //방문한적이 없고, 연결이 되어 있다면
//                if(computers[poll][i] == 1 && visited[i] == false ){
//                    queue.add(i);
//                    visited[i] = true;
//                }
//            }
//        }
//    }
//}

//단어 변환 DFS -> 올바른 풀이가 아닌듯.
//class BFSAndDFS {
//
//    static boolean[] visited;
//    static int answer = Integer.MAX_VALUE;
//
//    public int ladderLength(String beginWord, String endWord, List<String> wordList){
//        String[] words = new String[wordList.size()];
//        for(int i = 0; i < wordList.size(); i++){
//            words[i] = wordList.get(i);
//        }
//
//        visited = new boolean[words.length];
//        dfs(beginWord, endWord, words, 0);
//        if(answer == Integer.MAX_VALUE) return 0;
//        return answer;
//    }
//
//    private void dfs(String begin, String target, String[] words, int cnt){
//        //같다면 끝
//        if(begin.equals(target)){
//            answer = Math.min(answer, cnt + 1);
//        }
//        //더 많은 곳을 탐색하면 의미가 없다.
//        if(cnt == words.length - 1){
//            return;
//        }
//        for(int j = 0; j < words.length; j++){ //단어를 반복
//            String s = words[j];
//            String[] temp1 = s.split("");
//            String[] temp2 = begin.split("");
//            int check = 0;
//            int i = 0;
//            for(; i < temp1.length; i++){
//                if(!temp1[i].equals(temp2[i])){
//                    check++;
//                }
//            }
//            if(check == 1 && visited[j] == false){
//                visited[j] = true;
//                dfs(s, target, words, cnt + 1);
//                visited[j] = false;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        BFSAndDFS bfsAndDFS = new BFSAndDFS();
//        int i = bfsAndDFS.ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log"));
//        System.out.println("i = " + i);
//    }
//}

import java.util.*;
class Solution {

    class Count{
        String name;
        int count;
        public Count(String name, int count){
            this.name = name;
            this.count = count;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        boolean[] visited = new boolean[wordList.size()];
        Queue<Count> queue = new LinkedList<>();
        queue.add(new Count(beginWord, 1));

        while(!queue.isEmpty()){
            Count count = queue.poll(); //값을 꺼냄
            if(count.name.equals(endWord)){
                return count.count;
            }
            String[] str = count.name.split(""); //꺼낸 이름을 분리함.

            for(int i = 0; i< wordList.size(); i++){ // 모든 단어를 가져와서 꺼낸 값과 비교해야함
                String word = wordList.get(i);
                String[] s = word.split(""); //들어온 단어 분리
                int cnt = 0;
                int j = 0;
                for(; j < str.length; j++){
                    if(!str[j].equals(s[j])){ //1개만 차이가나는지 비교
                        cnt++;
                    }
                }
                if(cnt == 1 && visited[i] == false){
                    visited[i] = true;
                    queue.add(new Count(word, count.count + 1));
                }
            }
        }
        return 0;
    }
}