i = 1
while True:
    globals()['lotto{}'.format(i)] = list(map(int, input().split()))
    if globals()['lotto{}'.format(i)][0] == 0:
        break
    globals()['visited{}'.format(i)] = [False] * (globals()['lotto{}'.format(i)][0] + 1)
    i += 1
result = list()


def BackTracking(depth, start, lotto, visited):
    global string
    if depth == 6:
        print(' '.join(map(str, result)))
        return

    for i in range(start, lotto[0]+1):
        if visited[i]:
           continue
        visited[i] = True
        result.append(lotto[i])
        BackTracking(depth+1, i, lotto, visited)
        result.pop()
        visited[i] = False


for i in range(1, i):
    BackTracking(0, 1, globals()['lotto{}'.format(i)], globals()['visited{}'.format(i)])
    print()