package happysubin.javapractice.codingtest.programmers.java.level_three;

import java.util.*;

public class Heap {

    class Task implements Comparable<Task>{

        private int start;
        private int workTime;

        public Task(int start, int workTime) {
            this.start = start;
            this.workTime = workTime;
        }


        @Override
        public int compareTo(Task o) {
            if(o.start == this.start) return this.workTime - o.workTime;
            else return this.start - o.start;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "start=" + start +
                    ", workTime=" + workTime +
                    '}';
        }
    }

    public int solution(int[][] jobs) {

        List<Task> list = new ArrayList<>();
        for (int[] job : jobs) {
            list.add(new Task(job[0], job[1]));
        }
        Collections.sort(list); //정렬함.

        int time = 0;
        int answer = 0;
        while(!list.isEmpty()){
            int min = 2000;
            int idx = -1;
            for (int i = 0; i < list.size(); i++) {
                Task task = list.get(i);
                if(task.start <= time){ //현재 시간보다 작은 것. 즉 도착한 것이여야 한다.
                    if(task.workTime < min){ //도착한 것 중 제일 작은걸 실행해야함.
                        min = task.workTime;
                        idx = i;
                    }
                }
                else break;
            }

            if(idx == -1){ //현재 시간보다 뒤에 있으면 그냥 시간을 올림
                time++;
            }
            else{ //수행한 태스크가 있는 경우 이를 반영함
                Task remove = list.remove(idx);
                time += remove.workTime;
                answer += time - remove.start;
            }
        }
        return answer / jobs.length;
    }

    public static void main(String[] args) {
        int [][] arr = {{0, 3}, {1, 9}, {2, 6}};
        Heap heap = new Heap();
        int solution = heap.solution(arr);
        System.out.println("solution = " + solution);
    }
}
