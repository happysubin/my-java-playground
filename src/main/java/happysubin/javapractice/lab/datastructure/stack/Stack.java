package happysubin.javapractice.lab.datastructure.stack;

import java.util.*;

public class Stack {

    private Queue<String> temp = new LinkedList<>();

    private Queue<String> main = new LinkedList<>();

    public void push(String... element) {
        for (String e : element) {
            main.offer(e);
        }
    }

    public String pop() {

        if(main.size() == 0) {
            throw new RuntimeException("스택이 비었습니다.");
        }

        while(true){
            if (this.main.size() == 1) break;
            String poll = this.main.poll();
            temp.offer(poll);
        }

        //제일 최근에 들어온 것을 pickUpPoint로 이전
        String poll = this.main.poll();

        //temp에 옮겨 놓은 것을 모두 옮긴다.
        while(!temp.isEmpty()) {
            String tempPoll = temp.poll();
            this.main.offer(tempPoll);
        }

        return poll;
    }
}
