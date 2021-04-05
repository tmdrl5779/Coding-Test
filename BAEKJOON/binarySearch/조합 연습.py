visited = [False] * 4

def combination(s, visited, r, depth):
    if depth == r:

        for i in range(len(visited)):
            if visited[i]:
                print(i, end=' ')
        print()
        return

    for i in range(s, len(visited)):

        if visited[i]:
            continue

        visited[i] = True
        combination(i, visited, r, depth + 1)
        visited[i] = False


combination(0, visited, 2, 0)
