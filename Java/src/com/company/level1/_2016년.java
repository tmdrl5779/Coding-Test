package com.company.level1;

public class _2016년 {
    public String solution(int a, int b) {
        String answer = "";
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] date = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int sum = 0;
        for (int i = 1; i < a; i++) {
            sum += date[i];
        }

        sum = (sum + b - 1) % 7;
        answer = day[sum];

        return answer;
    }
}
