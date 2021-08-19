package com.company.level1;

public class 문자열을정수로바꾸기 {
    public int solution(String s) {
        int answer = 0;
        if (!Character.isDigit(s.charAt(0))) {
            char sign = s.charAt(0);
            s = s.replaceAll("[+-]", "");
            answer = Integer.parseInt(s);
            if (sign == '-') {
                answer = -answer;
            }
        } else {
            answer = Integer.parseInt(s);
        }

        return answer;
    }
}
