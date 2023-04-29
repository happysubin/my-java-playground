package happysubin.javapractice.codingtest.programmers.java.level_two;

import java.util.LinkedList;
import java.util.Queue;

/**타겟 넘버
 * public class DFSAndBFS {
 *
 *     static int answer = 0;
 *     static int goal = 0;
 *
 *     private void dfs(int[] numbers, int[] ch, int cnt){
 *         if(cnt == ch.length - 1){
 *             int sum = 0;
 *             for (int i = 0; i < ch.length; i++) {
 *                 if(ch[i] == 0){
 *                     sum += numbers[i];
 *                 }
 *                 else{
 *                     sum -= numbers[i];
 *                 }
 *             }
 *             if(sum == goal) answer++;
 *         }
 *         else{
 *             cnt++;
 *             ch[cnt] = 1;
 *             dfs(numbers, ch, cnt);
 *             ch[cnt] = 0;
 *             dfs(numbers, ch, cnt);
 *         }
 *     }
 *
 *     public int solution(int[] numbers, int target) {
 *         goal = target;
 *         int[] ch = new int[numbers.length];
 *         dfs(numbers, ch, -1);
 *         return answer;
 *     }
 *
 *     public static void main(String[] args) {
 *         int[] arr = {1,1,1,1,1};
 *         DFSAndBFS main = new DFSAndBFS();
 *         main.solution(arr, 3);
 *         System.out.println("answer = " + answer);
 *     }
 * }
 */



public class DFSAndBFS {

    class Position{
        int i;
        int j;
        int cnt;

        public Position(int i, int j, int cnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }
    }

    public int solution(int[][] maps) {
        Queue<Position> queue = new LinkedList<>();
        int[][] arr = new int[maps.length][maps[0].length];
        arr[0][0] = 1;
        queue.offer(new Position(0,0, 1));

        while(!queue.isEmpty()){
            Position poll = queue.poll();
            if(poll.i == maps.length - 1 && poll.j == maps[0].length - 1){
                return poll.cnt;
            }
            else{
                int i = poll.i;
                int j = poll.j;
                int cnt = poll.cnt;
                if(i + 1 < maps.length && i + 1 >= 0 && arr[i + 1][j] != 1 && maps[i + 1][j] == 1){
                    arr[i + 1][j] = 1;
                    queue.offer(new Position(i + 1, j , cnt + 1));
                }
                if(j + 1 < maps[0].length && j + 1 >= 0 && arr[i][j + 1] != 1 && maps[i][j + 1] == 1){
                    arr[i][j + 1] = 1;
                    queue.offer(new Position(i, j + 1, cnt + 1));
                }

                if(i - 1 >= 0 && i - 1 < maps.length && arr[i - 1][j] != 1 && maps[i - 1][j] == 1){
                    arr[i - 1][j] = 1;
                    queue.offer(new Position(i - 1, j , cnt + 1));
                }
                if(j -1 >= 0 && j - 1 < maps[0].length && arr[i][j - 1] != 1 && maps[i][j - 1] == 1){
                    arr[i][j - 1] = 1;
                    queue.offer(new Position(i, j - 1, cnt + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int[][] arr2 = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,0,1},
                {1,0,1,0,1},
                {1,1,1,0,1}
        };

        DFSAndBFS main = new DFSAndBFS();
        int solution = main.solution(arr2);
        System.out.println(solution);
    }
}

/** 타겟 넘버
 * class Solution {
 *     private static int goal = 0;
 *
 *     private static void dfs(int[] numbers, int target, boolean[] check, int level){
 *         if(level == check.length - 1){
 *             int cnt = 0;
 *             int sum = 0;
 *             for(int i = 0; i < numbers.length; i++){
 *                 if(check[i] == true){
 *                     sum += numbers[i];
 *                 }
 *                 else{
 *                     sum -= numbers[i];
 *                 }
 *
 *             }
 *             if(sum == target) goal++;
 *         }
 *         else{
 *             level++;
 *             check[level] = false;
 *             dfs(numbers, target, check, level);
 *             check[level] = true;
 *             dfs(numbers, target, check, level);
 *         }
 *     }
 *
 *
 *     public int solution(int[] numbers, int target) {
 *         boolean[] check = new boolean[numbers.length];
 *         dfs(numbers, target, check, -1);
 *         return goal;
 *     }
 * }
 */