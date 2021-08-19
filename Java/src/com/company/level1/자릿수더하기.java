package com.company.level1;

public class 자릿수더하기 {
    public int solution(int n) {
        int answer = 0;

        String s = String.valueOf(n);

        for (int i = 0; i < s.length(); i++){
            answer += Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        return answer;
    }
}
