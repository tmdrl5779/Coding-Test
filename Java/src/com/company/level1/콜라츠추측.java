package com.company.level1;

public class 콜라츠추측 {
    public int solution(int num) {
        int answer = 0;
        long longNum = num;
        while (longNum != 1){
            if(answer == 500){
                answer = -1;
                break;
            }
            if (longNum % 2 == 0){
                longNum /= 2;
            }else{
                longNum = longNum * 3 + 1;
            }
            answer ++;
        }

        return answer;
    }
}
