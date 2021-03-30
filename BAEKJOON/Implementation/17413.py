from collections import deque

string = input()
stack = deque()
result = ''
tag = False

for s in string:
    if not tag:
        if s == '<':
            while stack:
                result += stack.pop()
            tag = True
            stack.append(s)
        elif s == ' ':
            while stack:
                result += stack.pop()
            result += s
        else:
            stack.append(s)
    else:
        if s == '>':
            stack.append(s)
            while stack:
                result += stack.popleft()
            tag = False
        else:
            stack.append(s)


while stack:
    result += stack.pop()

print(result)