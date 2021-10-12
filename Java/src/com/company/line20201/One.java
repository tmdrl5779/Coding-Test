package com.company.line20201;

import java.util.Stack;

public class One {
    int globalAnswer = 0;
    int start = -1;

    public int solution(int[] student, int k) {
        int answer = -1;

        dfs(student, 0, new Stack<>(), k, false, 0);
        answer = globalAnswer;
        return answer;
    }

    public void dfs(int[] student, int detph, Stack<Integer> stack, int k, boolean isRecursive, int startI){

        if(!stack.isEmpty()){
            int kCount = 0;
            for(Integer value : stack){
                kCount += value;
            }
            if(kCount == k){
                globalAnswer++;
            }
        }

        for(int i = startI; i < student.length; i++){
            if(!isRecursive){
                start++;
            }

            if(i-start == detph){
                stack.push(student[i]);
                dfs(student, detph+1, stack, k, true, startI);
                stack.pop();
            }
        }


    }
}
