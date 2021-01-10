n, m = map(int, input().split())
my_list = list(map(int, input().split()))
my_list.sort()
solve = []
visited = [False] * n

def Dfs(depth):
    if depth == m:
        print(' '.join(map(str, solve)))
        return
    for i in range(n):
        if not visited[i]:
            solve.append(my_list[i])
            visited[i] = True
            Dfs(depth + 1)
            visited[i] = False
            solve.pop()

Dfs(0)