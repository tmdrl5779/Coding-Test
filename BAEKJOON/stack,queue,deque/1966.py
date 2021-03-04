from collections import deque
import sys

input = sys.stdin.readline
case = int(input())

for _ in range(case):
    n, m = map(int, input().split())
    queue = deque(map(int, input().split()))
    a = [0] * n
    a[m] = 1
    queue2 = deque(a)
    count = 0
    while queue:
        if queue[0] == max(queue):
            queue.popleft()
            if queue2.popleft() == 0:
                count += 1
            else:
                print(count + 1)
        else:
            queue.append(queue.popleft())
            queue2.append(queue2.popleft())
