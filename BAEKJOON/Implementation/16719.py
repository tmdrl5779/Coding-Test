string = list(input())
index = list()
visited = [False] * len(string)
s = 0
e = len(string)

while True:
    check = False
    if string[s:e]:
        min_str = min(string[s:e])
        min_idx = string[s:e].index(min_str) + s
        visited[min_idx] = True
        check = True
        index.append(min_idx)
        s = min_idx + 1
    else:
        if index:
            e = index.pop()
        if index:
            s = index.pop()
            index.append(s)
            s += 1
        else:
            s = 0
    if check:
        for i in range(len(visited)):
            if visited[i]:
                print(string[i], end='')
        print()

    if all(visited):
        break
