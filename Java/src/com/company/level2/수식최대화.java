package com.company.level2;

import java.util.*;

public class 수식최대화 {

    long max = 0;

    public long solution(String expression) {
        long answer = 0;
        String[] number = expression.split("[-+*]");
        String[] signs = expression.split("[0-9]+");
        String[] sign = {"+", "-", "*"};
        Stack<String> exp = new Stack<>();
        exp.push(number[0]);
        for (int i = 1; i < signs.length; i++) {
            exp.push(signs[i]);
            exp.push(number[i]);
        }

        dfs(exp, sign, new boolean[3], 0, new Stack<String>());

        answer = max;
        return answer;
    }

    public Stack<String> calcul(Stack<String> exp, Stack<String> signPermutation, int depth) {
        Stack<String> stack = new Stack<>();
        String prev = "";

        for (int i = 0; i < exp.size(); i++) {
            if (signPermutation.get(depth).equals(prev)) {
                long left = Long.parseLong(stack.pop());
                long right = Long.parseLong(exp.get(i));
                if (prev.equals("+")) {
                    stack.push(String.valueOf(left + right));
                } else if (prev.equals("-")) {
                    stack.push(String.valueOf(left - right));
                } else {
                    stack.push(String.valueOf(left * right));
                }
                prev = "";
                continue;
            }

            prev = exp.get(i);
            if (!signPermutation.get(depth).equals(exp.get(i))) {
                stack.push(exp.get(i));
            }
        }
        return stack;

    }

    public void dfs(Stack<String> exp, String[] sign, boolean[] visited, int depth,
                    Stack<String> signPermutation) {
        if (depth == sign.length) {
            Stack<String> expCopy = new Stack<>();
            for (int i = 0; i < exp.size(); i++){
                expCopy.push(exp.get(i));
            }
            for (int i = 0; i < signPermutation.size(); i++) {
                expCopy = calcul(expCopy, signPermutation, i);
            }
            if (expCopy.size() == 1){
                long value = Long.parseLong(expCopy.pop());
                max = Math.max(max, Math.abs(value));
            }
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
