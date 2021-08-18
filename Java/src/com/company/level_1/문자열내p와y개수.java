package com.company.level_1;

public class 문자열내p와y개수 {

    boolean solution(String s) {
        boolean answer = true;
        int pCount = 0;
        int yCount = 0;

        for (int i =0; i < s.length(); i++){
            if (s.charAt(i) == 'P' || s.charAt(i) == 'p'){
                pCount++;
            }
            if (s.charAt(i) == 'Y' || s.charAt(i) == 'y'){
                yCount++;
            }
        }
        if (pCount != yCount){
            answer = false;
        }

        return answer;
    }
}
