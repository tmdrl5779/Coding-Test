package com.company.level_1;

public class 소수찾기 {
    public int solution(int n) {
        int answer = n-1;

        for(int i = 2; i < n+1; i++){
            for(int j = 2; j <= Math.sqrt(i); j++){
                if (i % j == 0){
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }
}
