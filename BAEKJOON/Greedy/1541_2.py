express = input()
split = list()

start = 0
for i in range(len(express)):
    if express[i] == '-' or express[i] == '+':
        split.append(int(express[start:i]))
        split.append(express[i])
        start = i + 1
split.append(int(express[start:]))

idx = 0
left = 0
right = 0
try:
    idx = split.index('-')
    for i in range(idx):
        if split[i] != '-' and split[i] != '+':
            left += split[i]
    for i in range(idx, len(split)):
        if split[i] != '-' and split[i] != '+':
            right += split[i]
    print(left - right)
except:
    for i in range(len(split)):
        if split[i] != '-' and split[i] != '+':
            left += split[i]
    print(left)
