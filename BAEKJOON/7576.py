from collections import deque
import sys
input = sys.stdin.readline

col, row = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(row)]

visited = [[False] * col for _ in range(row)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
queue = deque()

def Bfs(queue, graph, visited):
    while queue:
        pop_x, pop_y = queue.popleft()

        for i in range(4):
            next_x = pop_x + dx[i]
            next_y = pop_y + dy[i]

            if next_x <= -1 or next_x >= row or next_y <= -1 or next_y >= col:
                continue
            if not visited[next_x][next_y] and graph[next_x][next_y] == 0:
                queue.append((next_x, next_y))
                visited[next_x][next_y] = True
                graph[next_x][next_y] = graph[pop_x][pop_y] + 1

zero_flag = False
for i in range(row):
    for j in range(col):
        if graph[i][j] == 1:
            queue.append((i, j))

Bfs(queue, graph, visited)

for i in range(row):
    if 0 in graph[i]:
        zero_flag = True
        break

if not zero_flag:
    print(max(map(max, graph)) - 1)
else:
    print(-1)