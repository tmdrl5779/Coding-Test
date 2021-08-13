package com.company.level_1;

public class 로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};

        int count = 0;
        int zeroCount = 0;
        for(int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                if (win_nums[j] == lottos[i]) count ++;
            }

            if (lottos[i] == 0){
                zeroCount ++;
            }
        }

        int min = rankCul(count);
        int max = rankCul(count + zeroCount);

        return new int[]{max, min};
    }

    public int rankCul(int count){
        int rank = 0;
        if (count == 6) rank = 1;
        else if(count == 5) rank = 2;
        else if(count == 4) rank = 3;
        else if(count == 3) rank = 4;
        else if(count == 2) rank = 5;
        else rank = 6;

        return rank;


    }
}
