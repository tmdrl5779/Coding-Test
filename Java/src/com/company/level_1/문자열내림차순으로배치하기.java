package com.company.level_1;

import java.util.Arrays;

public class 문자열내림차순으로배치하기 {
    public String solution(String s) {
        String answer = "";

        String[] sArray = s.split("");

        Arrays.sort(sArray, (o1, o2) -> o2.compareTo(o1));

        for (int i = 0; i < sArray.length; i++){
            answer += sArray[i];
        }

        return answer;
    }
}
