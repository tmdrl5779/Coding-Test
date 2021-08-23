package com.company.level2;

import java.util.*;

public class 거리두기확인하기 {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];


        for(int i = 0; i < places.length; i++){
            String[] place = places[i];
            boolean moreTwo = false;
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                    if(place[j].charAt(k) == 'P'){
                        if(isMoreTwo(places[i], new int[5][5], j, k)){
                            moreTwo = true;
                            break;
                        }
                    }
                }
                if(moreTwo) break;
            }
            if(!moreTwo){
                answer[i] = 1;
            }
        }


        return answer;
    }

    public boolean isMoreTwo(String[] graph, int[][] visited, int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = 1;

        while(!queue.isEmpty()){
            int[] pop = queue.remove();
            int cX = pop[0];
            int cY = pop[1];

            for(int i = 0; i < 4; i++){
                int nX = cX + dx[i];
                int nY = cY + dy[i];

                if (nX < 0 || nX > visited.length-1 || nY < 0 || nY > visited.length-1){
                    continue;
                }

                if (visited[nX][nY] == 0 && graph[nX].charAt(nY) != 'X'){
                    queue.add(new int[]{nX, nY});
                    visited[nX][nY] = visited[cX][cY] + 1;
                    if (graph[nX].charAt(nY) == 'P' && visited[nX][nY] <= 3){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
