package happysubin.javapractice.codingtest.programmers.java;

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

/*

//가장 큰 수
public class Sorts{

    public String solution(int[] numbers) {
        List<String> arr = new ArrayList<>();
        String answer = "";

        for (int number : numbers) {
            arr.add(String.valueOf(number));
        }

        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if(arr.get(0).equals("0")) {
            return "0";
        }

        for (String s1 : arr) {
            answer += s1;
        }


        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {100 , 1000};
        int[] arr2 = {3, 30, 34, 5, 9};
        Sorts main = new Sorts();
        String solution = main.solution(arr);

        String str1 = "1";
        String str2 = "9";
        System.out.println(str1.compareTo(str2));
        System.out.println("solution = " + solution);
    }
}

 */

public class Sorts{

    /**
     * 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
     *
     * 이 과학자가 발표한 논문의 수는 5편이고,
     * 그중 3편의 논문은 3회 이상 인용되었습니다.
     * 그리고 나머지 2편의 논문은 3회 이하 인용되었기 때문에 이 과학자의 H-Index는 3입니다.
     */

    public int solution(int[] citations) {

        return 0;
    }

    public static void main(String[] args) {

    }
}