package happysubin.javapractice.codingtest.programmers.java.level_one;

//최소직사각형 찾기
//class BruteForce {
//    public int solution(int[][] sizes) {
//        int[][] arr = new int[sizes.length][2];
//
//        //1.가로와 세로 중 더 큰 값을 0번 인덱스에 둔다. 작은 값은 1번 인덱스에.
//        for(int i = 0; i < sizes.length; i++){
//            int max = Math.max(sizes[i][0], sizes[i][1]);
//            int min = Math.min(sizes[i][0], sizes[i][1]);
//            arr[i][0] = max;
//            arr[i][1] = min;
//        }
//
//        //2. 가로, 세로 모두 최댓값을 구해서 곱한다.
//        int xMax = 0;
//        int yMax = 0;
//        for(int i = 0; i < sizes.length; i++){
//            xMax = Math.max(xMax, arr[i][0]);
//            yMax = Math.max(yMax, arr[i][1]);
//        }
//        return xMax * yMax;
//    }
//
//}


import java.util.*;
import java.util.*;
class BruteForce {
    public int[] solution(int[] answers) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] arr1 = {0, 1, 2, 3, 4, 5};
        int[] arr2 = {0, 2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {0, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int cnt1 = 1, cnt2 = 1, cnt3 = 1;

        map.put(1, new ArrayList<>());
        map.put(2, new ArrayList<>());
        map.put(3, new ArrayList<>());

        for(int i = 0; i < answers.length; i++){
            if(cnt1 == arr1.length){
                cnt1 = 1;
            }
            List<Integer> l1 = map.get(1);
            l1.add(arr1[cnt1++]);

            if(cnt2 == arr2.length){
                cnt2 = 1;
            }
            List<Integer> l2 = map.get(2);
            l2.add(arr2[cnt2++]);

            if( cnt3 == arr3.length){
                cnt3 = 1;
            }
            List<Integer> l3 = map.get(3);
            l3.add(arr3[cnt3++]);
        }
        int answer1 = 0, answer2 =0, answer3 = 0;
        for(int i = 0; i < answers.length; i++){
            List<Integer> list1 = map.get(1);
            List<Integer> list2 = map.get(2);
            List<Integer> list3 = map.get(3);
            if(list1.get(i) == answers[i]){
                answer1++;
            }
            if(list2.get(i) == answers[i]){
                answer2++;
            }
            if(list3.get(i) == answers[i]){
                answer3++;
            }
        }

        //최댓 값을 찾고
        int[] answer = new int[]{answer1, answer2, answer3};
        int max = 0;
        //최댓 값의 개수만큼 배열을 만든다.
        max = Math.max(answer[0], Math.max(answer[1], answer[2]));

        int c = 0;
        for(int i = 0; i < 3; i++){
            if(max == answer[i]){
                c++;
            }
        }
        int[] a = new int[c];

        //최대 값을 가진 애들만 뽑는다.
        int i = 0;
        int i2 = 0;
        for(int i1 = 0; i1 < 3; i1++){
            if(answer[i1] == max){
                a[i2++] = i1 + 1;
            }
        }

        return a;
    }
}