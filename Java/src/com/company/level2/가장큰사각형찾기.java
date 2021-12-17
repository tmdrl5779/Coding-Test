package com.company.level2;

public class 가장큰사각형찾기 {
    public int solution(int [][]board)
    {
        int answer = 0;

        int[][] dp = new int[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dp[i][j] = board[i][j];
                if(board[i][j] == 1){
                    answer = 1;
                }
            }
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(dp[i][j] != 0){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]) , dp[i-1][j-1]) + 1;
                    answer = Math.max(answer, dp[i][j] * dp[i][j]);
                }
            }
        }

        return answer;
    }
}
