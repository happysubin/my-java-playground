package happysubin.javapractice.lab.datastructure.queue;

import java.util.Stack;

public class Queue {

    private Stack<String> pushPlace = new Stack<>();
    private Stack<String> popPlace = new Stack<>();


    public void offer(String... elements) {
        for (String element : elements) {
            pushPlace.push(element);
        }
    }

    public String poll() {

        if(popPlace.isEmpty()) {
            while(!pushPlace.isEmpty()) {
                String pop = pushPlace.pop();
                popPlace.push(pop);
            }
        }

        if(popPlace.isEmpty()) {
            throw new RuntimeException("큐가 비었습니다.");
        }

        return popPlace.pop();
    }

}
