n = int(input())
s = list(map(int, input().split()))

dp = [0] * len(s)

for i in range(len(s)):
    if i == 0:
        dp[i] = s[i]
    if s[i-1] >= 0:
        dp[i] = s[i] + dp[i-1]
    else:
        if s[i] < s[i] + dp[i-1]:
            dp[i] = s[i] + dp[i-1]
        else:
            dp[i] = s[i]

print(max(dp))