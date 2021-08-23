package com.company.level2;

import java.util.*;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int[] day = new int[speeds.length];

        for (int i = 0; i < speeds.length; i++) {
            day[i] = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                day[i] += 1;
            }
        }

        int prev = day[0];
        int count = 1;
        for (int i = 1; i < day.length; i++) {
            if (prev < day[i]) {
                list.add(count);
                count = 1;
                prev = day[i];
            } else {
                count++;
            }
        }
        list.add(count);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;

    }
}
