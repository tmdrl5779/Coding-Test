n = int(input())
a = list(map(int, input().split()))
dp = [0] * n

def longIncSequence():
    dp[0] = 1
    for i in range(1, n):
        max_value = 0
        for j in range(i):
            if a[i] > a[j]:
                max_value = max(max_value, dp[j])
        dp[i] = max_value + 1

longIncSequence()
print(max(dp))