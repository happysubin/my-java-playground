package happysubin.javapractice.codingtest.programmers;

/*

 더맵게
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


 */

import java.util.*;

public class Heap {

    class Disk implements Comparable<Disk>{
        int start;
        int end;

        public Disk(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Disk o) {
            return 0;
        }

        @Override
        public String toString() {
            return "Disk{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;
        ArrayList<Disk> list = new ArrayList<>();
        for(int i = 0; i < jobs.length; i++){
            list.add(new Disk(jobs[i][0],jobs[i][1]));
        }

        for (Disk disk : list) {
            System.out.println(disk.toString());
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 3}, {1, 9}, {2, 6}};
        Heap heap = new Heap();
        System.out.println(heap.solution(arr));

    }
}
