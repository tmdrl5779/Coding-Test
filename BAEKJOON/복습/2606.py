from collections import deque

n = int(input())
e = int(input())
grpah = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)
count = 0

for _ in range(e):
    a, b = map(int, input().split())
    grpah[a].append(b)
    grpah[b].append(a)


def bfs(start):
    global count
    queue = deque([start])
    visited[start] = True

    while queue:
        current = queue.popleft()
        count += 1
        for vertex in grpah[current]:
            if not visited[vertex]:
                visited[vertex] = True
                queue.append(vertex)


bfs(1)
print(count - 1)
