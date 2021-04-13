import math
from collections import deque

n = int(input())
graph = [list(map(int, input().split(' '))) for _ in range(n)]
fish = list()

d_x = [-1, 0, 1, 0]
d_y = [0, 1, 0, -1]

for i in range(n):
    for j in range(n):
        if graph[i][j] != 0 and graph[i][j] != 9:
            fish.append((i, j, graph[i][j]))
        if graph[i][j] == 9:
            c_x, c_y = i, j


def solve(c_x, c_y):
    size = 2
    time = 0
    eat = 0
    if not fish:
        return time

    while fish:
        small_fish = list()
        i = 0
        for n_x, n_y, fish_size in fish:
            if fish_size < size:
                small_fish.append([n_x, n_y, graph[n_x][n_y], i])
            i += 1

        if len(small_fish) == 0:  # 끝
            return time
        else:  # 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
            n_x, n_y, dist, idx = bfs(c_x, c_y, small_fish, size)
            if dist == math.inf:
                break
            graph[n_x][n_y] = 9
            graph[c_x][c_y] = 0
            c_x, c_y = n_x, n_y
            fish.pop(idx)
            eat += 1
            time += dist

        if eat == size:
            size += 1
            eat = 0

    return time


def bfs(c_x, c_y, small_fish: list, size):
    visited = [[-1] * n for _ in range(n)]
    visited[c_x][c_y] = 0

    queue = deque()
    queue.append((c_x, c_y))

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

    min_dist = math.inf
    min_idx = math.inf
    min_x = math.inf
    min_y = math.inf
    for i in range(len(small_fish)):
        x, y, small_size, idx = small_fish[i]
        if visited[x][y] == -1:
            continue
        if visited[x][y] <= min_dist:
            if visited[x][y] == min_dist:
                if x <= min_x:
                    if x == min_x:
                        if y < min_y:
                            min_dist = visited[x][y]
                            min_x, min_y = x, y
                            min_idx = idx
                            continue
                        continue
                    continue
                continue

            min_dist = visited[x][y]
            min_x, min_y = x, y
            min_idx = idx

    return min_x, min_y, min_dist, min_idx


print(solve(c_x, c_y))
