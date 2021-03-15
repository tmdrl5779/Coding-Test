import fractions


n = int(input())

ups = list()
downs = list()

for _ in range(n):
    up, down = map(int, input().split())
    number = fractions.Fraction(up, down)
    ups.append(number.numerator)
    downs.append(number.denominator)

def gcd(a, b):
    if b > a:
        a, b = b, a
    while True:
        if b == 0:
            break
        a, b = b, a % b
    return a


def lcm(a, b):
    return a * b // gcd(a, b)

if n == 1:
    result_gcd = ups[0]
    result_lcm = downs[0]
else:
    result_gcd = gcd(ups[0], ups[1])
    result_lcm = lcm(downs[0], downs[1])

for i in range(2, n):
    result_gcd = gcd(result_gcd, ups[i])
    result_lcm = lcm(result_lcm, downs[i])

print(result_gcd, result_lcm)