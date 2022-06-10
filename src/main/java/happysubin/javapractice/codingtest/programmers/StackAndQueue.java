package happysubin.javapractice.codingtest.programmers;


import java.util.*;

public class StackAndQueue {
    class Process{
        int progressRate;
        int progressSpeed;


        public Process(int progressRate, int progressSpeed) {
            this.progressRate = progressRate;
            this.progressSpeed = progressSpeed;
        }
    }

    public int[] solution(int[] progresses, int[] speeds) {
        Map<Integer, Integer> result = new HashMap<>();
        Queue<Process> queue = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++){
            queue.offer(new Process(progresses[i], speeds[i]));
        }

        int count = 0;
        while(!queue.isEmpty()){
            Process poll = queue.peek();
            if(poll.progressRate + poll.progressSpeed * count < 100){
                count++;
            }
            else{
                queue.poll();
                result.put(count, result.getOrDefault(count, 0) + 1);
            }
        }

        int[] answer = new int[result.keySet().size()];
        ArrayList<Integer> keyset = new ArrayList<>(result.keySet());

        Collections.sort(keyset);

        int j = 0;
        for (Integer key : keyset) {
            answer[j++] =result.get(key);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] process = {93,30,55};
        int[] process1= {95, 90, 99, 99, 80, 99};


        int[] speed = {1, 30 ,5};
        int[] speed1= {1, 1, 1, 1, 1, 1};

        StackAndQueue main = new StackAndQueue();

        main.solution(process1, speed1);



    }

}
