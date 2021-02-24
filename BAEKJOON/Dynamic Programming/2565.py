n = int(input())
link = list()
for _ in range(n):
    link.append(tuple(map(int, input().split())))

link.sort(key=lambda x: x[0], reverse=True)

dp = [1] * (link[0][0] + 1)

def result():
    for i in range(1, n):
        a = link[i][0]
        b = link[i][1]
        max_value = 0
        for j in range(i):
            if b < link[j][1]:
                max_value = max(max_value, dp[link[j][0]])

        dp[a] += max_value

result()
print(n - max(dp))



