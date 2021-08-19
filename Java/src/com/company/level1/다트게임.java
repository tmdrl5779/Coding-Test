package com.company.level1;

import java.util.regex.*;

public class 다트게임 {
    public int solution(String dartResult) {
        int answer = 0;
        int[] points = new int[3];

        Pattern p = Pattern.compile("[0-9]{1,}[SDT][#*]?");
        Matcher m = p.matcher(dartResult);

        int i = 0;
        while(m.find()){
            String s = m.group();

            Pattern p1 = Pattern.compile("[0-9]{1,}");
            Matcher m1 = p1.matcher(s);
            if(m1.find()){
                points[i] = Integer.parseInt(m1.group());
            }

            Pattern p2 = Pattern.compile("[SDT]");
            Matcher m2 = p2.matcher(s);
            if(m2.find()){
                if (m2.group().equals("D")) points[i] = (int) Math.pow(points[i], 2);
                else if (m2.group().equals("T")) points[i] = (int) Math.pow(points[i], 3);
            }

            Pattern p3 = Pattern.compile("[#*]");
            Matcher m3 = p3.matcher(s);
            while(m3.find()){
                System.out.println(m3.group());
                if (m3.group().equals("#")) points[i] = -points[i];
                else if(m3.group().equals("*")) {
                    points[i] *= 2;
                    if(i != 0) points[i-1] *= 2;
                }
            }
            i++;
        }

        for (i = 0; i < 3; i++){
            answer += points[i];
        }

        return answer;
    }
}
