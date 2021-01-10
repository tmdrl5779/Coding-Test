n, m = map(int, input().split())
my_list = list(map(int, input().split()))
double_check = []
my_list.sort()
solve = []
visited = [0] * n

def Dfs(depth):
    if depth == m:
        print(' '.join(map(str, solve)))
        return
    used = [False for _ in range(max(my_list) + 1)]
    for i in range(n):
        if visited[i] == 0 and not used[my_list[i]]:
            used[my_list[i]] = True
            solve.append(my_list[i])
            visited[i] = my_list[i]
            Dfs(depth + 1)
            visited[i] = 0
            solve.pop()

def Dfs2(depth):
    if depth == m:
        print(' '.join(map(str, solve)))
        return
    append_count = 0
    double_check.append(-1)#depth 경계
    for i in range(n):
        if visited[i] == 0:
            if double_check[len(double_check) - 1] != my_list[i]:
                double_check.append((my_list[i]))
                append_count += 1
                solve.append(my_list[i])
                visited[i] = my_list[i]
                Dfs2(depth + 1)
                visited[i] = 0
                solve.pop()
    for j in range(append_count + 1):
        double_check.pop()



Dfs2(0)