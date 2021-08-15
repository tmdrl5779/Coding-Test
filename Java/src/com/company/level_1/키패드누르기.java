package com.company.level_1;

import java.util.*;

public class 키패드누르기 {
    public String solution(int[] numbers, String hand) {

        StringBuilder sb = new StringBuilder();
        Map<Integer, int[]> hashMap = new HashMap<>();

        hashMap.put(0, new int[]{3, 1});
        int k = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                hashMap.put(k, new int[]{i, j});
                k++;
            }
        }

        int[] left = {3, 0};
        int[] right = {3, 2};

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                changePosition(left, hashMap, number);
                sb.append("L");
            } else if (number == 3 || number == 6 || number == 9) {
                changePosition(right, hashMap, number);
                sb.append("R");
            } else {
                int distLeft = Math.abs(hashMap.get(number)[0] - left[0])
                        + Math.abs(hashMap.get(number)[1] - left[1]);
                int distRight = Math.abs(hashMap.get(number)[0] - right[0])
                        + Math.abs(hashMap.get(number)[1] - right[1]);

                if (distLeft < distRight) {
                    changePosition(left, hashMap, number);
                    sb.append("L");
                } else if (distLeft > distRight) {
                    changePosition(right, hashMap, number);
                    sb.append("R");
                } else {
                    if (hand.equals("left")) {
                        changePosition(left, hashMap, number);
                        sb.append("L");
                    } else {
                        changePosition(right, hashMap, number);
                        sb.append("R");
                    }
                }

            }
        }
        String answer = new String(sb);

        return answer;
    }

    public void changePosition(int[] rightOrLeft, Map<Integer, int[]> hashMap, int number){
        rightOrLeft[0] = hashMap.get(number)[0];
        rightOrLeft[1] = hashMap.get(number)[1];
    }
}
