from collections import deque
import sys

input = sys.stdin.readline
t = int(input())

for _ in range(t):
    p = input()
    n = int(input())
    queue = deque(eval(input()))
    error = False
    r_cnt = 0
    for i in range(len(p)):
        if p[i] == 'D':
            if not queue:
                error = True
                break
            else:
                if r_cnt % 2 == 0:
                    queue.popleft()
                else:
                    queue.pop()
        elif p[i] == 'R':
            r_cnt += 1

    if error:
        print('error')
    else:
        if r_cnt % 2 == 1:
            queue.reverse()
        print("[" + ",".join(list(map(str, queue))) + "]")
