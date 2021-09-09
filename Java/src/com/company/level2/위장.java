package com.company.level2;

import java.util.*;

public class 위장 {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for(String[] clothe : clothes){
            String key = clothe[1];
            if(map.containsKey(key)){
                map.replace(key, map.get(key) + 1);
            }else{
                map.put(key, 1);
            }
        }

        for(Integer count : map.values()){
            answer *= (count+1);
        }

        answer -= 1;

        return answer;
    }
}
