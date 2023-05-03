package happysubin.javapractice.codingtest.programmers.java.level_two;

import java.util.*;
//소수찾기
class BruteForce {
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        //1. 문자열의 문자들을 문자열 배열로 만든다.
        String[] arr = numbers.split("");

        //2. 방문했는지 체크하는 배열
        boolean[] visited = new boolean[numbers.length()];

        //4. 숫자를 합친 경우를 탐색해야 한다.
        for(int i = 0; i < numbers.length(); i++){
            visited[i] = true;
            dfs(arr[i], arr, visited, 1);
            visited[i] = false;
        }
        return set.size();
    }

    private void dfs(String start, String[] arr,boolean[] visited, int cnt){

        int result = Integer.parseInt(start);

        for(int i = 2; i <= result; i++ ){
            if(result % i ==0){
                if(i != result){                        break;
                }
                else{
                    set.add(result);
                }
            }
        }

        for(int i = 0; i < arr.length; i++){
            if(visited[i] == false){
                visited[i] = true;
                dfs(start + arr[i], arr, visited, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
