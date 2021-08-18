package com.company.level_1;

import java.util.*;

public class 나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++){
            if (arr[i] % divisor == 0){
                list.add(arr[i]);
            }
        }

        if (list.size() == 0){
            answer = new int[]{-1};
        }
        else{
            answer = new int[list.size()];
            int i = 0;
            for (Integer l : list){
                answer[i] = l;
                i++;
            }
            Arrays.sort(answer);
        }
        return answer;
    }
}
