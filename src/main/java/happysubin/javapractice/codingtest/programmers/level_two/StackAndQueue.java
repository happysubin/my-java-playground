package happysubin.javapractice.codingtest.programmers.level_two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 프린터
 * public class StackAndQueue {
 *
 *     class Task{
 *         int priority;
 *         int location;
 *
 *         public Task(int priority, int location) {
 *             this.priority = priority;
 *             this.location = location;
 *         }
 *
 *         @Override
 *         public String toString() {
 *             return "Task{" +
 *                     "priority=" + priority +
 *                     ", location=" + location +
 *                     '}';
 *         }
 *     }
 *
 *     public int solution(int[] priorities, int location) {
 *         List<Task> list = new ArrayList<>();
 *         int cnt = 0;
 *
 *         for (int i = 0; i < priorities.length; i++) {
 *             list.add(new Task(priorities[i],i));
 *         }
 *
 *         while(!list.isEmpty()){
 *             Task poll = list.remove(0);
 *             boolean flag = false;
 *             for (int i = 0; i < list.size(); i++) {
 *                 if(poll.priority < list.get(i).priority) flag = true;
 *             }
 *
 *             if(flag == true){
 *                 list.add(poll);
 *             }
 *             else{
 *                 cnt++;
 *                 if(poll.location == location) return cnt;
 *             }
 *             flag = false;
 *         }
 *         return cnt;
 *     }
 *
 *     public static void main(String[] args) {
 *         StackAndQueue main = new StackAndQueue();
 *         int[] arr = {2, 1, 3, 2};
 *         int[] arr2 = {1, 1, 9, 1, 1, 1};
 *         int solution = main.solution(arr, 2);
 *         System.out.println(solution);
 *     }
 * }
 */
public class StackAndQueue {

    class Task{
        int priority;
        int location;

        public Task(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "priority=" + priority +
                    ", location=" + location +
                    '}';
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        return answer;
    }


    public static void main(String[] args) {
        StackAndQueue main = new StackAndQueue();
        int[] arr = {2, 1, 3, 2};
        int[] arr2 = {1, 1, 9, 1, 1, 1};
        //int solution = main.solution(arr, 2);
        //System.out.println(solution);
    }
}
