case = int(input())

for _ in range(case):
    n = int(input())
    items = list(input() for _ in range(n))
    items_dict = dict()
    for i in range(len(items)):
        if items[i].split()[1] in items_dict:
            items_dict[items[i].split()[1]] += 1
        else:
            items_dict[items[i].split()[1]] = 1
    items = list(items_dict.values())
    total = 1

    for i in items:
        total *= (i + 1)
    print(total-1)



