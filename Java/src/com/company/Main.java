package com.company;

import com.company.level_1.Weekly;
import com.company.level_1.모의고사;
import com.company.level_1.신규아이디추천;
import com.company.level_1.크레인인형뽑기게임;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        크레인인형뽑기게임 test = new 크레인인형뽑기게임();
        test.solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4});

    }
}
