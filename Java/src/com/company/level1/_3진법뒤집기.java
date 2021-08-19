package com.company.level1;

public class _3진법뒤집기 {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.insert(0, n % 3);
            n /= 3;
        }

        for (int i = 0; i < sb.length(); i++) {
            answer += Math.pow(3, i) * Integer.parseInt(sb.substring(i, i + 1));
        }
        return answer;
    }
}
