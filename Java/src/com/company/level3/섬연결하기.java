package com.company.level3;

import java.util.Arrays;

public class 섬연결하기 {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];

        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }

        Arrays.sort(costs, (o1, o2) ->{
            return Integer.compare(o1[2], o2[2]);
        });

        for(int[] edge : costs){
            int start = edge[0];
            int end = edge[1];
            int cost = edge[2];

            int startParent = findParent(parent, start);
            int endParent = findParent(parent, end);

            if(startParent != endParent){
                int parentNode = Math.max(startParent, endParent);
                int childNode = Math.min(startParent, endParent);
                union(parent, parentNode, childNode);
                answer += cost;
            }
        }

        return answer;
    }

    public int findParent(int[] parent, int p){
        if(parent[p] == p){
            return p;
        }

        return findParent(parent, parent[p]);

    }

    public void union(int[] parent, int parentNode, int childNode){
        for(int i = 0; i < parent.length; i++){
            if(parent[i] == childNode){
                parent[i] = parentNode;
            }
        }
    }

}
