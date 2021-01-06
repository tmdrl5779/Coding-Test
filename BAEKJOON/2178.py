import sys
from collections import deque

input = sys.stdin.readline
n, m = map(int, input().split())
graph = [list(map(int, input().strip())) for _ in range(n)]
visited = [[False] * m for _ in range(n)]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def Bfs(cur_x, cur_y, graph, visited):
    queue = deque()
    queue.append((cur_x, cur_y))
    visited[cur_x][cur_y] = True

    while queue:
        pop_x, pop_y = queue.popleft()

        for i in range(4):
            next_x = pop_x + dx[i]
            next_y = pop_y + dy[i]
            if next_x <= -1 or next_x >= n or next_y <= -1 or next_y >= m:
                continue
            if not visited[next_x][next_y] and graph[next_x][next_y] != 0:
                queue.append((next_x, next_y))
                visited[next_x][next_y] = True
                graph[next_x][next_y] = graph[pop_x][pop_y] + 1

Bfs(0, 0, graph, visited)

print(graph[n-1][m-1])