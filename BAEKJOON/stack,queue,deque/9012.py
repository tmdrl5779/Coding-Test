t = int(input())

for _ in range(t):
    ps = list(input())
    stack = list()
    is_empty = False
    for i in range(len(ps)):
        if ps[i] == '(':
            stack.append(ps[i])
        else:
            if not stack:
                is_empty = True
                break
            else:
                stack.pop()
    if not stack and not is_empty:
        print('YES')
    else:
        print('NO')