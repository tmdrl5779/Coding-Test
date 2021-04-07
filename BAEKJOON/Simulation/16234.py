from collections import deque

n, l, r = map(int, input().split(' '))
graph = [list(map(int, input().split(' '))) for _ in range(n)]

d_x = [-1, 0, 1, 0]
d_y = [0, 1, 0, -1]

is_move = False


def bfs(c_x, c_y, visited, grpah, x):
    global is_move
    people = graph[c_x][c_y]
    count = 1
    queue = deque()
    queue.append((c_x, c_y))
    visited[c_x][c_y] = x

    while queue:
        pop_x, pop_y = queue.popleft()

        for i in range(4):
            n_x = pop_x + d_x[i]
            n_y = pop_y + d_y[i]

            if n_x < 0 or n_x >= n or n_y < 0 or n_y >= n:
                continue

            if visited[n_x][n_y] != 0:
                continue

            if l <= abs(grpah[pop_x][pop_y] - grpah[n_x][n_y]) <= r:
                visited[n_x][n_y] = x
                queue.append((n_x, n_y))
                people += graph[n_x][n_y]
                count += 1

    move_people = people // count

    if count > 1:
        is_move = True

        for i in range(n):
            for j in range(n):
                if visited[i][j] == x:
                    graph[i][j] = move_people
    elif count == 1:
        visited[c_x][c_y] = 0

answer = 0

while True:
    is_move = False
    visited = [[0] * n for _ in range(n)]
    x = 0
    for i in range(n):
        for j in range(n):
            if visited[i][j] == 0:
                x += 1
                bfs(i, j, visited, graph, x)

    if is_move:
        answer += 1
    else:
        break

print(answer)
