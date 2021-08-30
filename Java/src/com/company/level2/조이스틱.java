package com.company.level2;

import java.util.Arrays;

public class 조이스틱 {
    public int solution(String name) {
        int answer = 0;
        boolean[] visited = new boolean[name.length()];
        boolean[] allTrue = new boolean[name.length()];
        for(int i = 0; i < visited.length; i++){
            if(name.charAt(i) == 'A') visited[i] = true;
            allTrue[i] = true;
        }

        boolean isRight = true;
        int cursor = 0;
        while(true){ //"ZAAAZZZZZZZ"

            if(Arrays.equals(allTrue, visited)) break;

            int up = 0;
            int down = 0;

            up = name.charAt(cursor) - 'A';
            down = 'Z' - name.charAt(cursor) + 1;

            if(visited[cursor]){
                int right = cursor;
                int left = cursor;
                int rightCount = 0;
                int leftCount = 0;

                if(isRight){
                    right--;
                    left--;
                }else{
                    right++;
                    left++;
                }

                if(right == -1) {
                    right++;
                    left++;
                }

                for(int j = 0; j < visited.length; j++){
                    if(!visited[right]) break;
                    right = (right+1) % visited.length;
                    rightCount++;
                }

                for(int j = 0; j < visited.length; j++){
                    if(!visited[left]) break;
                    left--;
                    if(left == -1) left = visited.length-1;
                    leftCount++;
                }

                if(rightCount <= leftCount) {
                    cursor = right;
                    answer += rightCount;
                    isRight = true;
                } else{
                    cursor = left;
                    answer += leftCount;
                    isRight = false;
                }

                continue;

            }else{
                visited[cursor] = true;
                answer += Math.min(up, down);
                if(isRight){
                    cursor= (cursor + 1) %visited.length;
                }else{
                    cursor--;
                    if(cursor == -1) cursor = visited.length-1;
                }
                if(!visited[cursor]) answer++;
            }
        }

        return answer;
    }
}
