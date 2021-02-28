express = input()
split = list()
result = list()

start = 0
for i in range(len(express)):
    if express[i] == '-' or express[i] == '+':
        split.append(int(express[start:i]))
        split.append(express[i])
        start = i + 1
split.append(int(express[start:]))

start = 0
for i in range(len(split)):
    if split[i] == '-':
        end = i - 1
        sum_number = 0
        for j in range(start, end+1):
            if split[j] != '+':
                sum_number += split[j]
        result.append(sum_number)
        start = i + 1

sum_number = 0
for j in range(start, len(split)):
    if split[j] != '+':
        sum_number += split[j]
result.append(sum_number)

print(result[0]-(sum(result) - result[0]))
