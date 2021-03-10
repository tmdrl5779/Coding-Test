from collections import deque

n = int(input())
graph = [list(map(int, input())) for _ in range(n)]
visitied = [[False] * n for _ in range(n)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(s_x, s_y):
    count = 0
    queue = deque()
    queue.append((s_x, s_y))
    visitied[s_x][s_y] = True

    while queue:
        c_x, c_y = queue.popleft()
        count += 1

        for i in range(4):
            n_x = c_x + dx[i]
            n_y = c_y + dy[i]

            if n_x <= -1 or n_x >= n or n_y <= -1 or n_y >= n:
                continue

            if graph[n_x][n_y] == 1 and not visitied[n_x][n_y]:
                queue.append((n_x, n_y))
                visitied[n_x][n_y] = True

    return count

result = list()
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1 and not visitied[i][j]:
            result.append(bfs(i, j))

result.sort()
print(len(result))
for i in result:
    print(i)
