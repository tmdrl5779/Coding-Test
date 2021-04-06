from collections import deque

h, w = map(int, input().split(' '))
blocks = deque(list(map(int, input().split(' '))))

graph = [[0] * h for _ in range(w)]

for i in range(w):
    block = blocks.popleft()
    for j in range(block):
        graph[i][j] = 1


answer = 0
for j in range(h):
    first_block = False
    sub_answer = 0
    for i in range(w):
        if not first_block and graph[i][j] == 1:
            first_block = True
            continue

        if first_block and graph[i][j] == 0:
            sub_answer += 1
            continue

        if first_block and graph[i][j] == 1:
            answer += sub_answer
            sub_answer = 0

print(answer)