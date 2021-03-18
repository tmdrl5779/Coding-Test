n, c = map(int, input().split(' '))
xs = [int(input()) for _ in range(n)]
xs.sort()

def binary():
    left = 1
    right = max(xs) - 1

    while left <= right:
        mid = (left + right) // 2

        count = 1
        wifi = min(xs) + mid

        for i in range(1, len(xs)):
            if wifi <= xs[i]:
                count += 1
                wifi = xs[i] + mid

        if count >= c:
            left = mid + 1
        elif count < c:
            right = mid -1
    return right

print(binary())