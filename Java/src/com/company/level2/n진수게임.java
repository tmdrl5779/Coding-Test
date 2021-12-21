package com.company.level2;
import java.util.*;


public class n진수게임 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        List<Character> list = new ArrayList<>();
        int num = 0;


        while(list.size() < t*m){
            String s = nConversion(num, n);

            for(int i = 0; i < s.length(); i++){
                list.add(s.charAt(i));
            }
            num++;
        }

        int idx = p-1;
        for(int i = 0; i < t; i++){
            answer.append(list.get(idx));
            idx = idx + m;
        }

        return answer.toString();
    }

    public String nConversion(int number, int n){
        StringBuilder sb = new StringBuilder();

        int current = number;

        while(current > 0){
            if(current % n < 10){
                sb.append(current % n);
            }else{
                sb.append((char)(current%n - 10 + 'A'));
            }

            current /= n;
        }

        if(number == 0) sb.append(0);

        return sb.reverse().toString();
    }
}
