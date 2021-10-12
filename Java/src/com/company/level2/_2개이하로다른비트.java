package com.company.level2;

public class _2개이하로다른비트 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            long num = numbers[i];
            long num2 = num >> 2;

            num2 = num2 << 2;
            num2 = num2 | 3;

            if(num2 == num){
                answer[i] = num + 1;
                answer[i] = answer[i] | num;

                long temp = ~((answer[i] - num) / 2);

                answer[i] = answer[i] & temp;

            }else{
                answer[i] = num+1;
            }
        }

        return answer;
    }
}
