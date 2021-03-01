from fractions import Fraction

n = int(input())
ring = list(map(int, input().split()))

for i in range(1, n):
    f = Fraction(ring[0], ring[i])
    print(str(f.numerator) + '/' + str(f.denominator))

