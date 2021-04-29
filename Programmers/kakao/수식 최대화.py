rank = list()
max_sum = 0


def solution(expression):
    oper = list()
    if '*' in expression:
        oper.append('*')
    if '+' in expression:
        oper.append('+')
    if '-' in expression:
        oper.append('-')

    visited = [False] * len(oper)
    permutation(visited, 0, expression, oper)

    return max_sum


def permutation(visited: list, depth, expression, oper):
    if len(visited) == depth:
        calcul(rank, expression)
        return

    for i in range(len(visited)):
        if visited[i]:
            continue

        visited[i] = True
        rank.append(oper[i])
        permutation(visited, depth + 1, expression, oper)
        rank.pop()
        visited[i] = False


def calcul(rank, expression):
    global max_sum

    expression_split = list()
    temp = ''
    for s in expression:
        if s == '*' or s == '+' or s == '-':
            expression_split.append(temp)
            temp = ''
            expression_split.append(s)
        else:
            temp += s
    expression_split.append(temp)

    result = list()
    for i in range(len(rank)):
        check = False
        if i > 0:
            expression_split = result
            result = list()
        for j in range(len(expression_split)):
            if expression_split[j] == rank[i]:
                result.append(expression_split[j])
                check = True
            else:
                if check:
                    right = int(expression_split[j])
                    op = result.pop()
                    left = result.pop()
                    if op == '*':
                        result.append(left * right)
                    elif op == '+':
                        result.append(left + right)
                    elif op == '-':
                        result.append(left - right)
                    check = False
                else:
                    if expression_split[j] == '*' or expression_split[j] == '+' or expression_split[j] == '-':
                        result.append(expression_split[j])
                    else:
                        result.append(int(expression_split[j]))

    max_sum = max(max_sum, abs(result.pop()))


solution("100-200*300-500+20")
print(max_sum)
