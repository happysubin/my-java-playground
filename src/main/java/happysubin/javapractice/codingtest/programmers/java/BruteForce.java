package happysubin.javapractice.codingtest.programmers.java;

import java.util.*;
public class BruteForce {

    class Student implements Comparable<Student>{
        int id;
        int score;

        public Student(int id, int score) {
            this.id = id;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return o.score - this.score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", score=" + score +
                    '}';
        }
    }

    public int[] solution(int[] answers) {

        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,2,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};

        List<Student> list = new ArrayList<>();
        HashSet<Integer> finals = new HashSet<>();

        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;

        int len = 0;
        for(int i = 0; len < answers.length; i++){
            if(i >= first.length){
                i = 0;
            }
            if(i < first.length){
                if(answers[len] == first[i]){
                    cnt1++;
                }
                len++;
            }
        }

        len = 0;
        for(int i = 0; len < answers.length; i++){
            if(i >= second.length){
                i = 0;
            }
            if(i < second.length){
                if(answers[len] == second[i]){
                    cnt2++;
                }
                len++;
            }
        }

        len = 0;
        for(int i = 0; len < answers.length; i++){
            if(i >= third.length){
                i = 0;
            }
            if(i < third.length){
                if(answers[len] == third[i]){
                    cnt3++;
                }
                len++;
            }
        }

        list.add(new Student(1,cnt1));
        list.add(new Student(2,cnt2));
        list.add(new Student(3,cnt3));

        Collections.sort(list);

        for (int i =1  ; i < 3; i++){
            if(list.get(i-1).score > list.get(i).score){
                finals.add(list.get(i-1).id);
                break;
            }

            else if(list.get(i-1).score == list.get(i).score){
                finals.add(list.get(i-1).id);
                finals.add(list.get(i).id);

            }
            else break;
        }


        Iterator<Integer> iterator = finals.iterator();

        int[] answer = new int[finals.size()];

        int i = 0;
        for (Iterator<Integer> it = finals.iterator(); it.hasNext(); ) {
            answer[i++] = it.next();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,1,2,3,4,5};
        int[] arr2 = {1,3,2,4,2};
        BruteForce bruteForce = new BruteForce();
        int[] solution = bruteForce.solution(arr1);

        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
