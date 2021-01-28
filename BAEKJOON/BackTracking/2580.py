graph = [list(map(int, input().split())) for _ in range(9)]

def BackT(idx):
    if idx == 81:
        return True

    for i in range(idx, 81):
        sub_n = i // 9
        sub_m = i % 9

        if graph[sub_n][sub_m] != 0:
            if i == 80:
                return True
            continue

        ableNumber = AbleNumber(sub_n, sub_m)
        for j in ableNumber:
            graph[sub_n][sub_m] = j
            if BackT(i + 1):
                return True
            graph[sub_n][sub_m] = 0
        return False

def AbleNumber(n, m):
    ableNumber = [1, 2, 3, 4, 5, 6, 7, 8, 9]

    for i in range(9):
        if graph[n][i] in ableNumber:
            ableNumber.remove(graph[n][i])

    for i in range(9):
        if graph[i][m] in ableNumber:
            ableNumber.remove(graph[i][m])

    sub_n = n // 3
    sub_m = m // 3

    for i in range(sub_n * 3, sub_n * 3 + 3):
        for j in range(sub_m * 3, sub_m * 3 + 3):
            if graph[i][j] in ableNumber:
                ableNumber.remove(graph[i][j])
    return ableNumber

BackT(0)
for i in range(9):
    for j in range(9):
        print(graph[i][j], end=' ')
    print()