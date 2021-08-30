package com.company.baekjoon;

import java.util.Arrays;

public class _11657번 {
    public long[] solution(int[][] edge, int n, int m) {
        long[] answer = {};

        long[] dist = new long[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);

        if(!bellman(edge, dist, n, m, 1)){
            answer = new long[]{-1};
        }else{
            answer = new long[n-1];

            for(int i = 0; i< answer.length; i++){
                if(dist[i+2] == Long.MAX_VALUE){
                    answer[i] = -1;
                }else{
                    answer[i] = dist[i+2];
                }
            }
        }
        return answer;
    }

    public boolean bellman(int[][] edge, long[] dist, int n, int m, int start){
        dist[start] = 0;


        for(int i = 0; i < n; i++){ //node count
            for(int j = 0; j < m; j++){ //edge count
                int[] subEdge = edge[j];
                int now = subEdge[0];
                int next = subEdge[1];
                int val = subEdge[2];

                if(dist[now] == Long.MAX_VALUE) continue;

                if(dist[next] > dist[now] + val){
                    dist[next] = dist[now] + val;

                    if(i == n-1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
