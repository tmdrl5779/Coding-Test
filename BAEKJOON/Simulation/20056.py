from collections import deque

n, m, k = map(int, input().split(' '))
graph = [[0] * n for _ in range(n)]

dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]

for i in range(m):
    r, c, m, s, d = map(int, input().split(' '))  # x, y, 질량, 속력, 방향
    graph[r - 1][c - 1] = [m, s, d, 1]  # 0합쳐지는 개수


def solve():
    queue = deque()
    for i in range(n):
        for j in range(n):
            if graph[i][j] != 0:
                m = graph[i][j][0]
                s = graph[i][j][1]
                d = graph[i][j][2]
                if graph[i][j][3] == 1:
                    nx, ny = i + dx[d] * s, j + dy[d] * s
                    nx, ny = position(nx, ny)
                    queue.append([nx, ny, m, s, d])
                else:
                    start = 0
                    if not graph[i][j][2]:
                        start = 1
                    for k in range(start, 8, 2):
                        nx, ny = i + dx[k] * s, j + dy[k] * s
                        nx, ny = position(nx, ny)
                        queue.append([nx, ny, m, s, k])

            graph[i][j] = 0

    while queue:
        x, y, m, s, d = queue.popleft()
        cnt = 1
        if graph[x][y] == 0:
            graph[x][y] = [m, s, d, cnt]
        else:
            graph[x][y][0] += m
            graph[x][y][1] += s
            graph[x][y][3] += 1
            if graph[x][y][3] == 2:
                graph[x][y][2] %= 2
                graph[x][y][2] += (d % 2)
            else:
                graph[x][y][2] += (d % 2)



def position(nx, ny):
    abs_x = abs(nx) % n
    abs_y = abs(ny) % n
    if nx < 0:
        while nx < 0:
            nx += n
        abs_x = nx
    if ny < 0:
        while ny < 0:
            ny += n
        abs_y = ny
    return abs_x, abs_y


for _ in range(k):
    solve()
    for i in range(n):
        for j in range(n):
            if graph[i][j] != 0 and graph[i][j][3] > 1:
                m = graph[i][j][0] // 5
                if m == 0:
                    graph[i][j] = m
                    continue
                graph[i][j][0] = m
                s = graph[i][j][1] // graph[i][j][3]
                graph[i][j][1] = s
                if graph[i][j][2] == 0 or graph[i][j][2] == graph[i][j][3]:
                    graph[i][j][2] = True
                else:
                    graph[i][j][2] = False

answer = 0
for i in range(n):
    for j in range(n):
        if graph[i][j] != 0:
            if graph[i][j][3] > 1:
                answer += (graph[i][j][0] * 4)
            else:
                answer += graph[i][j][0]

print(answer)
