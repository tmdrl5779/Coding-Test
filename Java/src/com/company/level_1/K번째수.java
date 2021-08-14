package com.company.level_1;

import java.util.Arrays;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i< commands.length; i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int find = commands[i][2];
            int[] copyArray = Arrays.copyOfRange(array, start-1, end);

            Arrays.sort(copyArray);

            answer[i] = copyArray[find-1];
        }
        return answer;
    }
}
