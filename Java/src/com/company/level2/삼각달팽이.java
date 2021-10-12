package com.company.level2;

public class 삼각달팽이 {
    public int[] solution(int n) {
        int[] answer = {};


        int answerLen = 0;
        for(int i = 1; i <= n; i++){
            answerLen += i;
        }
        answer = new int[answerLen];

        int i = 1; //채울 수
        int cycle = 0; //사이클 몇번돌았는지
        int idx = 0;
        int jumpCount = n;
        while(true){
            if(i > answerLen) break;

            //왼쪽 대각선
            int leftIdxCal = 0;
            for(int j = 0; j < n; j++){
                idx = idx + leftIdxCal + cycle;
                answer[idx] = i;
                leftIdxCal++;
                i++;
            }
            n--;

            //마지막
            for(int j = 0; j < n; j++){
                idx += 1;
                answer[idx] = i;
                i++;
            }
            n--;

            //오른쪽 대각선
            int rightIdxCal = jumpCount;
            for(int j = n; j > 0; j--){
                idx = idx - rightIdxCal;
                answer[idx] = i;
                rightIdxCal--;
                i++;
            }

            n--;
            jumpCount--;
            cycle+= 2;
        }

        return answer;
    }
}
