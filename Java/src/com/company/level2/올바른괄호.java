package com.company.level2;

import java.util.Stack;

public class 올바른괄호 {
    public boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else{
                char c = s.charAt(i);

                if(c == ')'){
                    if(stack.peek() == '('){
                        stack.pop();
                    }else{
                        stack.push(c);
                    }
                }else{
                    stack.push(c);
                }
            }
        }

        if(!stack.isEmpty()){
            answer = false;
        }

        return answer;
    }
}
