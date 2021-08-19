package com.company.level1;

public class 자연수뒤집어배열로만들기 {
    public int[] solution(long n) {
        String[] s = String.valueOf(n).split("");
        int[] answer = new int[s.length];

        for (int i = 0; i < s.length; i++){
            answer[s.length-i-1] = Integer.parseInt(s[i]);
        }
        return answer;
    }
}
