package com.company.level3;

import java.util.*;

public class 네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            dfs(computers, visited, i);
            answer++;
        }

        return answer;
    }

    public void bfs(int[][] computers, boolean[] visited, int start){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()){
            int pop = queue.remove();

            for(int i = 0; i < computers[pop].length; i++){
                int next = -1;
                if(pop != i && computers[pop][i] == 1){
                    next = i;
                }
                if(next == -1 || visited[next]) continue;

                queue.add(next);
                visited[next] = true;

            }

        }
    }

    public void dfs(int[][] computer, boolean[] visited, int start){
        visited[start] = true;

        for(int i = 0; i < computer[start].length; i++){
            if(visited[i]) continue;
            if(start == i || computer[start][i] != 1) continue;

            visited[i] = true;
            dfs(computer, visited, i);
        }

    }
}
