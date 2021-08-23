package com.company.level2;

import java.util.Queue;

public class 프린터 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int priority : priorities)
            queue.add(priority);

        while(true){
            int first = queue.remove();
            boolean isFirstBig = true;

            for(int priority : queue){
                if (first < priority){
                    isFirstBig = false;
                    break;
                }
            }

            if(isFirstBig){
                answer += 1;
            } else{
                queue.add(first);
                location -= 1;
                if(location < 0) location = queue.size()-1;
            }

            if(location == 0) break;

        }

        return answer;
    }
}
