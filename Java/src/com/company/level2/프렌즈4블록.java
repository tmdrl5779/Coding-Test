package com.company.level2;

import java.util.*;

public class 프렌즈4블록 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        String[][] game = new String[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                game[i][j] = String.valueOf(board[i].charAt(j));
            }
        }
        System.out.println();
        while(true){
            Set<int[]> points = new LinkedHashSet<>();
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(game[i][j].equals("")) continue;

                    checkFour(game, points, i, j);
                }
            }

            if(points.isEmpty()) break;

            for(int[] point : points){
                int x = point[0];
                int y = point[1];

                if(game[x][y].equals("")) continue;

                game[x][y] = "";
                answer++;
            }

            for(int j = 0; j < n; j++){
                for(int i = m-1; i > -1; i--){
                    if(game[i][j].equals("")){
                        for(int k = i-1; k > -1; k--){
                            if(!game[k][j].equals("")){
                                game[i][j] = game[k][j];
                                game[k][j] = "";
                                break;
                            }
                        }
                    }
                }
            }

        }

        return answer;
    }


    public void checkFour(String[][] game, Set<int[]> points, int x, int y){
        String now = game[x][y];

        int[] dx = {0, 1, 1};
        int[] dy = {1, 0, 1};

        for(int i = 0; i < 3; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx > game.length-1 || ny < 0 || ny > game[0].length-1){
                return;
            }

            if(!now.equals(game[nx][ny])){
                return;
            }
        }

        points.add(new int[]{x, y});

        for(int i = 0; i < 3; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            points.add(new int[]{nx, ny});
        }


    }
}
