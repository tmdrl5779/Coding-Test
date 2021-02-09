n = int(input())
cost = [0]
dp = [[0] * 3 for _ in range(n + 1)]

for i in range(1, n + 1):
    cost.append(int(input()))

for i in range(3):
    dp[1][i] = cost[1]

def grape():
    for i in range(2, n + 1):
        for j in range(3):
            if j == 0:
                temp = 0
                for k in range(1, 3):
                    temp = max(temp, dp[i - 1][k])
                dp[i][j] = temp + cost[i]
            elif j == 1:
                dp[i][j] = max(dp[i - 2]) + cost[i]
            else:
                if i >= j + 1:
                    dp[i][j] = max(dp[i - (j + 1)]) + cost[i]


grape()
result = 0
for i in range(n + 1):
    result = max(result, max(dp[i]))

print(result)
