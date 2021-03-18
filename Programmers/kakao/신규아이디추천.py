import re

def solution(new_id):
    #1단계
    answer = new_id.lower()
    #2단계
    answer = re.sub('[~!@#$%^&*\(\)=+\[\{\]\}:?,\<\>/]', '', answer)

    #3단계
    answer = re.sub('\.+', '.', answer)

    #4단계
    if answer:
        if answer[0] == '.':
            answer = answer[1:]

    if answer:
        if answer[-1] == '.':
            answer = answer[:-1]

    #5단계
    if not answer:
        answer = 'a'

    #6단계
    answer = answer[:15]
    if answer:
        if answer[-1] == '.':
            answer = answer[:-1]

    #7단계
    if len(answer) < 3:
        answer = answer + answer[-1]*(3 - len(answer))

    return answer


solution("z-+.^.")