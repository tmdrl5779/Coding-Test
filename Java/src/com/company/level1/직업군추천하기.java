package com.company.level1;

import java.util.*;

public class 직업군추천하기 {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        Map<String, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < table.length; i++){
            Map<String, Integer> hashMap = new HashMap<>();
            int point = 0;
            String[] s = table[i].split(" ");
            String job = s[0];

            for (int j = 1; j < s.length; j++){
                hashMap.put(s[j], 6-j);
            }

            for (int j = 0; j < languages.length; j++){
                if(hashMap.containsKey(languages[j])){
                    point += hashMap.get(languages[j]) * preference[j];
                }
            }
            treeMap.put(job, point);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(treeMap.entrySet());
        Collections.sort(list, (o1, o2) -> {
            return o1.getValue() > o2.getValue()?-1 : o1.getValue() < o2.getValue()? 1:
                    o1.getKey().compareTo(o2.getKey());
        });

        answer = list.get(0).getKey();

        return answer;
    }
}
