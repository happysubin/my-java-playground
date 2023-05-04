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

