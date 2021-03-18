from itertools import combinations


def solution(orders, course):
    answer = []
    for cour in course:
        menus = dict()
        temps = list()
        for order in orders:
            temps.extend(list(combinations(sorted(order), cour)))

        for temp in temps:
            key = ''.join(temp)
            if key in menus:
                menus[key] += 1
            else:
                menus[key] = 1

        for menu in menus:
            if max(menus.values()) > 1:
                if menus[menu] == max(menus.values()):
                    answer.append(menu)

    answer.sort()

    return answer


solution(["XYZ", "XWY", "WXA"], [2, 3, 4])
