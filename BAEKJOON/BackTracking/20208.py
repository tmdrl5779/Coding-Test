n, hp, hp_puls = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(n)]

max_mint = 0
eat_mint = 0
start_x = -1
start_y = -1
mint_position = list()

for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            start_x = i
            start_y = j
            mint_position.append((i, j))
        elif graph[i][j] == 2:
            mint_position.append((i, j))


def BackTrack(x, y):
    global hp, eat_mint, max_mint

    for i in range(len(mint_position)):
        mint_x, mint_y = mint_position[i]
        if graph[mint_x][mint_y] == 2:
            if hp >= abs(x - mint_x) + abs(y - mint_y):
                graph[mint_x][mint_y] = 0
                hp += hp_puls
                hp -= abs(x - mint_x) + abs(y - mint_y)
                eat_mint += 1
                BackTrack(mint_x, mint_y)
                hp -= hp_puls
                hp += abs(x - mint_x) + abs(y - mint_y)
                eat_mint -= 1
                graph[mint_x][mint_y] = 2
        elif graph[mint_x][mint_y] == 1:
            if hp >= abs(x - mint_x) + abs(y - mint_y):
                max_mint = max(eat_mint, max_mint)

BackTrack(start_x, start_y)
print(max_mint)
