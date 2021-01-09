n, m = map(int, input().split())
visit_number = []

def BackT(start, depth):
    if depth == m:
        for i in visit_number:
            print(i, end=' ')
        print()
        return
    for i in range(start, n + 1):
        if i not in visit_number:
            visit_number.append(i)
            BackT(i + 1, depth + 1)
            visit_number.pop()

def BackT2(depth):
    if depth == m:
        for i in visit_number:
            print(i, end=' ')
        print()
        return
    for i in range(1, n + 1):
        if i not in visit_number:
            if depth == 0 or visit_number[len(visit_number) - 1] < i:
                visit_number.append(i)
                BackT2(depth + 1)
                visit_number.pop()


#BackT(1, 0)
BackT2(0)
