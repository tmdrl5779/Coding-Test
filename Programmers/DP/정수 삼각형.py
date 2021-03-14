def solution(triangle):
    l = len(triangle)
    dp = [[0] * l for _ in range(l)]

    dp[0][0] = triangle[0][0]

    for i in range(1, l):
        for j in range(0, i + 1):
            if j == 0:
                dp[i][j] = dp[i - 1][j] + triangle[i][j]
            elif j == i + 1:
                dp[i][j] = dp[i - 1][j] + triangle[i][j]
            else:
                dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j]

    return max(dp[-1])