n, m = map(int, input().split(' '))
trees = list(map(int, input().split(' ')))


def binary():
    left = 0
    right = max(trees)

    while left <= right:
        mid = (left + right) // 2
        height = 0
        for tree in trees:
            if tree - mid > 0:
                height += tree - mid

        if height >= m:  # 잘린 길이가 구하려는 것보다 크면 더 큰높이로 자르기
            left = mid + 1
        elif height < m:  # 잘린 길이가 구하려는 것보다 작으면 더 작은 높이로 자르기
            right = mid - 1
    return right


print(binary())
