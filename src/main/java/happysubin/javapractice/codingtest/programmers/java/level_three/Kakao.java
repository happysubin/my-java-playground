package happysubin.javapractice.codingtest.programmers.java.level_three;

/** 두 큐 합 같게 만들기
 * public class Kakao {
 *
 *     public int solution(int[] queue1, int[] queue2) {
 *         long sum = 0;
 *         for (int i = 0; i < queue1.length; i++) {
 *             sum += queue1[i] + queue2[i];
 *         }
 *         long goal = sum / 2;
 *
 *
 *         int cnt = getCnt(queue1, queue2, goal);
 *         cnt = Math.min(cnt, getCnt(queue2, queue1, goal));
 *
 *         if(cnt == Integer.MAX_VALUE) return -1;
 *         return cnt;
 *     }
 *
 *     private int getCnt(int[] queue1, int[] queue2, long goal) {
 *         Queue<Integer> queue1A = new LinkedList<>();
 *         Queue<Integer> queue2A = new LinkedList<>();
 *         int cnt = 0;
 *
 *         for (int i = 0; i < queue1.length; i++) {
 *             queue1A.offer(queue1[i]);
 *             queue2A.offer(queue2[i]);
 *         }
 *
 *         long temp1 = 0;
 *         long temp2 = 0;
 *         Iterator<Integer> iteratorA = queue1A.iterator();
 *         Iterator<Integer> iteratorB = queue2A.iterator();
 *         while(iteratorA.hasNext()){
 *             temp1 += iteratorA.next();
 *         }
 *
 *         while(iteratorB.hasNext()){
 *             temp2 += iteratorB.next();
 *         }
 *
 *         for (cnt = 0; cnt < (queue1A.size() + queue2A.size()) * 2; ) {
 *             if(temp1 == temp2){
 *                 break;
 *             }
 *
 *             else if(temp1 > temp2){
 *                 Integer poll = queue1A.poll();
 *                 temp1 -= poll;
 *                 queue2A.offer(poll);
 *                 temp2 += poll;
 *                 cnt++;
 *             }
 *
 *             else if (temp2 > temp1){
 *                 Integer poll = queue2A.poll();
 *                 temp2 -= poll;
 *                 queue1A.offer(poll);
 *                 temp1 += poll;
 *                 cnt++;
 *             }
 *         }
 *         if((temp1 == temp2) && temp1 == goal )return cnt;
 *         else return Integer.MAX_VALUE;
 *     }
 *
 *     public static void main(String[] args) {
 *         int[] arr1 = {1,2, 2, 1};
 *         int[] arr2 = {1,2 ,4, 1};
 *
 *         Kakao main = new Kakao();
 *         int solution = main.solution(arr1, arr2);
 *         System.out.println("solution = " + solution);
 *     }
 * }
 */

public class Kakao {

    public int solution(String s) {
        int answer = 0;

//        for (int i = 0; i <= s.length() / 2; i++) {
//            Stack<String> stack = new Stack<>();
//            StringBuffer sf = new StringBuffer();
//            for (String s1 : s.split("")) {
//                stack.
//            }
//
//        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2, 2, 1};
        int[] arr2 = {1,2 ,4, 1};

        Kakao main = new Kakao();
        int solution = main.solution("abcabcabcabcdededededede");
        System.out.println("solution = " + solution);
    }
}
