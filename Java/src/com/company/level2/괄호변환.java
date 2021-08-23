package com.company.level2;

import java.util.*;

public class 괄호변환 {
    public String solution(String p) {
        String answer = "";
        StringBuilder sb = new StringBuilder(p);


        answer = recursive(sb).toString();

        return answer;
    }

    public StringBuilder recursive(StringBuilder sb) {
        int div = divide(sb);
        if (sb.toString().equals("")) { //1
            return new StringBuilder();
        }

        StringBuilder u = new StringBuilder(sb.substring(0, div + 1)); //2
        StringBuilder v = new StringBuilder(); //2
        if (u.length() != sb.length()) { //2
            v.append(sb.delete(0, div + 1));
        }
        StringBuilder newU = new StringBuilder();
        StringBuilder newV = new StringBuilder();
        if (isCollect(u)) { //3
            newU.append(u);
            newV.append(recursive(v));
            return new StringBuilder(newU.append(newV)); //3-1
        } else { //4
            newV.append("("); //4-1
            newV.append(recursive(v)); //4-2
            newV.append(")"); //4-3

            u.deleteCharAt(0); //4-4
            u.deleteCharAt(u.length() - 1); //4-4

            for (int i = 0; i < u.length(); i++) { //4-4
                if (u.charAt(i) == ')') {
                    newU.append("(");
                } else {
                    newU.append(")");
                }
            }
            return new StringBuilder(newV.append(newU)); //4-5

        }
    }


    public int divide(StringBuilder sb) {
        int left = 0;
        int right = 0;
        int index = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                index = i;
                break;
            }
        }

        return index;
    }

    public boolean isCollect(StringBuilder sb) {
        boolean collect = false;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(sb.charAt(i));
                continue;
            }

            if (stack.peek() == '(' && sb.charAt(i) == ')') {
                stack.pop();
            } else {
                stack.push(sb.charAt(i));
            }
        }

        if (stack.isEmpty()) {
            collect = true;
        }

        return collect;
    }
}
