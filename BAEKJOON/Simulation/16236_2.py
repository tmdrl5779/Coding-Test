import heapq
from collections import deque

n = int(input())
graph = [list(map(int, input().split(' '))) for _ in range(n)]

d_x = [-1, 0, 1, 0]
d_y = [0, 1, 0, -1]

for i in range(n):
    for j in range(n):
        if graph[i][j] == 9:
            c_x, c_y = i, j


def solve(c_x, c_y):
    size = 2
    time = 0
    eat = 0

    while True:
        # 먹을 수 있는 물고기가 있으면 그 물고기를 먹으러 간다.
        heap = bfs(c_x, c_y, size)
        if not heap:
            break
        dist, n_x, n_y = heapq.heappop(heap)
        graph[n_x][n_y] = 9
        graph[c_x][c_y] = 0
        c_x, c_y = n_x, n_y
        eat += 1
        time += dist

        if eat == size:
            size += 1
            eat = 0

    return time


def bfs(c_x, c_y, size):
    visited = [[-1] * n for _ in range(n)]
    visited[c_x][c_y] = 0

    queue = deque()
    queue.append((c_x, c_y))
    heap = list()

    while queue:
        pop_x, pop_y = queue.popleft()

        for i in range(4):
            n_x, n_y = pop_x + d_x[i], pop_y + d_y[i]

            if n_x < 0 or n_x >= n or n_y < 0 or n_y >= n or graph[n_x][n_y] > size:
                continue

            if visited[n_x][n_y] != -1:
                continue

            queue.append((n_x, n_y))
            visited[n_x][n_y] = visited[pop_x][pop_y] + 1
            if 0 < graph[n_x][n_y] < size:
                heapq.heappush(heap, [visited[n_x][n_y], n_x, n_y])

    return heap


print(solve(c_x, c_y))
