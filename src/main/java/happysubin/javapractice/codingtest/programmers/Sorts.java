package happysubin.javapractice.codingtest.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
