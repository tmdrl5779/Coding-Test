import re

def solution(inp_str):
    answer = []

    # 1번위배
    if not (8 <= len(inp_str) <= 15):
        answer.append(1)

    # 2번위배
    change = re.sub('[^a-zA-Z\d\~!@#$%^&*]', '', inp_str)
    if change != inp_str:
        answer.append(2)

    # 3번위배
    i = 0
    if change != re.sub('[\d]', str(i), change):
        i += 1
        change = re.sub('[\d]', str(i), change)
    if change != re.sub('[a-z]', str(i), change):
        i += 1
        change = re.sub('[a-z]', str(i), change)
    if change != re.sub('[A-Z]', str(i), change):
        i += 1
        change = re.sub('[A-Z]', str(i), change)
    if change != re.sub('[~!@#$%^&*]', str(i), change):
        i += 1
        change = re.sub('[~!@#$%^&*]', str(i), change)

    if i < 3:
        answer.append(3)


    #4번위배
    if change != re.sub('[a-zA-Z{4}\d{4}\~!@#$%^&*{4}]', '', inp_str):
        change = re.sub('[a-zA-Z{4}\d{4}\~!@#$%^&*{4}]', '', inp_str)
        answer.append(4)

    #5번위배
    if change != re.sub('[a-zA-Z{5}\d{5}\~!@#$%^&*{5}]', '', inp_str):
        answer.append(5)



    return answer


solution("aaaaZZZZ)")
