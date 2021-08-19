package com.company.level1;

public class 최대공약수와최소공배수 {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int max = Math.max(n, m);
        int min = Math.min(n, m);

        while (min != 0){
            int temp = max % min;
            max = min;
            min = temp;
        }

        answer[0] = max;
        answer[1] = n * m / max;

        return answer;
    }
}
