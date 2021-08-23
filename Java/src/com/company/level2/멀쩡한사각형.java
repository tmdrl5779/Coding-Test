package com.company.level2;

public class 멀쩡한사각형 {
    public long solution(int w, int h) {
        long x = w;
        long y = h;
        long answer = x * y;

        long gcd = gcd(x, y);

        x /= gcd;
        y /= gcd;

        answer = answer - gcd * (x + y - 1);

        return answer;
    }

    public long gcd(long x, long y){
        long max = Math.max(x, y);
        long min = Math.min(x, y);

        while(min != 0){
            long temp = max % min;
            max = min;
            min = temp;
        }
        return max;
    }
}
