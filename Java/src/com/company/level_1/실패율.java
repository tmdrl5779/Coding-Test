package com.company.level_1;

import java.util.*;

public class 실패율 {
    public int[] solution(int N, int[] stages) {
        double[][] temp = new double[N][2];
        int peopleLen = stages.length;
        for(int i = 0; i < N; i++){
            temp[i][1] = i+1;
        }

        for(int i = 0; i < stages.length; i++){
            if(N >= stages[i]){
                temp[stages[i] - 1][0]++;
            }
        }

        for(int i = 0; i < temp.length; i++){
            int didnt = (int)temp[i][0];
            if(temp[i][0] != 0){
                temp[i][0] /= peopleLen;
            }
            peopleLen -= didnt;
        }

        Arrays.sort(temp, (o1, o2) -> {
            return o1[0] > o2[0] ? -1 : o1[0] < o2[0] ? 1 : 0;
        });

        int[] answer = new int[N];
        for(int i = 0; i < N; i++){
            answer[i] = (int)temp[i][1];
        }

        return answer;
    }
}
