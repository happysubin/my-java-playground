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