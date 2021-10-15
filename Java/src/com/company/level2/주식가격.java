package com.company.level2;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int count = 0;

            for (int j = i + 1; j < prices.length; j++) {
                count++;
                if (prices[i] > prices[j]) break;
            }

            if (count == 0 && i != prices.length - 1)
                count = 1;

            answer[i] = count;
        }
        return answer;
    }
}
