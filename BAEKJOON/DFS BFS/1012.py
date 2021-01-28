import sys
from collections import deque
input = sys.stdin.readline
sys.setrecursionlimit(100000)

test_count = int(input())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def Bfs(cur_x, cur_y, graph, visited):
    visited[cur_x][cur_y] = True
    queue = deque()
    queue.append((cur_x, cur_y))

    while queue:
        pop_x, pop_y = queue.popleft()

        for i in range(4):
            next_x = pop_x + dx[i]
            next_y = pop_y + dy[i]

            if next_x <= -1 or next_x >= row or next_y <= -1 or next_y >= col:
                continue
            if not visited[next_x][next_y] and graph[next_x][next_y] == 1:
                queue.append((next_x, next_y))
                visited[next_x][next_y] = True


def Dfs(cur_x, cur_y, graph, visited):
    visited[cur_x][cur_y] = True

    for i in range(4):
        next_x = cur_x + dx[i]
        next_y = cur_y + dy[i]

        if next_x <= -1 or next_x >= row or next_y <= -1 or next_y >= col:
            continue
        if not visited[next_x][next_y] and graph[next_x][next_y] == 1:
            Dfs(next_x, next_y, graph, visited)



for i in range(test_count):
    row, col, k = map(int, input().split())
    graph = [[0]*col for _ in range(row)]
    visited = [[False]*col for _ in range(row)]

    for j in range(k):
        x, y = map(int, input().split())
        graph[x][y] = 1

    result = 0
    for i in range(row):
        for j in range(col):
            if not visited[i][j] and graph[i][j] == 1:
                Bfs(i, j, graph, visited)
                #Dfs(i, j, graph, visited)
                result += 1

    print(result)