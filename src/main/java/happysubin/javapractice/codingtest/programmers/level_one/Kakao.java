package happysubin.javapractice.codingtest.programmers.level_one;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//성격 유형 검사

/**
 * public class Kakao {
 *
 *     public String solution(String[] survey, int[] choices) {
 *         int[] scores = {0, 3, 2, 1, 0, 1, 2, 3};
 *         Map<String, Integer> map = new HashMap<>();
 *
 *         //map 생성
 *         map.put("R", 0);
 *         map.put("T", 0);
 *         map.put("C", 0);
 *         map.put("F", 0);
 *         map.put("J", 0);
 *         map.put("M", 0);
 *         map.put("A", 0);
 *         map.put("N", 0);
 *
 *
 *         for (int i = 0; i < survey.length; i++) {
 *             String[] split = survey[i].split("");
 *             if(choices[i] < 4){
 *                 map.put(split[0], map.get(split[0]) + scores[choices[i]]);
 *             }
 *             else if(choices[i] > 4){
 *                 map.put(split[1], map.get(split[1]) + scores[choices[i]]);
 *             }
 *         }
 *
 *         String answer = "";
 *         if(map.get("R") >= map.get("T")){
 *             answer += "R";
 *         }
 *         else {
 *             answer += "T";
 *         }
 *
 *         if(map.get("C") >= map.get("F")){
 *             answer += "C";
 *         }
 *         else {
 *             answer += "F";
 *         }
 *
 *         if(map.get("J") >= map.get("M")){
 *             answer += "J";
 *         }
 *         else {
 *             answer += "M";
 *         }
 *
 *         if(map.get("A") >= map.get("N")){
 *             answer += "A";
 *         }
 *         else {
 *             answer += "N";
 *         }
 *
 *
 *         return answer;
 *     }
 *
 *     public static void main(String[] args) {
 *
 *         String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
 *         int[] choices = {5, 3, 2, 7, 5};
 *
 *         Kakao kakao = new Kakao();
 *         String solution = kakao.solution(survey, choices);
 *         System.out.println("solution = " + solution);
 *     }
 * }
 */

public class Kakao {

    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[j][moves[i] - 1] != 0){
                    if(stack.size() != 0 && stack.peek() == board[j][moves[i] - 1] ){
                        answer += 2;
                        stack.pop();
                        board[j][moves[i] - 1] = 0;
                    }
                    else{
                        stack.add(board[j][moves[i] - 1]);
                        board[j][moves[i] - 1] = 0;
                    }
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        int[][] arr = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};

        int[] moves = {1,5,3,5,1,2,1,4};

        Kakao kakao = new Kakao();
        int solution = kakao.solution(arr, moves);
        System.out.println("solution = " + solution);
    }
}
