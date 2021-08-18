package com.company;

import com.company.level3.퍼즐조각채우기;
import com.company.level_1.*;

import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        int n = 10;
        int answer = n-1;

        for(int i = 2; i < n+1; i++){
            for(int j = 2; j < Math.sqrt(i); j++){
                if (i % j == 0){
                    answer--;
                    break;
                }
            }
        }

    }
}
