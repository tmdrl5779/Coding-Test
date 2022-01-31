package com.company.level2;

public class 땅따먹기 {
    int solution(int[][] land) {
        int answer = -1;

        int[][] dp = new int[land.length][land[0].length];

        for(int i = 0; i < dp[0].length; i++){
            dp[0][i] = land[0][i];
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){

                int max = -1;

                for(int k = 0; k < dp[0].length; k++){
                    if(k == j) continue;

                    max = Math.max(max, dp[i-1][k]);
                }

                dp[i][j] = land[i][j] + max;

            }
        }


        for(int i = 0; i < dp[0].length; i++){
            answer = Math.max(answer, dp[dp.length-1][i]);
        }

        return answer;
    }
}
