package happysubin.javapractice.codingtest.programmers;

import java.util.*;


/*

k번째 수
public class Sorts {
    static public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0 ; i < commands.length; i++){
            int first = commands[i][0];
            int last = commands[i][1];
            int target = commands[i][2];
            int[] arr = new int[last - first + 1]; //정렬할 배열
            for(int j = 0 ; j < last - first + 1; j++){
                arr[j] = array[first - 1 + j];
            }
            Arrays.sort(arr);
            answer[i] = arr[target - 1];
        }
        return answer;
    }


        static public int[] solution2(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            for(int i=0; i<commands.length; i++){
                int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
                Arrays.sort(temp);
                answer[i] = temp[commands[i][2]-1];
            }
            return answer;
        }



    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(solution(array,commands));

    }
}


 */

public class Sorts {

    public String solution(int[] numbers) {
        List<String> arr = new ArrayList<>();
        for (int number : numbers) {
            arr.add(String.valueOf(number));
        }

        Collections.sort(arr, Collections.reverseOrder());

        String answer = arr.get(0);

        for(int i = 1; i < arr.size() - 1 ; i++){
            String now = arr.get(i);
            String next = arr.get(i + 1);
            if(now.length() == next.length()){
                answer = answer;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        int[] arr = {104 , 1};
        int[] arr2 = {3, 30, 34, 5, 9};
        Sorts main = new Sorts();
        String solution = main.solution(arr2);
        System.out.println("solution = " + solution);
    }
}