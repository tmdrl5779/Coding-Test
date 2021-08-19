package com.company.level1;

import java.util.Arrays;

public class 정수내림차순으로배치하기 {
    public long solution(long n) {
        long answer = 0;
        String[] s = String.valueOf(n).split("");
        Integer[] temp = new Integer[s.length];

        for (int i =0; i < temp.length; i++){
            temp[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(temp, (o1, o2) -> {
            return o2>o1?1 : o2<o1?-1 : 0;
        });
        String sum = "";
        for (int i = 0; i < temp.length; i++){
            sum += temp[i];
        }

        answer = Long.parseLong(sum);

        return answer;
    }
}
