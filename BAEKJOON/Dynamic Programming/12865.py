n, k = map(int, input().split())
item = list()

for _ in range(n):
    item.append(tuple(map(int, input().split())))

dp2 = [0] * (k+1)
for i in range(n):
    for j in range(k, item[i][0]-1, -1):
        dp2[j] = max(dp2[j], dp2[j-item[i][0]] + item[i][1])

print(dp2[k])


dp = [[0] * (k + 1) for _ in range(n)]

for i in range(n):
    for j in range(k + 1):
        if i == 0:
            if item[i][0] <= j:
                dp[i][j] = item[i][1]
        else:
            if j - item[i][0] < 0:
                dp[i][j] = dp[i - 1][j]
            else:
                dp[i][j] = max(dp[i - 1][j - item[i][0]] + item[i][1], dp[i - 1][j])

print(dp[n - 1][k])


