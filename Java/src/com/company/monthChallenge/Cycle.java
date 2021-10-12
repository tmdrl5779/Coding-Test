package com.company.monthChallenge;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Cycle {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int d = 0;

    public int[] solution(String[] grid) {
        int[] answer = {};
        Set<Integer> set = new TreeSet<>();

        int row = grid.length;
        int col = grid[0].length();

        char[][] graph = new char[row][col];

        for(int i = 0; i < row; i++){
            graph[i] = grid[i].toCharArray();
        }

        for(int i = 0; i < 4; i++){
            d = i;
            boolean[][][] visited = new boolean[row][col][4];  // [][][0]아래, [][][1]오른쪽, [][][2]위, [][][3]왼쪽
            set.add(cycle(visited, graph));
        }
        answer = new int[set.size()];

        int i = 0;
        for(Integer value : set){
            answer[i] = value;
            i++;
        }

        return answer;
    }


    public int cycle(boolean[][][] visited, char[][] graph){
        int startX = 0;
        int startY = 0;
        int row = graph.length;
        int col = graph[0].length;
        int count = 0;

        while(!visited[startX][startY][d]){
            visited[startX][startY][d] = true;
            count ++;

            if(graph[startX][startY] == 'L'){
                d = (d + 1) % 4;
                if(d < 0){
                    d = 3;
                }
            }else if (graph[startX][startY] == 'R'){
                d = (d - 1) % 4;
                if(d < 0){
                    d = 3;
                }
            }

            int nextX = (startX + dx[d]) % row;
            int nextY = (startY + dy[d]) % col;

            if(nextX < 0){
                nextX = row - 1;
            }
            if(nextY < 0){
                nextY = col - 1;
            }

            startX = nextX;
            startY = nextY;

        }

        return count;


    }
}
