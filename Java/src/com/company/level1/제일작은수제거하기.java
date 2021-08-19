package com.company.level1;

import java.util.ArrayList;
import java.util.List;

public class 제일작은수제거하기 {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int a : arr){
            min = Math.min(min, a);
        }
        for (int a : arr){
            if (a != min){
                list.add(a);
            }
        }
        int[] answer;
        if (list.size() > 1){
            answer = new int[list.size()];

            for (int i = 0; i < answer.length; i++){
                answer[i] = list.get(i);
            }
        } else{
            answer = new int[]{-1};
        }

        return answer;
    }
}
