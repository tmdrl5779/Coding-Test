n = int(input())
factor = list(map(int, input().split()))

print(min(factor) * max(factor))