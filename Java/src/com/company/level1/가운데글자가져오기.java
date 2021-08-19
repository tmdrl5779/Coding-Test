package com.company.level1;

public class 가운데글자가져오기 {
    public String solution(String s) {
        String answer = "";
        if (s.length() % 2 == 0){
            answer = String.valueOf(s.charAt(s.length()/2 - 1)) + String.valueOf(s.charAt(s.length()/2));
        }else{
            answer = String.valueOf(s.charAt(s.length()/2));
        }
        return answer;
    }
}
