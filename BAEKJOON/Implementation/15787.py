import sys

input = sys.stdin.readline
n, m = map(int, input().split(' '))
trains = [0] * (n + 1)
commands = [list(map(int, input().split(' '))) for _ in range(m)]
visited = [False] * (2 ** 22)


def conduct(trains):
    for i in range(m):
        if commands[i][0] == 1:
            train_n = commands[i][1]
            seat = commands[i][2] - 1
            trains[train_n] = trains[train_n] | (1 << seat)
        elif commands[i][0] == 2:
            train_n = commands[i][1]
            seat = commands[i][2] - 1
            trains[train_n] = trains[train_n] & ~(1 << seat)
        elif commands[i][0] == 3:
            train_n = commands[i][1]
            trains[train_n] = trains[train_n] << 1
            trains[train_n] = trains[train_n] & ~(2 ** 20)
        elif commands[i][0] == 4:
            train_n = commands[i][1]
            trains[train_n] = trains[train_n] >> 1


def vailTrain():
    count = 0

    for i in range(1, n + 1):
        if not visited[trains[i]]:
            count += 1
            visited[trains[i]] = True

    return count


conduct(trains)
print(vailTrain())
