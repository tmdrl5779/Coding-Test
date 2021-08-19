package com.company.level1;

public class 정수제곱근판별 {
    public long solution(long n) {
        long answer = 0;

        if((int)Math.sqrt(n) - Math.sqrt(n) == 0){
            answer = (long)Math.pow(Math.sqrt(n)+1, 2);
        } else{
            answer = -1;
        }
        return answer;
    }
}
