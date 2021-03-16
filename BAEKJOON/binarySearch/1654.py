k, n = map(int, input().split(' '))
lans = [int(input()) for _ in range(k)]

result = list()


def binary():
    left = 1
    right = max(lans)
    while left <= right:
        count = 0
        mid = (left + right) // 2

        for lan in lans:
            count += lan // mid

        if count < n:
            right = mid - 1
        elif count >= n:
            left = mid + 1

    return right


print(binary())
