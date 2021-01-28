n = int(input())

count = 0
isused1 = [False] * n #열
isused2 = [False] * ((n-1) * 2 + 1) #오른쪽 위 대각선 x+y
isused3 = [False] * ((n-1) * 2 + 1) #오른쪽 아래 대각선 x-y+n-1

def BackT(depth):
    global count

    if depth == n:
        count += 1
        return

    for i in range(n):
        if isused1[i] or isused2[i + depth] or isused3[i - depth + n - 1]:
            continue

        isused1[i] = True
        isused2[i + depth] = True
        isused3[i - depth + n - 1] = True
        BackT(depth + 1)
        isused1[i] = False
        isused2[i + depth] = False
        isused3[i - depth + n - 1] = False

BackT(0)
print(count)