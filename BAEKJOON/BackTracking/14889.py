from collections import deque

n = int(input())
s = [list(map(int, input().split())) for _ in range(n)]

visited = [False] * (n + 1)
team = list()
result = deque()

def BackTracking(start, depth, person_sum):
    if depth == n // 2 + 1:
        result.append(person_sum)
        return
    for i in range(start, n+1):
        if visited[i]:
            continue

        visited[i] = True
        team.append(i)
        BackTracking(i, depth + 1, PersonSum(person_sum, team, i))
        team.pop()
        visited[i] = False

def PersonSum(person_sum, team, i):
    for person in team:
        person_sum += Solve(person, i)
    return person_sum

def Solve(i, j):
    return s[i-1][j-1] + s[j-1][i-1]

def Result(result : deque):
    result_min = 1e9

    for i in range(len(result) // 2):
        team1 = result.popleft()
        team2 = result.pop()
        result_min = min(result_min, abs(team1 - team2))

    return result_min

BackTracking(1, 1, 0)
print(Result(result))