n, k = map(int, input().split())
a = list()

for _ in range(n):
    a.append(int(input()))

result = 0

def coin_zero():
    global k, a, result
    for i in range(n-1, -1, -1):
        quotient = k // a[i]
        remainder = k % a[i]
        if quotient > 0:
            result += quotient
            k = remainder
    return result

print(coin_zero())
