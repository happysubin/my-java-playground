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

/** 다리를 지나는 트럭
 * public class StackAndQueue {
 *
 *     class Bridge{
 *         int len;
 *         int limitWeight;
 *         int nowWeight = 0;
 *         List<Truck> trucks = new ArrayList<>();
 *
 *         public Bridge(int len, int weight) {
 *             this.len = len;
 *             this.limitWeight = weight;
 *         }
 *     }
 *
 *     class Truck{
 *         int dis;
 *         int weight;
 *
 *         public Truck(int dis, int weight) {
 *             this.dis = dis;
 *             this.weight = weight;
 *         }
 *     }
 *
 *     public int solution(int bridge_length, int weight, int[] truck_weights) {
 *         Bridge bridge = new Bridge(bridge_length, weight);
 *         List<Truck> trucks = new ArrayList<>();
 *         int time = 1;
 *
 *         for (int truck_weight : truck_weights) {
 *             trucks.add(new Truck(0, truck_weight));
 *         }
 *
 *         Truck remove = trucks.remove(0);
 *         bridge.trucks.add(remove);
 *         bridge.nowWeight += remove.weight;
 *
 *         while(!bridge.trucks.isEmpty()){
 *
 *             for (Truck truck : bridge.trucks) {
 *                 truck.dis++;
 *             }
 *
 *             Truck truck = bridge.trucks.get(0);
 *
 *             if(truck.dis == bridge.len){
 *                 bridge.trucks.remove(truck);
 *                 bridge.nowWeight -= truck.weight;
 *             }
 *
 *             if(trucks.size() > 0 && bridge.limitWeight >= bridge.nowWeight + trucks.get(0).weight){
 *                 Truck newTruck = trucks.remove(0);
 *                 bridge.trucks.add(newTruck);
 *                 bridge.nowWeight += newTruck.weight;
 *             }
 *             time++;
 *         }
 *
 *         return time;
 *     }
 *
 *
 *     public static void main(String[] args) {
 *         StackAndQueue main = new StackAndQueue();
 *         int[] arr = {7,4,5,6};
 *         int[] arr2 = {10,10,10,10,10,10,10,10,10,10};
 *         int solution = main.solution(100, 100, arr2);
 *         System.out.println("solution = " + solution);
 *     }
 * }
 */
public class StackAndQueue {

    public int[] solution(int[] prices) {
        int[] answer = {};

        return answer;
    }




    public static void main(String[] args) {
        StackAndQueue main = new StackAndQueue();
        int[] arr = {1, 2, 3, 2, 3};
        int[] solution = main.solution(arr);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
