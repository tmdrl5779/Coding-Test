#w, h = map(int, input().split(' '))
#graph = [list(map(int, input().split(' '))) for _ in range(h)]


def cal_point(a, b):
    x, y = b, a
    return x + 1, y + 1


print(cal_point(1, 1))
