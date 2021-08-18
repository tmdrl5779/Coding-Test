package com.company.level_1;

import java.util.*;

public class 같은숫자는싫어 {

    public int[] solution(int []arr) {

        List<Integer> list = new ArrayList<>();

        int prev = arr[0];
        list.add(prev);
        for (int i = 1; i < arr.length; i++){
            int current = arr[i];
            if (prev != current){
                list.add(current);
                prev = current;
            }
        }
        int[] answer = new int[list.size()];

        int i = 0;
        for (Integer l : list){
            answer[i] = l;
            i++;
        }
        return answer;
    }
}
