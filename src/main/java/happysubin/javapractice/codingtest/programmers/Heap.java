package happysubin.javapractice.codingtest.programmers;


import java.util.*;

public class Heap {

    static public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i : scoville) {
            queue.add(i);
        }

        while(true){
            if(queue.peek() < K){
                int min = queue.poll();
                if(queue.peek() == null){
                    answer = -1;
                    break;
                }
                int nextMin = queue.poll();
                queue.add(min + (nextMin * 2));
                answer++;
            }
            else break;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 9, 10, 12};
        int k = 7;
        System.out.println(solution(arr,k));

    }
}
