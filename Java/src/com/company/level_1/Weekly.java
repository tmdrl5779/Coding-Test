package com.company.level_1;

import java.util.*;

public class Weekly {

    //8월 2주차 문제
    public String solution(int[][] scores) {
        String answer = "";

        int peopleNum = scores.length;

        for (int i = 0; i < peopleNum; i++){
            Map<Integer, Integer> hashMap = new HashMap<>();
            int sum = 0;
            for (int j = 0; j< peopleNum; j++){
                if (hashMap.containsKey(scores[j][i])){
                    hashMap.replace(scores[j][i], hashMap.get(scores[j][i]) + 1);
                }else{
                    hashMap.put(scores[j][i], 1);
                }
                sum += scores[j][i];
            }
            int mine = scores[i][i];

            if ((Collections.max(hashMap.keySet()) == mine || Collections.min(hashMap.keySet()) == mine)
                    && hashMap.get(mine) == 1){
                sum -= mine;
                answer += findScore(sum/(peopleNum-1));
            }else{
                answer += findScore(sum/peopleNum);
            }

        }
        return answer;
    }

    public String findScore(double point){
        String result;

        if (point >= 90){
            result = "A";
        }else if(point < 90 && point >= 80){
            result = "B";
        }else if(point < 80 && point >= 70){
            result = "C";
        }else if(point < 70 && point >= 50){
            result = "D";
        }else{
            result = "F";
        }

        return result;
    }

}
