n, k = map(int, input().split())
people = list()
result = list()
for i in range(1, n + 1):
    people.append(i)

idx = 0
while people:
    asdf = len(people)
    idx = (idx + k - 1) % len(people)
    result.append(people.pop(idx))

print('<', end='')
for i in range(n):
    if i == n-1:
        print(result[i], end='')
    else:
        print(result[i], end=', ')
print('>')