from collections import deque
import sys

input = sys.stdin.readline
col, row, h = map(int, input().split())
graph = [[list(map(int, input().split())) for _ in range(row)] for _ in range(h)]
visited = [[[False] * col for _ in range(row)] for _ in range(h)]
dx = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]
dz = [0, 0, 0, 0, -1, 1]

def Bfs(queue, graph, visited):
    while queue:
        cur_z, cur_x, cur_y = queue.popleft()

        for i in range(6):
            next_z = cur_z + dz[i]
            next_x = cur_x + dx[i]
            next_y = cur_y + dy[i]

            if 0 <= next_z < h and 0 <= next_x < row and 0 <= next_y < col:
                if not visited[next_z][next_x][next_y] and graph[next_z][next_x][next_y] == 0:
                    visited[next_z][next_x][next_y] = True
                    queue.append((next_z, next_x, next_y))
                    graph[next_z][next_x][next_y] = graph[cur_z][cur_x][cur_y] + 1

queue = deque()
for i in range(h):
    for j in range(row):
        for k in range(col):
            if graph[i][j][k] == 1:
                queue.append((i, j, k))
                visited[i][j][k] = True

Bfs(queue, graph, visited)

zero_flag = False
for i in range(h):
    for j in range(row):
        if 0 in graph[i][j]:
            zero_flag = True
            break

if not zero_flag:
    max_day = 0
    for i in range(h):
        for j in range(row):
            for k in range(col):
                max_day = max(max_day, graph[i][j][k])
    print(max_day - 1)

else:
    print(-1)

