n = int(input())
triangle = [list(map(int, input().split())) for _ in range(n)]
dp = list()

for i in range(n):
    dp.append([0]*(i+1))

def int_triangle():
    global dp
    for i in range(n):
        for j in range(len(dp[i])):
            if i == 0:
                dp[i][j] = triangle[i][j]
            else:
                if j == 0 :
                    dp[i][j] = dp[i - 1][j] + triangle[i][j]
                elif j == len(dp[i])-1:
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j]
                else:
                    dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j]

    return max(dp[n-1])

print(int_triangle())