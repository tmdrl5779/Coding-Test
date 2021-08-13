package com.company.level_1;

import java.util.*;

public class 모의고사 {
    public int[] solution(int[] answers) {


        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int person1_point = 0;
        int person2_point = 0;
        int person3_point = 0;

        for (int i = 0; i < answers.length; i++){

            if (answers[i] == person1[i%person1.length]){
                person1_point++;
            }

            if (answers[i] == person2[i%person2.length]){
                person2_point++;
            }

            if (answers[i] == person3[i%person3.length]){
                person3_point++;
            }
        }

        int max = 0;
        max = Math.max(person1_point, person2_point);
        max = Math.max(max, person3_point);

        int[] points = {person1_point, person2_point, person3_point};
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i< 3; i++){
            if (points[i] == max){
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
