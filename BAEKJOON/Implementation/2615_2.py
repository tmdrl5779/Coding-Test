graph = [list(map(int, input().split(' '))) for _ in range(19)]


def whoWin(x, y):
    color = graph[x][y]

    rowCnt = 0
    nx, ny = None, None
    i = 1
    while True:
        nx, ny = x, y + i
        if nx < 0 or nx >= 19 or ny < 0 or ny >= 19:
            break

        if color == graph[nx][ny]:
            rowCnt += 1
        else:
            break
        i += 1

    # 6목 검사
    px, py = x, y - 1
    if rowCnt == 4:
        if 0 <= px <= 18 and 0 <= py <= 18:
            if graph[px][py] == color:
                return False
        return True

    colCnt = 0
    nx, ny = None, None
    i = 1
    while True:
        nx, ny = x + i, y
        if nx < 0 or nx >= 19 or ny < 0 or ny >= 19:
            break
        if color == graph[nx][ny]:
            colCnt += 1
        else:
            break
        i += 1

    # 6목 검사
    px, py = x - 1, y
    if colCnt == 4:
        if 0 <= px <= 18 and 0 <= py <= 18:
            if graph[px][py] == color:
                return False
        return True

    rightDown = 0
    nx, ny = None, None
    i = 1
    while True:
        nx, ny = x + i, y + i
        if nx < 0 or nx >= 19 or ny < 0 or ny >= 19:
            break
        if color == graph[nx][ny]:
            rightDown += 1
        else:
            break
        i += 1

    # 6목 검사
    px, py = x - 1, y - 1
    if rightDown == 4:
        if 0 <= px <= 18 and 0 <= py <= 18:
            if graph[px][py] == color:
                return False
        return True

    rightUp = 0
    nx, ny = None, None
    i = 1
    while True:
        nx, ny = x - i, y + i
        if nx < 0 or nx >= 19 or ny < 0 or ny >= 19:
            break
        if color == graph[nx][ny]:
            rightUp += 1
        else:
            break
        i += 1
    # 6목 검사
    px, py = x + 1, y - 1
    if rightUp == 4:
        if 0 <= px <= 18 and 0 <= py <= 18:
            if graph[px][py] == color:
                return False
        return True


for i in range(19):
    for j in range(19):
        if graph[i][j] != 0:
            if whoWin(i, j):
                print(graph[i][j])
                print(i + 1, j + 1)
                exit()

print(0)
