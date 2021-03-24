n = int(input())
target = int(input())

graph = list([0] * n for _ in range(n))

s_x, s_y = n // 2, n // 2
graph[s_x][s_x] = 1
move = 1

up, u_check = 0, False
right, r_check = 0, False
down, d_check = 0, False
left, l_check = 0, False

for i in range(2, n * n + 1):
    move = int((i - 1) ** (1 / 2))

    if not u_check:
        if up < move:
            s_x -= 1
            graph[s_x][s_y] = i
            up += 1
            continue
        else:
            u_check = True
    up = 0

    if not r_check:
        if right < move:
            s_y += 1
            graph[s_x][s_y] = i
            right += 1
            continue
        else:
            r_check = True
    right = 0

    if not d_check:
        if down < move:
            s_x += 1
            graph[s_x][s_y] = i
            down += 1
            continue
        else:
            d_check = True
    down = 0

    if not l_check:
        if left < move:
            s_y -= 1
            graph[s_x][s_y] = i
            left += 1
            if left != move:
                continue
        else:
            l_check = True
    left = 0

    u_check, r_check, d_check, l_check = False, False, False, False

answer_x, answer_y = -1, -1
for i in range(n):
    for j in range(n):
        print(graph[i][j], end=' ')
        if graph[i][j] == target:
            answer_x, answer_y = i, j
    print()

print(answer_x+1, answer_y+1)
