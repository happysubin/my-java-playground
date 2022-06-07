package happysubin.javapractice.codingtest.programmers;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.*;

/*

public class Kakao {
    static public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for(int i = 0; i < moves.length; i++){
            for(int j = 0; j < board.length; j ++){
                if(board[j][moves[i] - 1] != 0){
                    if(stack.isEmpty()){
                        stack.push(board[j][moves[i]- 1]);
                    }
                    else{
                        if(stack.peek() == board[j][moves[i]-1] ){
                            stack.pop();
                            answer += 2;
                        }
                        else{
                            stack.push(board[j][moves[i]- 1]);
                        }
                    }

                    board[j][moves[i]-1]=0;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] arr = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] move = {1,5,3,5,1,2,1,4};

        System.out.println(solution(arr,move));

    }
}

 */

/*

//신고 결과 받기
public class Kakao{

    static public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> map = new HashMap<>(); //해쉬 셋은 중복을 막는다.
        Map<String, Integer> reportMap = new HashMap<>();

        //초기화
        for(int i = 0; i < id_list.length; i++){
            map.put(id_list[i],new HashSet<>());
        }

        //신고를 넣은 사람이 key, 그 사람이 신고한 사람들 HashSet이 value
        for(int i = 0; i < report.length; i++ ) {
            String[] arr = report[i].split(" ");
            String reportingPerson = arr[0];
            String reportedPerson = arr[1];
            if (map.get(reportingPerson).add(reportedPerson)) { //HastSet을 사용해 중복이 불가, true면 처음 신고 당한 거
                reportMap.put(reportedPerson, reportMap.getOrDefault(reportedPerson, 0) + 1);
            }
        }

        for(int i = 0; i < report.length; i++){
            String[] arr = report[i].split(" ");
            String reportingPerson = arr[0];
            String reportedPerson = arr[1];
            if(reportMap.get(reportedPerson) < k){
                map.get(reportingPerson).remove(reportedPerson);
            }
        }

        for(int i = 0; i< id_list.length; i++){
            answer[i] = map.get(id_list[i]).size();
        }


        return answer;
    }

    public static void main(String[] args) {
        String[] idList = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] solution = solution(idList, report, k);

        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}

*/

/*

//이거 아이디를 넣고 그것만 바꿔줘도 될듯.. 똑똑한 사람이 많구나
//오픈 채팅방
public class Kakao{

    static public String[] solution(String[] record) {
        Map<String, String> nameMap = new HashMap<>();
        ArrayList<String> log = new ArrayList<>();

        for(int i = 0; i < record.length; i++){
            handleProcess(record[i], nameMap, log);
        }

        String[] answer = new String[log.size()];

        for (int i = 0; i< log.size(); i++) {
            String[] str =  log.get(i).split("&&");
            String nickName = log.get(i).split("님이")[0];
            String uid = str[1];
           if(log.get(i).contains(uid) & nameMap.get(uid) != nickName){
               String s = str[0].replace(nickName,nameMap.get(uid));
               answer[i] = s;
           }
        }

        return answer;
    }

    static void handleProcess(String str, Map<String,String> nameMap, ArrayList<String> log ){
        StringTokenizer token = new StringTokenizer(str, " ");
        String action = token.nextToken();
        if(action.equals("Enter")){
            String uid = token.nextToken();
            String nickName = token.nextToken();
            nameMap.put(uid, nickName);
            log.add(nickName+"님이 들어왔습니다." + "&&" + uid);
        }
        else if(action.equals("Leave")){
            String uid = token.nextToken();
            String nickName = nameMap.get(uid);
            log.add(nickName+"님이 나갔습니다." +"&&" + uid);
        }
        else{
            String uid = token.nextToken();
            String newNickName = token.nextToken();
            nameMap.put(uid,newNickName);
        }
    }

    public static void main(String[] args) {
        String[] result =
                        {"Enter uid1234 Muzi",
                        "Enter uid4567 Prodo",
                        "Leave uid1234",
                        "Enter uid1234 Prodo",
                        "Change uid4567 Ryan"};

        System.out.println(solution(result));
    }
}

 */




/*
//비밀지도
public class Kakao {

    static public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        String[] str1 = new String[arr1.length];
        String[] str2 = new String[arr2.length];

        for(int i = 0; i < arr1.length; i++){
            String s = Integer.toBinaryString(arr1[i]);
            while(s.length() < arr1.length){
                s = "0" + s;
            }
            str1[i] = s;
        }

        for(int i = 0; i < arr2.length; i++){
            String s = Integer.toBinaryString(arr2[i]);
            while(s.length() < arr2.length){
                s = "0" + s;
            }
            str2[i] = s;
        }
        //변환 완료



        for(int i = 0; i < arr1.length; i++){
            String s = "";
            String[] map1 = str1[i].split("");
            String[] map2 = str2[i].split("");
            for(int j = 0; j < map1.length; j++){
                if(map1[j].equals("1") | map2[j].equals("1")){
                    s = s +"#";
                }
                else{
                    s = s +" ";
                }
            }
            answer[i] = s;
        }


        for (String s : answer) {
            System.out.println("s = " + s);
        }

        return answer;
    }


    public static void main(String[] args) {
        int n = 5;

        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        System.out.println(solution(n,arr1,arr2));


    }
}


 */

public class Kakao {

    static public int solution(String dartResult) {
        int answer = 0;

        ArrayList<String> arr = new ArrayList<>();
        String[] word = dartResult.split("");
        int[] score = new int[3];
        String[] split = dartResult.split("[SDT*#]");

        int z = 0;
        for (String s : split) {
            if(!s.equals("")){
                score[z++] = Integer.parseInt(s);
            }
        }

        int seq = 0;

        for(int i = 0; i < word.length ; i++){
            if(word[i].equals("S")){
                seq++;
            }
            else if(word[i].equals("D")){
                int num = score[seq];
                score[seq] = num * num;
                seq++;
            }
            else if(word[i].equals("T")){
                int num = score[seq];
                score[seq] = num * num * num;
                seq++;
            }
            else if(word[i].equals("*")){ // 두배 두배
                if(seq - 1 == 0){  //첫번째 자리라면
                    int num = score[seq  - 1];
                    score[seq - 1] = num * 2;
                }
                else { //그 뒤라면
                   int num2 = score[seq - 2];
                    int num1 = score[seq - 1];

                    score[seq - 2] = num2 * 2;
                    score[seq - 1] = num1 * 2;
                }

            }
            else if(word[i].equals("#")){
                int num = score[seq  - 1];
                score[seq - 1] = num * -1;
            }
        }

        for (int i  : score) {
            answer += i ;
        }

        return answer;
    }


    public static void main(String[] args) {
        String  s = "1S2D*3T";

        System.out.println(solution(s));


    }
}
