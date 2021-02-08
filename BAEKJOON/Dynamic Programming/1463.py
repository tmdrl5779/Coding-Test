x = int(input())

dp = [1e6] * (x + 1)
dp[x] = 0

def make_one():
    for i in range(x, 0, -1):
        if i % 2 == 0:
            dp[i // 2] = min(dp[i] + 1, dp[i // 2])
        if i % 3 == 0:
            dp[i // 3] = min(dp[i] + 1, dp[i // 3])
        dp[i-1] = min(dp[i] + 1, dp[i-1])

make_one()
print(dp[1])


