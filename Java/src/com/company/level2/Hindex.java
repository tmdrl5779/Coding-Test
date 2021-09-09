package com.company.level2;

import java.util.Arrays;

public class Hindex {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for(int h = 0; h <= citations[citations.length-1]; h++){
            int count = 0;
            for(int j = 0; j < citations.length; j++){
                if(citations[j] >= h){
                    break;
                }else{
                    count++;
                }
            }
            if(citations.length - count >= h){
                answer = Math.max(answer, h);
            }

        }

        return answer;
    }
}
