car_number = list(input())
result = 0

def BackTrack(depth, dup):
    global result
    if depth == len(car_number):
        result += 1
        return

    if car_number[depth-1] != car_number[depth]:
        dup = -1

    if car_number[depth] == 'c':
        temp = [False] * 26
        for i in range(26):
            if dup != -1:
                temp[dup] = True
            if temp[i]:
                continue
            BackTrack(depth + 1, i)

    else:
        temp = [False] * 10
        for i in range(10):
            if dup != -1:
                temp[dup] = True
            if temp[i]:
                continue
            BackTrack(depth+1, i)

def solve():
    global result

    for i in range(len(car_number)):
        if car_number[i] == 'c':
            if i == 0:
                result *= 26
                continue
            if car_number[i - 1] != car_number[i]:
                result *= 26
            else:
                result *= 25
        else:
            if i == 0:
                result *= 10
                continue
            if car_number[i - 1] != car_number[i]:
                result *= 10
            else:
                result *= 9

#BackTrack(0, -1)
result = 1
solve()
print(result)