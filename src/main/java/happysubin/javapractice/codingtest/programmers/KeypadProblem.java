package happysubin.javapractice.codingtest.programmers;

import java.util.*;


class ProblemSolution{
    public String solution(int[] numbers, String hand) {
        String answer = "";

        String leftHandLocation = "*";
        String rightHandLocation = "#";

        for(int i=0; i < numbers.length; i++){
            if(numbers[i] % 3 == 1 ){
                answer +="L";
                leftHandLocation = String.valueOf(numbers[i]);
            }
            else if(numbers[i] % 3 == 0){
                answer +="R";
                rightHandLocation = String.valueOf(numbers[i]);
            }
            else{ // 2 5 8 0
                //아무것도 안 누른 경우 주 손잡이를 사용

                //자리가 동일한 경우 주 손잡이를 사용

                //자리가 멀 경우 가까운 손을 사용
            }
        }



        return answer;
    }

    //TODO 거리를 찾는 함수를 만들어야 한다.
    public int calculateDistance(String nowLocation,String hand){
        String[][] keypad = new String[][]{ {"1","2","3"},
                                            {"4","5","6"},
                                            {"7","8","9"},
                                            {"*","0","#"}};
        if(hand.equals("left")){

        }
        else{

        }

        return 0;
    }

}

public class KeypadProblem {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i = 0; i < num; i++){
            arr[i] = sc.nextInt();
        }


        ProblemSolution solution = new ProblemSolution();
        String answer = solution.solution(arr,"left");

        System.out.println("answer = " + answer);

    }

}
