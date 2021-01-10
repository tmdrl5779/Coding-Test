n, m = map(int, input().split())
solve = []
visited = [False] * (n + 1)

def Dfs(depth):
    if depth == m:
        print(' '.join(map(str, solve)))
        return
    for i in range(1, n + 1):
        if not visited[i]:
            if depth == 0 or solve[depth - 1] <= i:
                solve.append(i)
                Dfs(depth + 1)
                solve.pop()

Dfs(0)