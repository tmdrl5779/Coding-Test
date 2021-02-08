n = int(input())
cost = [0]
dp = [[0] * 2 for _ in range(n + 1)]  # [][0] : 연속, [][1] : 2칸
for _ in range(1, n + 1):
    cost.append(int(input()))


def stair():
    dp[1][0] = cost[1]
    dp[1][1] = cost[1]
    for i in range(2, n + 1):
        for j in range(2):
            if j == 0:
                dp[i][j] = dp[i - 1][1] + cost[i]
            else:
                dp[i][j] = max(dp[i - 2]) + cost[i]


stair()
print(max(dp[n]))
