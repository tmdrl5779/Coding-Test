import sys
input = sys.stdin.readline

while True:
    string = list(input())
    string.pop()
    if string[0] == '.' and len(string) == 1:
        break

    ps = list()
    small_check = False
    big_check = False
    for i in range(len(string)):
        if string[i] == '(' or string[i] == '[':
            ps.append(string[i])
        elif string[i] == ')':
            if not ps:
                small_check = True
                break
            if ps[-1] == '(':
                ps.pop()
            else:
                small_check = True
                break
        elif string[i] == ']':
            if not ps:
                big_check = True
                break
            if ps[-1] == '[':
                ps.pop()
            else:
                big_check = True
                break

    if not ps and not small_check and not big_check:
        print('yes')
    else:
        print('no')

