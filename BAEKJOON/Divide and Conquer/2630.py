n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]

blue_count = 0
white_count = 0


def makePaper(graph):
    if validPaper(graph):
        return

    left_top = list()
    right_top = list()
    left_bottom = list()
    right_bottom = list()

    for i in graph[:len(graph) // 2]:
        left_top.append(i[:len(i) // 2])
        right_top.append(i[len(i) // 2:])

    for i in graph[len(i) // 2:]:
        left_bottom.append(i[:len(i) // 2])
        right_bottom.append(i[len(i) // 2:])

    makePaper(left_top)
    makePaper(right_top)
    makePaper(left_bottom)
    makePaper(right_bottom)


def validPaper(graph: list):
    global white_count, blue_count
    white = True
    blue = True
    for i in graph:
        for j in i:
            if j != 0:
                blue = False
            else:
                white = False

    if white:
        white_count += 1
        return white
    if blue:
        blue_count += 1
        return blue


makePaper(graph)
print(blue_count)
print(white_count)