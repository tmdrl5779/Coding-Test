package com.company;

import com.company.level_1.Weekly;
import com.company.level_1.모의고사;
import com.company.level_1.신규아이디추천;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4};

    }

    public static int[] solution(int[] lottos, int[] win_nums) {
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


        return new int[]{1, 2};
    }
}
