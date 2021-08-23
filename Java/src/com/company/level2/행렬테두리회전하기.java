package com.company.level2;

import java.util.ArrayList;
import java.util.List;

public class 행렬테두리회전하기 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        int[][] array = new int[rows][columns];
        int count = 1;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                array[i][j] = count;
                count++;
            }
        }


        for (int[] query : queries){
            int x1 = query[0]-1;
            int y1 = query[1]-1;
            int x2 = query[2]-1;
            int y2 = query[3]-1;
            int prev = array[x1][y1];
            int min = prev;
            for(int i = y1+1; i < y2+1; i++){
                //x1고정
                int temp = array[x1][i];
                array[x1][i] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }
            for(int i = x1+1; i < x2+1; i++){
                //y2고정
                int temp = array[i][y2];
                array[i][y2] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }
            for(int i = y2-1; i > y1-1; i--){
                //x2고정
                int temp = array[x2][i];
                array[x2][i] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }
            for(int i = x2-1; i > x1-1; i--){
                //y1고정
                int temp = array[i][y1];
                array[i][y1] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }
            list.add(min);
        }
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
