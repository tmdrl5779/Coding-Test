import sys
input = sys.stdin.readline

r, c, t = map(int, input().split(' '))
graph = [list(map(int, input().split(' '))) for _ in range(r)]

d_x = [-1, 0, 1, 0]
d_y = [0, 1, 0, -1]


def diffusion(graph: list):
    new_graph = [temp[:] for temp in graph]

    for i in range(r):
        for j in range(c):

            if graph[i][j] == 0 or graph[i][j] == -1:
                continue

            now_dust = graph[i][j]
            cnt = 0
            for k in range(4):
                n_x = i + d_x[k]
                n_y = j + d_y[k]

                if n_x < 0 or n_x >= r or n_y < 0 or n_y >= c:
                    continue
                if graph[n_x][n_y] == -1:
                    continue

                cnt += 1

            div_dust = now_dust // 5
            for k in range(4):
                n_x = i + d_x[k]
                n_y = j + d_y[k]

                if n_x < 0 or n_x >= r or n_y < 0 or n_y >= c:
                    continue
                if graph[n_x][n_y] == -1:
                    continue

                new_graph[n_x][n_y] += div_dust

            new_graph[i][j] -= (div_dust * cnt)

    return new_graph


def work_air():
    f_x = None
    for i in range(r):
        if graph[i][0] == -1:
            f_x = i
            break
    s_x = f_x + 1

    up_prev_dust = graph[f_x][1]
    down_prev_dust = graph[s_x][1]
    for j in range(1, c):
        if graph[f_x][j - 1] == -1:
            graph[f_x][j] = 0
            graph[s_x][j] = 0
        else:
            temp = graph[f_x][j]
            temp2 = graph[s_x][j]
            graph[f_x][j] = up_prev_dust
            graph[s_x][j] = down_prev_dust
            up_prev_dust = temp
            down_prev_dust = temp2

    for i in range(f_x - 1, -1, -1):
        temp = graph[i][c - 1]
        graph[i][c - 1] = up_prev_dust
        up_prev_dust = temp

    for i in range(s_x + 1, r):
        temp2 = graph[i][c-1]
        graph[i][c -1] = down_prev_dust
        down_prev_dust = temp2

    for j in range(c-2, -1, -1):
        temp = graph[0][j]
        temp2 = graph[r-1][j]
        graph[0][j] = up_prev_dust
        graph[r-1][j] = down_prev_dust
        up_prev_dust = temp
        down_prev_dust = temp2

    for i in range(1, f_x):
        temp = graph[i][0]
        graph[i][0] = up_prev_dust
        up_prev_dust = temp

    for i in range(r-2, s_x, -1):
        temp2 = graph[i][0]
        graph[i][0] = down_prev_dust
        down_prev_dust = temp2

for i in range(t):
    graph = diffusion(graph)
    work_air()

answer = 0

for i in range(r):
    for j in range(c):
        if graph[i][j] == -1:
            continue
        else:
            answer += graph[i][j]

print(answer)

