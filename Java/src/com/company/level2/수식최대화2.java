package com.company.level2;

import java.util.*;

public class 수식최대화2 {
    long max = 0;

    public long solution(String expression) {
        long answer = 0;
        String[] number = expression.split("[-+*]");
        String[] signs = expression.split("[0-9]+");
        String[] sign = {"+", "-", "*"};
        List<String> exp = new ArrayList<>();
        exp.add(number[0]);
        for (int i = 1; i < signs.length; i++) {
            exp.add(signs[i]);
            exp.add(number[i]);
        }

        dfs(exp, sign, new boolean[3], 0, new Stack<String>());

        answer = max;
        return answer;
    }


    public void dfs(List<String> exp, String[] sign, boolean[] visited, int depth,
                    Stack<String> signPermutation) {
        if (depth == sign.length) {
            List<String> expCopy = new ArrayList<>();
            expCopy.addAll(exp);

            for (int i = 0; i < signPermutation.size(); i++) {
                String s = signPermutation.get(i);
                while (expCopy.contains(s)) {
                    int signIndex = expCopy.indexOf(s);
                    long left = Long.parseLong(expCopy.get(signIndex - 1));
                    long right = Long.parseLong(expCopy.get(signIndex + 1));

                    if (s.equals("+")){
                        expCopy.set(signIndex -1, String.valueOf(left + right));
                    }else if(s.equals("-")){
                        expCopy.set(signIndex -1, String.valueOf(left - right));
                    }else{
                        expCopy.set(signIndex -1, String.valueOf(left * right));
                    }

                    List<String> front = expCopy.subList(0, signIndex);
                    List<String> back = expCopy.subList(signIndex+2, expCopy.size());
                    List<String> join = new ArrayList<>();

                    join.addAll(front);
                    join.addAll(back);
                    expCopy = join;
                }
            }
            max = Math.max(max, Math.abs(Long.parseLong(expCopy.get(0))));

            return;
        }

        for (int i = 0; i < sign.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            signPermutation.push(sign[i]);
            dfs(exp, sign, visited, depth + 1, signPermutation);
            signPermutation.pop();
            visited[i] = false;
        }

    }
}
