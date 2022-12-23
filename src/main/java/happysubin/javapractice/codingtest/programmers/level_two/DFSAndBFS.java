package happysubin.javapractice.codingtest.programmers.level_two;

public class DFSAndBFS {

    static int answer = 0;
    static int goal = 0;

    private void dfs(int[] numbers, int[] ch, int cnt){
        if(cnt == ch.length - 1){
            int sum = 0;
            for (int i = 0; i < ch.length; i++) {
                if(ch[i] == 0){
                    sum += numbers[i];
                }
                else{
                    sum -= numbers[i];
                }
            }


            if(sum == goal) answer++;
        }
        else{
            cnt++;
            ch[cnt] = 1;
            dfs(numbers, ch, cnt);
            ch[cnt] = 0;
            dfs(numbers, ch, cnt);
        }
    }

    public int solution(int[] numbers, int target) {
        goal = target;
        int[] ch = new int[numbers.length];
        dfs(numbers, ch, -1);
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        DFSAndBFS main = new DFSAndBFS();
        main.solution(arr, 3);
        System.out.println("answer = " + answer);
    }
}
