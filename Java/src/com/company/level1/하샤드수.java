package com.company.level1;

public class 하샤드수 {
    public boolean solution(int x) {
        boolean answer = false;
        String[] s = String.valueOf(x).split("");
        int sum = 0;

        for (int i = 0; i < s.length; i++){
            sum += Integer.parseInt(s[i]);
        }
        if (x % sum == 0) answer = true;

        return answer;
    }
}
