from collections import deque

n, k = map(int, input().split())
dx = [-1, 1, 2]
visited = [0] * 100001
visited[n] = 1

def Bfs():
    queue = deque([n])

    while queue:
        cur_x = queue.popleft()
        if cur_x == k:
            return visited[k]
        for i in range(3):
            if i == 2:
                next_x = cur_x * dx[i]
            else:
                next_x = cur_x + dx[i]

            if 0 <= next_x <= 100000 and visited[next_x] == 0:
                queue.append(next_x)
                visited[next_x] = visited[cur_x] + 1

print(Bfs() - 1)
