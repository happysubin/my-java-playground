package happysubin.javapractice.codingtest.programmers;

import java.util.*;

/*

public class Kakao {
    static public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for(int i = 0; i < moves.length; i++){
            for(int j = 0; j < board.length; j ++){
                if(board[j][moves[i] - 1] != 0){
                    if(stack.isEmpty()){
                        stack.push(board[j][moves[i]- 1]);
                    }
                    else{
                        if(stack.peek() == board[j][moves[i]-1] ){
                            stack.pop();
                            answer += 2;
                        }
                        else{
                            stack.push(board[j][moves[i]- 1]);
                        }
                    }

                    board[j][moves[i]-1]=0;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] arr = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] move = {1,5,3,5,1,2,1,4};

        System.out.println(solution(arr,move));

    }
}

 */

public class Kakao{

    static public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> map = new HashMap<>(); //해쉬 셋은 중복을 막는다.
        Map<String, Integer> reportMap = new HashMap<>();

        //초기화
        for(int i = 0; i < id_list.length; i++){
            map.put(id_list[i],new HashSet<>());
        }

        //신고를 넣은 사람이 key, 그 사람이 신고한 사람들 HashSet이 value
        for(int i = 0; i < report.length; i++ ) {
            String[] arr = report[i].split(" ");
            String reportingPerson = arr[0];
            String reportedPerson = arr[1];
            if (map.get(reportingPerson).add(reportedPerson)) { //HastSet을 사용해 중복이 불가, true면 처음 신고 당한 거
                reportMap.put(reportedPerson, reportMap.getOrDefault(reportedPerson, 0) + 1);
            }
        }

        for(int i = 0; i < report.length; i++){
            String[] arr = report[i].split(" ");
            String reportingPerson = arr[0];
            String reportedPerson = arr[1];
            if(reportMap.get(reportedPerson) < k){
                map.get(reportingPerson).remove(reportedPerson);
            }
        }

        for(int i = 0; i< id_list.length; i++){
            answer[i] = map.get(id_list[i]).size();
        }


        return answer;
    }

    public static void main(String[] args) {
        String[] idList = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] solution = solution(idList, report, k);

        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}