package happysubin.javapractice.codingtest.programmers.java.level_two;

import java.util.*;
//매늎 리뉴얼
class Solution {
    Map<String, Integer> map = new HashMap<>();
    List<String> list = new ArrayList<>();

    public String[] solution(String[] orders, int[] course) {
        //1. 일단 모든 주문들을 정렬한다.
        for(int i = 0; i < orders.length; i++){
            char[] c = orders[i].toCharArray();
            Arrays.sort(c);
            orders[i] = String.valueOf(c);
        }

        //2. 이제 모든 경우를 더해야 한다. Map<>에 더해버리장.
        for(int i = 0; i < course.length; i++){// ABCDFG, AC, CDE 등 하나씩 찾는다.
            for(int j = 0; j < orders.length; j++){
                combination(orders[j], "", course[i]);
            }

            int max = Collections.max(new ArrayList<>(map.values()));
            if(max > 1){
                for(String key: map.keySet()){
                    if(map.get(key) == max) list.add(key);
                }
                map = new HashMap<>();
            }
        }

        //3. 결과
        Collections.sort(list);
        String[] arr = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }
        return arr;
    }

    private void combination(String str, String keyword, int course){
        if(course == 0){
            map.put(keyword, map.getOrDefault(keyword, 0) + 1);
            return;
        }
        for(int i = 0; i < str.length(); i++){
            combination(str.substring(i + 1), keyword + str.charAt(i), course - 1);
        }
    }
}

//문자열 압축
class Solution {
    public int solution(String s) {
        int answer = s.length();

        for(int i = 1; i <= s.length() / 2; i++){
            int level = 1; //압축 레벨
            String str = s.substring(0,i);
            StringBuilder sb = new StringBuilder();
            for(int j = i; j <= s.length(); j+= i){
                //문자열이 길다면 그냥 붙이기
                String next = "";
                if(j + i > s.length()){
                    next = s.substring(j, s.length());
                }
                //괜찮다면 압축하기
                else{
                    next = s.substring(j, j + i);
                }

                if(str.equals(next)) level++;
                else{
                    sb.append((level != 1 ? level : "") + str);
                    str = next;
                    level = 1;
                }
            }
            sb.append(str);
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}
