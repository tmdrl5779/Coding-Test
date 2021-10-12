package com.company.level3;

import java.util.*;

public class 가장먼노드 {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        int[] dist = new int[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra(1, edge, dist);

        int max = 0;
        for(int i = 0; i < dist.length; i++){
            if(dist[i] == Integer.MAX_VALUE) continue;
            max = Math.max(max, dist[i]);
        }
        for(int i = 0; i < dist.length; i++){
            if(max == dist[i]) answer++;
        }


        return answer;
    }

    public void dijkstra(int start, int[][] edge, int[] dist){
        dist[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);


        while(!queue.isEmpty()){

            int pop = queue.remove();

            for(int i = 0; i < edge.length; i++){
                if(edge[i][0] == pop || edge[i][1] == pop){
                    int next = edge[i][1];
                    if(edge[i][1] == pop) next = edge[i][0];


                    if(dist[next] > dist[pop] + 1){
                        dist[next] = dist[pop] + 1;
                        queue.add(next);
                    }

                }

            }

        }
    }
}
