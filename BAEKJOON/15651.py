n, m = map(int, input().split())
visited = [False] * (n + 1)
solve = []

def Dfs(depth):
    if depth == m:
        for i in range(m):
            print(solve[i], end=" ")
        print()
        # print(' '.join(map(str, solve)))
        # join을 사용하여 풀 수 도있다. join은 문자열을 합치는 함수이다.
        # solve에 있는 원소는 int형이기 때문에 map을 사용하여 string형으로 만들어주고 join
        return
    for i in range(1, n + 1):
        if not visited[i]:
            solve.append(i)
            Dfs(depth + 1)
            solve.pop()

Dfs(0)