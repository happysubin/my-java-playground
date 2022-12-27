package happysubin.javapractice.codingtest.inflearn;

import java.util.*;

/** 합이 같은 부분집합
 * public class DFSAndBFSUtilizeChapter {
 *
 *      static List<Integer> list = new ArrayList<>();
 *      static int[] ch;
 *      static int answer = 0;
 *
 *     public static void main(String[] args) throws IOException {
 *
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 *         int num = Integer.parseInt(br.readLine());
 *         String[] s = br.readLine().split(" ");
 *
 *         for (String s1 : s) {
 *             list.add(Integer.parseInt(s1));
 *         }
 *         ch = new int[num];
 *
 *         DFSAndBFSUtilizeChapter main = new DFSAndBFSUtilizeChapter();
 *         main.DFS(-1, ch);
 *         if(answer >= 1) bw.write("YES");
 *         else bw.write("NO");
 *         bw.flush();
 *     }
 *
 *     private void DFS(int L, int[] ch) {
 *         if(L == ch.length - 1){
 *             int sum1 = 0, sum2 = 0;
 *             for (int i = 0; i < ch.length; i++) {
 *                 if(ch[i] == 1){
 *                     sum2 += list.get(i);
 *                 }
 *                 else{
 *                     sum1 += list.get(i);
 *                 }
 *             }
 *             if(sum2 == sum1)answer++;
 *         }
 *         else{
 *             L++;
 *             ch[L] = 1;
 *             DFS(L, ch);
 *             ch[L] = 0;
 *             DFS(L, ch);
 *         }
 *     }
 * }
 */

/** 바둑이 승차
 * public class DFSAndBFSUtilizeChapter {
 *
 *     static List<Integer> list = new ArrayList<>();
 *     static int limit = 0;
 *     static int max = 0;
 *
 *     public static void main(String[] args) {
 *
 *         Scanner sc = new Scanner(System.in);
 *         limit = sc.nextInt();
 *         int num = sc.nextInt();
 *
 *         for (int i = 0; i < num; i++) {
 *             list.add(sc.nextInt());
 *         }
 *
 *         int[] ch = new int[num];
 *
 *         DFSAndBFSUtilizeChapter main = new DFSAndBFSUtilizeChapter();
 *         main.DFS(-1, ch);
 *         System.out.println(max);
 *     }
 *
 *     private void DFS(int L, int[] ch) {
 *         int sum = 0;
 *         if(L == ch.length - 1){
 *
 *             for (int i = 0; i < ch.length; i++) {
 *                 if(ch[i] == 1) sum += list.get(i);
 *             }
 *
 *             if(sum < limit){
 *                 max = Math.max(max,sum);
 *             }
 *
 *         }
 *         else{
 *             L++;
 *             ch[L] = 1;
 *             DFS(L, ch);
 *             ch[L] = 0;
 *             DFS(L, ch);
 *         }
 *     }
 * }
 */


class Solve {
    int minute;
    int score;

    public Solve(int score, int minute) {
        this.minute = minute;
        this.score = score;
    }
}

public class DFSAndBFSUtilizeChapter {

    static int answer = Integer.MIN_VALUE;
    static int limit;
    static List<Solve> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        limit = sc.nextInt();
        for (int i = 0; i < num; i++) {
            list.add(new Solve(sc.nextInt(), sc.nextInt()));
        }

        int[] ch = new int[num];
        DFSAndBFSUtilizeChapter main = new DFSAndBFSUtilizeChapter();
        main.DFS(-1, ch);
        System.out.println(answer);
    }

    private void DFS(int L, int[] ch) {
        if(L == list.size() - 1){
            int sum = 0;
            int minute = limit;
            for (int i = 0; i < list.size(); i++) {
                if(ch[i] == 1 && minute - list.get(i).minute >= 0){
                    sum += list.get(i).score;
                    minute -= list.get(i).minute;
                }
            }
            answer = Math.max(answer, sum);
        }
        else{
            L++;
            ch[L] = 1;
            DFS(L, ch);
            ch[L] = 0;
            DFS(L, ch);
        }
    }


}
