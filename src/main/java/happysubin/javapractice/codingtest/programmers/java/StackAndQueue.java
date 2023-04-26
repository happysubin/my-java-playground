package happysubin.javapractice.codingtest.programmers.java;


import java.util.*;

/*
//기능 개발

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


 */

//프린터 dd
/*
public class StackAndQueue {
    class Element{
        int rank;
        boolean target;

        public Element(int rank, boolean target) {
            this.rank = rank;
            this.target = target;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayList<Element> list = new ArrayList<>();

        for(int i = 0 ; i < priorities.length; i++){
            if(i == location) list.add(new Element(priorities[i], true));
            else list.add(new Element(priorities[i], false));
        }

        while(list.size() > 0){
            int count = 0;
            for (int i = 0 ; i < list.size(); i++) {
                if(list.get(i).rank <= list.get(0).rank){
                    count++;
                }
                else break;
            }
            if(count == list.size()){
                Element remove = list.remove(0);
                answer ++;
                if(remove.target == true){
                    break;
                }
            }
            else{
                Element remove = list.remove(0);
                list.add(remove);
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int[] priorities= {2, 1, 3, 2};
        int[] priorities1= {1, 1, 9, 1, 1, 1};
        int num = 2;
        StackAndQueue main = new StackAndQueue();

        System.out.println(main.solution(priorities1,0));


    }

}
 */

/**
 * public class StackAndQueue {
 *
 *     public int[] solution(int []arr) {
 *         Queue<Integer> queue = new LinkedList<>();
 *         List<Integer> list = new ArrayList<>();
 *         for (int i : arr) {
 *             if(queue.isEmpty()){
 *                 queue.offer(i);
 *             }
 *             else if(queue.peek() == i){
 *                 continue;
 *             }
 *             else{
 *                 list.add(queue.poll());
 *                 queue.offer(i);
 *             }
 *         }
 *
 *         while(!queue.isEmpty()){
 *             list.add(queue.poll());
 *         }
 *
 *         int[] answer = new int[list.size()];
 *         int i = 0;
 *         for (Integer integer : list) {
 *             answer[i++] = integer;
 *         }
 *
 *         return answer;
 *     }
 *
 *
 *     public static void main(String[] args) {
 *         int[] priorities1= {1,1,3,3,0,1,1};
 *         StackAndQueue main = new StackAndQueue();
 *         System.out.println(main.solution(priorities1));
 *     }
 *
 * }
 */

public class StackAndQueue {

    boolean solution(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char str : chars){
            if(str ==  '('){
                stack.add(str);
            }
            else if(str == ')') {
                if(stack.size()>0) stack.pop();
                else return false; // ")"이면 false다.
            }
        }

        if(stack.size() > 0) return false;
        return true;
    }


    public static void main(String[] args) {
        String str = "()()";
        StackAndQueue main = new StackAndQueue();
        System.out.println(main.solution(str));
    }

}