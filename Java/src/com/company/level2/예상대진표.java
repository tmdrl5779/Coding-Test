package com.company.level2;

public class 예상대진표 {
    public int solution(int n, int a, int b) {
        int answer = 1;

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (true) {

            if (a % 2 != 0 && Math.abs(a - b) == 1) break;

            a = (int) Math.round((double) a / 2);
            b = (int) Math.round((double) b / 2);

            answer++;
        }
        return answer;
    }
}
