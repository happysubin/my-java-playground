package happysubin.javapractice.lab.datastructure;

import java.util.*;

public class Stack {

    //제일 최근 들어온 것 이외에 모든 요소를 저장하는 저장소.
    private Queue<String> storage = new LinkedList<>();

    // 제일 최근에 들어온 것을 보관하는 저장소.
    private Queue<String> pickUpPoint = new LinkedList<>();

    public void push(String... element) {

        if(pickUpPoint.size() == 1) {
            String poll = pickUpPoint.poll();
            storage.offer(poll);
        }

        for (int i = 0; i < element.length - 1; i++) {
            storage.offer(element[i]);
        }

        String lastElement = element[element.length - 1];

        pickUpPoint.offer(lastElement);
    }

    public String pop() {

        String result = pickUpPoint.poll();

        if(result == null) {
            throw new RuntimeException("스택이 비었습니다.");
        }

        //요소가 없다면 pickUpPoint로 넘길 필요가 없다.
        if(storage.size() == 0 ) {
            return result;
        }

        //요소가 남아있다면 제일 최근에 들어온 요소를 pickUpPoint로 넘겨야함
        switchStorageAndPickUpPoint();

        return result;
    }

    private void switchStorageAndPickUpPoint() {

        Queue<String> temp = new LinkedList();

        while(true){
            if (storage.size() == 1) break;
            String poll = storage.poll();
            temp.offer(poll);
        }

        String poll = storage.poll();
        pickUpPoint.offer(poll);

        //temp에 옮겨 놓은 것을 모두 옮긴다.
        while(!temp.isEmpty()) {
            String tempPoll = temp.poll();
            storage.offer(tempPoll);
        }
    }
}
