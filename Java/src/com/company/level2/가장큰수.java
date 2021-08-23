package com.company.level2;

import java.util.Arrays;
import java.util.Stack;

public class 가장큰수 {
    public String solution(int[] numbers) {
        String answer = "";
        String[] sa = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++){
            sa[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(sa, (o1, o2) -> {
            if(o1.charAt(0)>o2.charAt(0)) return -1;
            else if(o1.charAt(0)<o2.charAt(0)) return 1;
            else{
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        for(int i =0; i< sa.length; i++) {
            if(answer.equals("")){
                if(sa[i].equals("0")) continue;
            }
            answer += sa[i];
        }
        if(answer.equals("")) answer = "0";
        return answer;
    }
}
