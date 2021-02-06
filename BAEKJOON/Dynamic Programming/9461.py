t = int(input())

def padovan(n):
    dp = [-1] * n

    for i in range(n):
        if i < 3:
            dp[i] = 1
        elif i == 3:
            dp[i] = dp[i-1] + dp[i-2]
        else:
            if i-5 < 0:
                dp[i] = dp[i-1]
            else:
                dp[i] = dp[i-1] + dp[i-5]
    return dp[n-1]


for _ in range(t):
    n = int(input())
    print(padovan(n))