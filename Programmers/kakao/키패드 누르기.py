def solution(numbers, hand):
    answer = ''
    keypad = ['123', '456', '789', '*0#']
    cl_x, cl_y = 3, 0
    cr_x, cr_y = 3, 2

    for n in numbers:
        number = str(n)
        if number == '1' or number == '4' or number == '7':
            cl_y = 0
            for i in range(len(keypad)):
                if number in keypad[i]:
                    cl_x = i
            answer += 'L'

        elif number == '3' or number == '6' or number == '9':
            cr_y = 2
            for i in range(len(keypad)):
                if number in keypad[i]:
                    cr_x = i
            answer += 'R'

        else:
            n_y = 1
            for i in range(len(keypad)):
                if number in keypad[i]:
                    n_x = i
                    break

            if abs(cl_x - n_x) + abs(cl_y - n_y) < abs(cr_x - n_x) + abs(cr_y - n_y):
                cl_x = n_x
                cl_y = n_y
                answer += 'L'
            elif abs(cl_x - n_x) + abs(cl_y - n_y) > abs(cr_x - n_x) + abs(cr_y - n_y):
                cr_x = n_x
                cr_y = n_y
                answer += 'R'
            else:
                if hand == 'right':
                    cr_x = n_x
                    cr_y = n_y
                    answer += 'R'
                else:
                    cl_x = n_x
                    cl_y = n_y
                    answer += 'L'

    return answer


solution(	[7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2], "left")