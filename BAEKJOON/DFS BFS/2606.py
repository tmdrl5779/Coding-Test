from collections import deque

n = int(input()); #컴퓨터 수
graph = [[] for _ in range(n + 1)]

e = int(input()); #연결된 선 수
for i in range(e):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
    graph[a].sort()
    graph[b].sort()

visited = [False] * (n + 1)

def bfs(graph, start, visited):
    result = 0
    queue = deque([start])
    visited[start] = True

    while queue:
        pop = queue.popleft()
        for e in graph[pop]:
            if not visited[e]:
                queue.append(e)
                visited[e] = True
                result += 1
    print(result)

bfs(graph, 1, visited)
