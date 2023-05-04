package happysubin.javapractice.codingtest.programmers.java.level_two;

import java.io.*;
import java.util.*;

//소수기
//class BruteForce {
//    Set<Integer> set = new HashSet<>();
//    public int solution(String numbers) {
//        //1. 문자열의 문자들을 문자열 배열로 만든다.
//        String[] arr = numbers.split("");
//
//        //2. 방문했는지 체크하는 배열
//        boolean[] visited = new boolean[numbers.length()];
//
//        //4. 숫자를 합친 경우를 탐색해야 한다.
//        for(int i = 0; i < numbers.length(); i++){
//            visited[i] = true;
//            dfs(arr[i], arr, visited, 1);
//            visited[i] = false;
//        }
//        return set.size();
//    }
//
//    private void dfs(String start, String[] arr,boolean[] visited, int cnt){
//
//        int result = Integer.parseInt(start);
//
//        for(int i = 2; i <= result; i++ ){
//            if(result % i ==0){
//                if(i != result){
//                    break;
//                }
//                else{
//                    set.add(result);
//                }
//            }
//        }
//
//        for(int i = 0; i < arr.length; i++){
//            if(visited[i] == false){
//                visited[i] = true;
//                dfs(start + arr[i], arr, visited, cnt + 1);
//                visited[i] = false;
//            }
//        }
//    }
//}

//카펫
class BruteForce {
    public int[] solution(int brown, int yellow) {
        int ansB = 0;
        int ansY = 0;

        //1. 세로 블럭만 남겨 놓음. 모서리랑 가로 제외.
        int h = 1; //

        //2. 가로 블럭만 남겨놓음. 모서리랑 세로 제외.
        int w = (brown  - 4 - 2) / 2;

        while(w > 0){ //가로가 0보다 커야지?
            if((w * h) == yellow){ //
                ansB = w + 2;
                ansY = h + 2;
                break;
            }
            else{
                h++; //세로에 블럭 2개가 추가되니
                w--; //가로라인 블럭 2개 삭제
            }
        }
        return new int[]{ansB, ansY};
    }
}


// 모음 사전
class BruteForce1 {
    List<String> list = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        String[] words = {"A", "E", "I", "O", "U"};

        for(int i = 0; i < words.length ; i++){
            list.add(words[i]);
            dfs(words, words[i]);
        }

        Collections.sort(list);

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(word)){
                answer = i + 1;
                break;
            }
        }


        return answer;
    }

    private void dfs(String[] words, String word){
        if(word.length() == words.length) return;

        for(int i = 0; i < words.length; i++){
            list.add(word + words[i]); // A와 A를 더함.
            dfs(words, word + words[i]);
        }
    }
}


class BruteForce2 {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < wires.length; i++){ //총 모든 노드를 1번씩 끊어봐야 한다.
            int[][] arr = new int[n + 1][n + 1]; //1개를 끊을 노드를 담을 임시 그래프 배열.
            int temp1 = 0;
            for(int j = 0; j < wires.length; j++){ //wires를 순회해야 한다.
                if(i != j){
                    int from = wires[j][0];
                    int to = wires[j][1];
                    arr[from][to] = 1;
                    arr[to][from] = 1;
                    temp1 = from;
                }
            }
            //1개의 노드를 끊은 트리가 완성됨. 이제 트리 2개를 비교해서 빼면 된다.
            //생각해보면 2개의 노드이므로 1번만 탐색하고 n개에서 1번 탐색한 값을 빼면 될 거 같다.
            int n1 = check(arr, temp1); //마지막 값을 넣어서 어떻게든 1개의 네트워크를 포함된 값을 구한다.
            int n2 = n - n1;
            answer = Math.min(answer, Math.abs(n2- n1));
        }
        return answer;
    }

    private int check(int[][] arr, int x){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];// 추적 배열
        visited[x] = true;
        queue.add(x);
        int cnt = 1;
        while(!queue.isEmpty()){
            int poll = queue.poll();
            for(int i = 1; i < arr.length; i++){
                if(visited[i] == false & arr[poll][i] == 1){
                    visited[i] = true;
                    cnt++;
                    queue.add(i);
                }
            }
        }
        return cnt;
    }
}