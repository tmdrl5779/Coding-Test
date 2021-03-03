n, k = map(int, input().split())

dp = [1] * (n + 1)
def factorial():

    for i in range(2, len(dp)):
        dp[i] = dp[i - 1] * i

    return dp[-1]

factorial()
print(dp[n] // dp[n - k] // dp[k])
