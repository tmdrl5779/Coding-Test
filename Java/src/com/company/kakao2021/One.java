package com.company.kakao2021;

import java.util.*;

public class One {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Set<String>> map = new HashMap<>();

        for(int i = 0; i < report.length; i++){
            String s = report[i];
            String[] split = s.split(" ");
            if(!map.containsKey(split[0])){
                Set<String> set = new HashSet<>();
                set.add(split[1]);
                map.put(split[0], set);
            }else {
                Set<String> set = map.get(split[0]);
                set.add(split[1]);
            }
        }

        Map<String, Integer> map2 = new HashMap<>();

        for (String s : map.keySet()) {
            for (String s1 : map.get(s)) {
                if(!map2.containsKey(s1)){
                    map2.put(s1, 1);
                }else{
                    map2.replace(s1, map2.get(s1) + 1);
                }
            }
        }

        for(int i = 0; i < id_list.length; i++){
            if(!map.containsKey(id_list[i])) continue;
            for(String s : map.get(id_list[i])){
                if(map2.get(s) >= k){
                    answer[i] += 1;
                }
            }
        }


        return answer;
    }
}
