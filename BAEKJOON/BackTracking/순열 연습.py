visited = [False] * 3
result = list()


def permutation(visited, r, depth):
    if depth == r:
        for i in result:
            print(i, end=' ')
        print()
        return

    for i in range(len(visited)):

        if visited[i]:
            continue

        visited[i] = True
        result.append(i)
        permutation(visited, r, depth + 1)
        visited[i] = False
        result.pop()


permutation(visited, 2, 0)
