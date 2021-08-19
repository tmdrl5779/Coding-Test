package com.company.level1;

import java.util.*;

public class 두개뽑아서더하기 {
    public int[] solution(int[] numbers) {
        Map<Integer, Boolean> treeMap = new TreeMap<>();
        dfs(new boolean[numbers.length], numbers, 0, 0, treeMap);
        int[] answer = new int[treeMap.size()];
        int i = 0;
        for(Integer key : treeMap.keySet()){
            answer[i] = key;
            i++;
        }

        return answer;
    }

    public void dfs(boolean[] visited, int[] numbers, int depth, int start, Map<Integer, Boolean> treeMap){
        if(depth == 2){
            int sum = 0;
            for(int i = 0; i < visited.length; i++){
                if(visited[i]){
                    sum += numbers[i];
                }
            }
            treeMap.put(sum, true);
            return;
        }

        for(int i = start; i < numbers.length; i++){
            if(visited[i]) continue;

            visited[i] = true;
            dfs(visited, numbers, depth+1, i, treeMap);
            visited[i] = false;

        }

    }
}
