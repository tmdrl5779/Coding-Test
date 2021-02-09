n = int(input())
a = list(map(int, input().split()))
reverse_a = list(reversed(a))

inc_dp = [0] * n
dec_dp = [0] * n
dp = [0] * n

def incSequence():
    inc_dp[0] = 1
    for i in range(1, n):
        max_temp = 0
        for j in range(i):
            if a[i] > a[j]:
                max_temp = max(max_temp, inc_dp[j])
        inc_dp[i] = max_temp + 1

def decSequence():
    dec_dp[0] = 1
    for i in range(1, n):
        max_temp = 0
        for j in range(i):
            if reverse_a[i] > reverse_a[j]:
                max_temp = max(max_temp, dec_dp[j])
        dec_dp[i] = max_temp + 1

def bitonic():
    for i in range(n):
        max_left_temp = 0
        max_right_temp = 0

        if i == 0:
            dp[i] = dec_dp[i]
            continue
        if i == n-1:
            dp[i] = inc_dp[i]
            continue

        for j in range(i):
            if a[i] > a[j]:
                max_left_temp = max(max_left_temp, inc_dp[j])

        for k in range(i+1, n):
            if a[i] > a[k]:
                max_right_temp = max(max_right_temp, dec_dp[k])

        dp[i] = max_left_temp + max_right_temp + 1


incSequence()
decSequence()
dec_dp.reverse()
bitonic()

print(max(dp))
