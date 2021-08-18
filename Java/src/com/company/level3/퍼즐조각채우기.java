package com.company.level3;

import java.util.*;

public class 퍼즐조각채우기 {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;

        boolean[][] visitedTable = new boolean[table.length][table.length];
        boolean[][] visitedBoard = new boolean[game_board.length][game_board.length];
        List<String> boardList = new ArrayList<>();
        List<String> tableList = new ArrayList<>();
        //0:상, 1:우, 2:하, 3:좌

        for (int i = 0; i < table.length; i++){
            for (int j = 0; j < table.length; j++){

                if (table[i][j] == 1 && !visitedTable[i][j]){
                    StringBuilder sb = new StringBuilder();
                    tableList.add(bfs(i, j, visitedTable, table, 1, sb));
                }

                if (game_board[i][j] == 0 && !visitedBoard[i][j]){
                    StringBuilder sb = new StringBuilder();
                    boardList.add(bfs(i, j, visitedBoard, game_board, 0, sb));
                }


            }
        }

        findBlock(boardList, tableList);

        return answer;
    }

    public int findBlock(List<String> board, List<String> table){
        int size = 0;
        List<String> list = new ArrayList<>();
        for (String s : table) {
            if (board.contains(s)){
                size += s.length()+1;
                board.remove(s);
                list.add(s);
            }
        }
        for (String s : list){
            table.remove(s);
        }

        return size;
    }

    public String bfs(int currentX, int currentY, boolean[][] visited, int[][] graph,
                      int blockOrEmpty, StringBuilder sb){

        Queue<int[]> queue = new LinkedList<>();
        visited[currentX][currentY] = true;
        queue.add(new int[]{currentX, currentY});

        while (!queue.isEmpty()){
            int[] pop = queue.remove();
            int popX = pop[0];
            int popY = pop[1];

            for (int i = 0; i < 4; i++){
                int nextX = popX + dx[i];
                int nextY = popY + dy[i];
                if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph.length){
                    continue;
                }
                if (!visited[nextX][nextY] && graph[nextX][nextY] == blockOrEmpty){

                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                    sb.append(i);

                }

            }

        }
        return sb.toString();

    }
}
