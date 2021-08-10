package com.company;

import com.company.level_1.Weekly;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Weekly test = new Weekly();

        int[][] a = {{100, 90, 98, 88, 65}, {50, 45, 99, 85, 77}, {47, 88, 95, 80, 67}, {61, 57, 100, 80, 65}, {24, 90, 94, 75, 65}};

        System.out.println(test.solution(a));

    }
}
