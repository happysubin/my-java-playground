package happysubin.javapractice.codingtest.programmers.java.level_one;

//최소직사각형 찾기
class BruteForce {
    public int solution(int[][] sizes) {
        int[][] arr = new int[sizes.length][2];

        //1.가로와 세로 중 더 큰 값을 0번 인덱스에 둔다. 작은 값은 1번 인덱스에.
        for(int i = 0; i < sizes.length; i++){
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);
            arr[i][0] = max;
            arr[i][1] = min;
        }

        //2. 가로, 세로 모두 최댓값을 구해서 곱한다.
        int xMax = 0;
        int yMax = 0;
        for(int i = 0; i < sizes.length; i++){
            xMax = Math.max(xMax, arr[i][0]);
            yMax = Math.max(yMax, arr[i][1]);
        }
        return xMax * yMax;
    }

}
