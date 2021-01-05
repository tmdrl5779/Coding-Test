n = int(input())

graph = [list(map(int, input())) for _ in range(n)]

def dfs(x, y, house_count):
    if x <= -1 or x >= n or y <= -1 or y >= n:
        return False

    if graph[x][y] == 1:
        graph[x][y] = house_count
        dfs(x - 1, y, house_count)
        dfs(x, y - 1, house_count)
        dfs(x + 1, y, house_count)
        dfs(x, y + 1, house_count)
        return True
    return False


result = 0
for i in range(n):
    for j in range(n):
        if dfs(i, j, result + 2):
            result += 1

house_count = [0] * result
for i in range(n):
    for j in range(n):
        if graph[i][j] != 0:
            house_count[graph[i][j] - 2] += 1
house_count.sort()
print(result)
for i in range(len(house_count)):
    print(house_count[i])
