n = int(input())
a = list(map(int, input().split()))
dp = [0] * n


def sequence():
    dp[0] = a[0]
    for i in range(1, n):
        max_value = 0
        for j in range(i):
            if a[i] > a[j]:
                if abs(a[i] - a[j]) != 0:
                    max_value = max(max_value, dp[j])

        max_index = dp.index(max_value)
        dp[i] = dp[max_index] + a[i]


sequence()
print(max(dp))
