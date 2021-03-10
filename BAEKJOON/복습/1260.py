from collections import deque

n, m, v = map(int, input().split())

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    s, e = map(int, input().split())
    graph[s].append(e)
    graph[e].append(s)
    graph[s].sort()
    graph[e].sort()


def dfs(start):
    visited[start] = True
    print(start, end=' ')
    for vertex in graph[start]:
        if not visited[vertex]:
            dfs(vertex)



def bfs(start):
    visited[start] = True
    queue = deque([start])

    while queue:
        current = queue.popleft()
        print(current, end=' ')
        for vertex in graph[current]:
            if not visited[vertex]:
                queue.append(vertex)
                visited[vertex] = True



visited = [False] * (n + 1)
dfs(v)
print()
visited = [False] * (n + 1)
bfs(v)