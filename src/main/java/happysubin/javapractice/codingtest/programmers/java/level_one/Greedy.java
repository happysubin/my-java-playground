package happysubin.javapractice.codingtest.programmers.java.level_one;

import java.util.Arrays;

public class Greedy {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n + 1]; // 1부터 30까지

        Arrays.sort(lost);
        Arrays.sort(reserve);

        //학생들 초기화
        for (int i = 1; i < n + 1; i++) {
            students[i] = 1;
        }

        //도둑 맞은 학생들 체크
        for (int i = 0; i < lost.length; i++) {
            students[lost[i]] = 0;
        }

        //도둑 맞은 애들중에 여분 있는 애들 검사해서 할당함.
        for (int i = 0; i < reserve.length; i++) {
            if(students[reserve[i]] == 0){
                students[reserve[i]] = 1;
                reserve[i] = 0; //0으로 바꿈. 도난 당해서 자기가 입었다는 뜻. 0으로 두면 안됨
            }
        }

        //맨 앞부터 1이랑 같다면 앞에만, 1보다 크다면 뒤에서부터 채우고 앞을 채우면 될 듯.

        for (int i = 0; i < reserve.length; i++) {
            if(reserve[i] != 0){ //옷을 도난당하고 예비복을 입은 친구가 아닐때
                if(reserve[i] == 1 ){ //맨 앞일 때
                    students[reserve[i] + 1] = 1;
                }
                else if (reserve[i] == n ){ //맨 뒤일 때
                    students[reserve[i] - 1] = 1;
                }
                else { //다른 경우
                    if(students[reserve[i] - 1] == 0){
                        students[reserve[i] - 1] = 1;
                    }
                    else if (students[reserve[i] + 1] < n + 1 && students[reserve[i] + 1]  == 0){
                        students[reserve[i] + 1] = 1;
                    }
                }
            }
        }

        for (int student : students) {
            if(student == 1){
                answer += 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 10;
        int[] lost = {5, 7, 8};
        int[] reserve = {1, 2, 3, 4, 6, 9, 10};
        Greedy greedy = new Greedy();
        int solution = greedy.solution(n, lost, reserve);
        System.out.println("solution = " + solution);
    }
}
