n = int(input())
number = list(map(int, input().split()))
operator = list(map(int, input().split()))
result_max = -1e9
result_min = 1e9

def BackTrack(index, start):
    global result_max, result_min
    if index == n - 1:
        result_max = max(start, result_max)
        result_min = min(start, result_min)
        return

    for i in range(4):
        if operator[i % 4] == 0:
            continue
        operator[i % 4] -= 1
        BackTrack(index + 1, Operator(start, number[index + 1], i % 4))
        operator[i % 4] += 1


def Operator(x, y, oper):
    if oper == 0:
        return x + y
    elif oper == 1:
        return x - y
    elif oper == 2:
        return x * y
    else:
        if x < 0:
            result = (-x) // y
            return -result
        else:
            return x // y

BackTrack(0, number[0])
print(result_max)
print(result_min)
