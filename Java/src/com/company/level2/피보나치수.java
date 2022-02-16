package com.company.level2;

public class 피보나치수 {
    public int solution(int n) {
        int answer = 0;

        int[] dp = new int[n+1];

        for(int i = 0; i < dp.length; i++){
            if(i == 0){
                dp[i] = 0;
            }else if(i == 1){
                dp[i] = 1;
            }else{
                dp[i] = (dp[i-1] % 1234567) + (dp[i-2] % 1234567) % 1234567;
            }
        }

        answer = dp[dp.length-1] % 1234567;

        return answer;
    }
}
