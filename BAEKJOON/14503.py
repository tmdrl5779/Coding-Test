row, col = map(int, input().split())
x, y, d = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(row)]
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]  # 북 동 남 서

visited = [[False] * col for _ in range(row)]


def robot(x, y, d, visited):
    clean_count = 1
    turn_count = 0
    while True:
        next_x = x + dx[(d - 1) % 4]
        next_y = y + dy[(d - 1) % 4]
        if not visited[next_x][next_y] and graph[next_x][next_y] == 0:  # 청소x, 벽x
            x, y = next_x, next_y
            d = (d - 1) % 4  # 방향 바꿈
            visited[x][y] = True  # 청소
            clean_count += 1
            turn_count = 0
            continue
        elif visited[next_x][next_y] or graph[next_x][next_y] == 1:  # 벽o, 청소o 방향만 바꿈
            d = (d - 1) % 4
            turn_count += 1

        if turn_count == 4: #후진
            next_x = x + dx[(d + 2) % 4]
            next_y = y + dy[(d + 2) % 4]
            if graph[next_x][next_y] == 0:
                x = next_x
                y = next_y
                turn_count = 0
            else:
                break
    return clean_count


visited[x][y] = True
print(robot(x, y, d, visited))

