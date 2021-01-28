n, m = map(int, input().split())
solve = []

def BackT(depth):
    if depth == m:
        for i in solve:
            print(i, end=' ')
        print()
        return
    for i in range(1, n + 1):
        if i not in solve:
            solve.append(i)
            BackT(depth + 1)
            solve.pop()

BackT(0)
