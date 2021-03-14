def solution(m, n, puddles):
    dp = [[0] * (n + 1) for _ in range(m + 1)]

    for puddle in puddles:
        if puddle:
            dp[puddle[0]][puddle[1]] = -1

    m_one_check = False
    for i in range(n + 1):
        if dp[1][i] == -1:
            m_one_check = True
        if m_one_check:
            dp[1][i] = -1
        else:
            dp[1][i] = 1

    m_one_check = False
    for i in range(1, m + 1):
        if dp[i][1] == -1:
            m_one_check = True
        if m_one_check:
            dp[i][1] = -1
        else:
            dp[i][1] = 1

    for i in range(2, m + 1):
        for j in range(2, n + 1):
            if dp[i][j] == -1:
                continue
            else:
                if dp[i - 1][j] == -1:
                    dp[i][j] = dp[i][j - 1]
                elif dp[i][j - 1] == -1:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
    if dp[m][n] < 0:
        return 0
    return dp[m][n] % 1000000007