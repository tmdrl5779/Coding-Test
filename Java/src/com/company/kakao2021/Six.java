package com.company.kakao2021;

public class Six {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int[][] dp = new int[board.length][board[0].length];

        for(int i = 0; i < skill.length; i++){
            int type = skill[i][0];
            int startX = skill[i][1];
            int startY = skill[i][2];
            int endX = skill[i][3];
            int endY = skill[i][4];
            int degree = skill[i][5];

            if(type == 1) { //적공격
                for(int j = startX; j < endX+1; j++){
                    for(int k = startY; k < endY+1; k++){
                        board[j][k] -= degree;
                    }
                }
            }else{

            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] > 0) answer++;
            }
        }

        return answer;
    }
}
