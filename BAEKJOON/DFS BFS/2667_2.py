n = int(input())

graph = [list(map(int, input())) for _ in range(n)]
visited = [[False] * n for _ in range(n)]
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]


def Dfs(cur_x, cur_y, visited, house_count):
    visited[cur_x][cur_y] = True
    for i in range(4):
        next_x = cur_x + dx[i]
        next_y = cur_y + dy[i]
        if next_x <= -1 or next_x >= n or next_y <= -1 or next_y >= n:
            continue
        if not visited[next_x][next_y] and graph[next_x][next_y] == 1:
            house_count = Dfs(next_x, next_y, visited, house_count + 1)

    return house_count

answer_list = []
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1 and not visited[i][j]:
            answer_list.append(Dfs(i, j, visited, 1))

answer_list.sort()

print(len(answer_list))
for i in answer_list:
    print(i)
