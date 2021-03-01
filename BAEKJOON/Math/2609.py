a, b = map(int, input().split())
c, d = a, b
if b > a:
    a, b = b, a

while b != 0:
    a, b = b, a % b

print(a)
print(c * d // a)
