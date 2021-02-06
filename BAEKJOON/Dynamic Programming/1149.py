import copy

n = int(input())
cost = [list(map(int, input().split())) for _ in range(n)]
dp = [[10001] * 3 for _ in range(n)]
def RGB():
    for i in range(n):
        for j in range(3):
            if i == 0:
                dp[i][j] = cost[i][j]
            else:
                if j == 0:
                    dp[i][j] = min(dp[i-1][1], dp[i-1][2]) + cost[i][j]
                elif j == 1:
                    dp[i][j] = min(dp[i - 1][0], dp[i - 1][2]) + cost[i][j]
                else:
                    dp[i][j] = min(dp[i - 1][0], dp[i - 1][1]) + cost[i][j]
RGB()
print(min(dp[n-1]))