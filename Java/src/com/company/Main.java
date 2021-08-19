package com.company;

import com.company.level2.문자열압축;
import com.company.level2.오픈채팅방;
import com.company.level2.카카오프렌즈컬러링북;

public class Main {

    public static void main(String[] args) {
        카카오프렌즈컬러링북 test = new 카카오프렌즈컬러링북();
        test.solution(6, 4, new int[][]{
                {1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}
        });
    }
}
