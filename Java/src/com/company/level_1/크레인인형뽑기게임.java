package com.company.level_1;

import java.util.*;

public class 크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int depth = board.length;
        Stack<Integer> stack = new Stack<>();

        for (int col : moves){
            for (int i = 0; i< depth; i++){
                if (board[i][col-1] != 0){
                    if(!stack.isEmpty()){
                        if(stack.peek() == board[i][col-1]){
                            stack.pop();
                            answer++;
                        }else{
                            stack.push(board[i][col-1]);
                        }
                    }else{
                        stack.push(board[i][col-1]);
                    }
                    board[i][col-1] = 0;
                    break;
                }
            }
        }
        return answer*2;
    }
}
