package happysubin.javapractice.codingtest.programmers.java.level_one;

import java.util.*;

//K번째수
//class Sort {
//    public int[] solution(int[] array, int[][] commands) {
//        int[] answer = new int[commands.length];
//        int cnt = 0;
//        int cnt2 = 0;
//        for(int i = 0; i < commands.length; i++){
//            int[] tmp = new int[commands[i][1] - commands[i][0] + 1];
//            for(int j = commands[i][0] - 1; j <= commands[i][1] - 1; j++){
//                tmp[cnt++] = array[j];
//            }
//            cnt = 0;
//            Arrays.sort(tmp);
//            answer[cnt2++] = tmp[commands[i][2] - 1];
//        }
//        return answer;
//    }
//}

//H-Index
class Sort {
    public int solution(int[] citations) {
        int answer = 0;
        for(int i = 1; i < 10000; i++){
            int count = 0;
            for(int j = 0; j < citations.length; j++){
                if(citations[j] >= i) count++; //h번 이상 인용된 논문 count
            }
            if(count >= i){
                answer = i;
            }
        }
        return answer;
    }
}