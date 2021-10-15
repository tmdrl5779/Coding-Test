package com.company.level2;

import java.util.*;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();

        Arrays.sort(people);

        for(int i = people.length-1; i > -1; i--){
            list.add(people[i]);
        }

        for(int i = 0; i < list.size(); i++){
            int prevIdx = -1;

            for(int j = list.size()-1; j > i; j--){
                if(list.get(i) + list.get(j) > limit){
                    break;
                }else{
                    prevIdx = j;
                }
            }

            if(prevIdx != -1){
                list.remove(prevIdx);
            }
            answer++;
        }
        return answer;
    }
}
