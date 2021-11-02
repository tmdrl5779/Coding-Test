package com.company.level2;

public class 방문길이 {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] graph = new boolean[11][11][4];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int cX = 5;
        int cY = 5;


        for(int i = 0; i < dirs.length(); i++){

            char d = dirs.charAt(i);
            int nX = -1;
            int nY = -1;

            if(d == 'U'){
                nX = cX + dx[0];
                nY = cY + dy[0];
                if(nX < 0 || nX > 10 || nY < 0 || nY > 10) continue;
                if(!graph[nX][nY][0]) answer++;
                graph[nX][nY][0] = true;
                graph[cX][cY][2] = true;

            }else if(d == 'R'){
                nX = cX + dx[1];
                nY = cY + dy[1];
                if(nX < 0 || nX > 10 || nY < 0 || nY > 10) continue;
                if(!graph[nX][nY][1]) answer++;
                graph[nX][nY][1] = true;
                graph[cX][cY][3] = true;
            }else if(d == 'D'){
                nX = cX + dx[2];
                nY = cY + dy[2];
                if(nX < 0 || nX > 10 || nY < 0 || nY > 10) continue;
                if(!graph[nX][nY][2]) answer++;
                graph[nX][nY][2] = true;
                graph[cX][cY][0] = true;
            }else{
                nX = cX + dx[3];
                nY = cY + dy[3];
                if(nX < 0 || nX > 10 || nY < 0 || nY > 10) continue;
                if(!graph[nX][nY][3]) answer++;
                graph[nX][nY][3] = true;
                graph[cX][cY][1] = true;
            }

            cX = nX;
            cY = nY;

        }


        return answer;
    }
}
