package happysubin.javapractice.zoomstudy.numberbaseball.v2;

import java.util.*;

public class Computer {

    private ArrayList<Integer> answer = new ArrayList<>(3);

    public void generateAnswer() {
        Random random = new Random();

        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; answer.size() < 3; i++) {
            int temp = random.nextInt(numbers.length);
            if (numbers[temp] != -1) {
                answer.add(numbers[temp]);
                numbers[temp] = -1;
            }
        }
    }

    //비교를 하는 메서드
    public Hint comparedWithAnswer(ArrayList<Integer> attemptedAnswer){
        int strikeCount = 0; //스트라이크 검사
        int ballCount = 0; //볼 검사

        for(int i = 0; i < 3; i++) {
            if (answer.get(i) == attemptedAnswer.get(i)){
                strikeCount++;
            }
            else if(answer.contains(attemptedAnswer.get(i)) & answer.get(i) != attemptedAnswer.get(i)){
                ballCount++;
            }
        }

        //힌트 생성해서 리턴
        Hint hint = Hint.createHint(strikeCount, ballCount);

        return hint;
    }

    //정답인가
    public boolean isNotAnswer(Hint hint){
        if(hint.getMessage().equals("ANSWER")) return false;
        else {
            System.out.println(hint.getMessage());
            return true;
        }
    }

    public ArrayList<Integer> getAnswer() {
        return answer;
    }
}
