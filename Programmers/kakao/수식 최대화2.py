import re
from itertools import permutations


def solution(expression):
    oper = list()
    if '*' in expression:
        oper.append('*')
    if '+' in expression:
        oper.append('+')
    if '-' in expression:
        oper.append('-')

    oper = list(permutations(oper))

    expression = re.split('([^0-9])', expression)
    max_sum = 0
    for ops in oper:
        expression_copy = expression[:]
        for op in ops:
            while op in expression_copy:
                op_idx = expression_copy.index(op)
                cal = str(eval(expression_copy[op_idx-1] + expression_copy[op_idx] +expression_copy[op_idx+1]))
                expression_copy[op_idx-1] = cal
                expression_copy = expression_copy[:op_idx] + expression_copy[op_idx+2:]

        max_sum = max(max_sum, abs((int(expression_copy[-1]))))

    return max_sum


print(solution("100-200*300-500+20"))
