n = int(input())
input_list = list()
result_list = list()
for i in range(n):
    start, end = map(int, input().split())
    term = end - start
    input_list.append((start, end, term))

input_list.sort(key=lambda x: (x[1], x[0]))

for i in range(n):
    if i == 0:
        result_list.append(input_list[0])
        result = input_list[0]
    else:
        if input_list[i][0] >= result[1]:
            result = input_list[i]
            result_list.append(result)

print(len(result_list))
