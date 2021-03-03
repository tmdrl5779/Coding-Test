def factorial(n):
    dp = [1] * (n + 1)

    for i in range(2, len(dp)):
        dp[i] = dp[i - 1] * i

    return dp[-1]

result = str(factorial(int(input())))
for i in range(len(result)-1, -1, -1):
    if result[i] != '0':
        print(len(result) - i -1)
        break