package happysubin.javapractice.codingtest.programmers.java.level_two;

import java.util.*;

import java.util.*;

//신고 결과 받기 복습
class Hash {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> rcMap = new HashMap<>(); //신고 횟수 멤버 별 카운트
        Map<String, List<String>> rMap = new HashMap<>(); //중복 없이 신고 기록 관리
        Map<String, Integer> map = new HashMap<>(); //인덱스로 리턴을해야하므로 map를 사용

        //1. 일단 멤버 신고 카운트 맵 초기화, 신고 기록 리스트 생성
        for(String id : id_list){
            rcMap.put(id, 0);
            rMap.put(id, new ArrayList<>());
            map.put(id, 0);
        }

        //2. 중복 없이 모든 신고 기록 넣음. 중복되지 않으면, 여기서 값을 추가함.
        for(String r: report){
            String[] t = r.split(" ");
            String reporting = t[0];
            String reported = t[1];
            List<String> list = rMap.get(reporting);
            if(!list.contains(reported)){
                list.add(reported);
                rcMap.put(reported, rcMap.getOrDefault(reported, 0) + 1);
            }
        }

        int[] answer = new int[id_list.length];

        //3. 돌아가면서 k를 넘으면, 신고한 사람들에게 보낸다.
        for(String key: rcMap.keySet()){
            if(rcMap.get(key) >= k){ //key의 이름이 k번 이상 신고를 먹은 것.
                for(String s : rMap.keySet()){
                    if(rMap.get(s).contains(key)){
                        map.put(s, map.getOrDefault(s, 0) + 1);
                    }
                }
            }
        }
        //4. 인덱스에 맞춰 넣어줘야함.
        for(int i = 0 ; i < id_list.length; i++){
            Integer value = map.get(id_list[i]);
            answer[i] = value;
        }

        return answer;
    }
}
