package com.company.level_1;

public class 수박수박 {
    public String solution(int n) {
        String answer = "";

        for (int i = 1; i < n+1; i++){
            if (i%2 == 0){
                answer += "박";
            }else {
                answer += "수";
            }
        }

        return answer;
    }
}
