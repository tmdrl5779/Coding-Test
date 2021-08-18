package com.company.level_1;

public class 두정수사이합 {
    public long solution(int a, int b) {
        long answer = 0;
        if (a == b){
            return a;
        }

        for (int i = Math.min(a, b); i < Math.max(a, b) +1; i++){
            answer += i;
        }
        return answer;
    }
}
