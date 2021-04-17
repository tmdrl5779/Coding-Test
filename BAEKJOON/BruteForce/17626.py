import math

n = int(input())

answer = 4


def solve():
    global answer, n
    sqrt = int(math.sqrt(n))
    for i in range(sqrt, int(math.sqrt(n - sqrt ** 2)) - 1, -1):
        n -= i ** 2
        if n == 0:
            answer = min(1, answer)
        sqrt2 = int(math.sqrt(n))
        for j in range(sqrt2, int(math.sqrt(n - sqrt2 ** 2)) - 1, -1):
            n -= j ** 2
            if n == 0:
                answer = min(2, answer)
            sqrt3 = int(math.sqrt(n))
            for k in range(sqrt3, int(math.sqrt(n - sqrt3 ** 2)) - 1, -1):
                n -= k ** 2
                if n == 0:
                    answer = min(3, answer)
                elif n == 1:
                    answer = min(4, answer)
                n += k ** 2
            n += j ** 2
        n += i ** 2


solve()
print(answer)
