package com.company.level_1;

import java.util.Arrays;

public class 문자열내마음대로정렬하기 {

    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];


        Arrays.sort(strings, (o1, o2) -> {
            if (o1.charAt(n) > o2.charAt(n)){
                return 1;
            }else if (o1.charAt(n) < o2.charAt(n)){
                return -1;
            }else{
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < strings.length; i++) {
            answer[i] = strings[i];
        }

        return answer;
    }
}
