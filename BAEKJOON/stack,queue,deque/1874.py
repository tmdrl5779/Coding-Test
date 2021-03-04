import sys
input = sys.stdin.readline

n = int(input())
input_number = list(int(input()) for _ in range(n))

stack = list()
result = list()
j = 0
for i in range(1, n+1):
    stack.append(i)
    result.append('+')

    while stack and input_number[j] == stack[-1]:
        stack.pop()
        result.append('-')
        j += 1

if stack:
    print('NO')
else:
    for i in range(len(result)):
        print(result[i])