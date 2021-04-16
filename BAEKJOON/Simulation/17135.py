import heapq
from collections import deque

n, m, d = map(int, input().split(' '))

graph = [list(map(int, input().split(' '))) for _ in range(n)]

visitied = [False] * m

max_kill = 0


def combination(start, depth):
    global max_kill
    if depth == 3:
        graph_copy = [copy_itme[:] for copy_itme in graph]
        graph_copy.append(visitied)

        kill = 0
        while True:
            is_enemy = False
            for i in range(n):
                for j in range(m):
                    if graph_copy[i][j] == 1:
                        is_enemy = True
                        break
            if not is_enemy:
                break
            else:
                kill_enemy = list()
                for i in range(m):
                    if visitied[i]:
                        enemy_d, x, y = bfs(n, i, graph_copy)
                        # 적 좌표
                        if enemy_d != -1:
                            kill_enemy.append((x, y))
                # 적 죽이기
                while kill_enemy:
                    enemy_x, enemy_y = kill_enemy.pop()
                    if graph_copy[enemy_x][enemy_y] == 1:
                        graph_copy[enemy_x][enemy_y] = 0
                        kill += 1

                # 적 움직이기
                for i in range(n-1, 0, -1):
                    for j in range(m):
                        graph_copy[i][j] = graph_copy[i - 1][j]
                for j in range(m):
                    graph_copy[0][j] = 0

        max_kill = max(max_kill, kill)
        return

    for i in range(start, m):

        if visitied[i]:
            continue

        visitied[i] = True
        combination(i, depth + 1)
        visitied[i] = False


dx = [-1, 0, 0]
dy = [0, 1, -1]


def bfs(x, y, graph_copy : list):
    queue = deque()
    grpah_visited = [[0] * (m) for _ in range(n + 1)]
    grpah_visited[x][y] = 1
    queue.append((x, y))

    while queue:
        pop_x, pop_y = queue.popleft()

        if grpah_visited[pop_x][pop_y] - 1 == d:
            continue

        for i in range(3):
            nx, ny = pop_x + dx[i], pop_y + dy[i]

            if nx < 0 or nx > n or ny < 0 or ny >= m:
                continue
            if grpah_visited[nx][ny] != 0:
                continue

            queue.append((nx, ny))
            grpah_visited[nx][ny] = grpah_visited[pop_x][pop_y] + 1

    # 죽일 적의 좌표
    enemy_position = list()

    for i in range(n):
        for j in range(m):
            if -1 < grpah_visited[i][j] - 1 <= d and graph_copy[i][j] == 1:
                enemy_position.append((grpah_visited[i][j] - 1, i, j))

    enemy_position.sort(key=lambda x: (x[0], x[2]))
    if enemy_position:
        return enemy_position[0]
    else:
        return -1, -1, -1


combination(0, 0)
print(max_kill)
