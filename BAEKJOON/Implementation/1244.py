n = int(input())
switch = list(map(int, input().split(' ')))
students = int(input())
receive_n = [tuple(map(int, input().split(' '))) for _ in range(students)]
# 1: 남, 2: 여

for i in range(students):
    if receive_n[i][0] == 1:  # 남 배수
        c_switch_number = receive_n[i][1]
        j = 1
        n_switch_number = c_switch_number * j
        while n_switch_number <= n:
            switch[n_switch_number - 1] = abs(switch[n_switch_number - 1] - 1)

            j += 1
            n_switch_number = c_switch_number * j

    elif receive_n[i][0] == 2:  # 여 대칭
        switch_number = receive_n[i][1]
        j = 0
        while True:

            if j == 0:
                switch[switch_number - 1] = abs(switch[switch_number - 1] - 1)
            else:
                left = switch_number - 1 - j
                right = switch_number - 1 + j
                if left >= 0 and right < n:
                    if switch[left] == switch[right]:
                        switch[left] = abs(switch[left] - 1)
                        switch[right] = abs(switch[right] - 1)
                    else:
                        break
                else:
                    break
            j += 1

div_twen = 0
for i in range(len(switch) // 20):
    for j in range(20):
        print(switch[j + div_twen], end=' ')
    print()
    div_twen = (i+1) * 20


for i in range(len(switch) % 20):
    print(switch[div_twen + i], end=' ')
