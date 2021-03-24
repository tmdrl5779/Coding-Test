def solution(enter, leave):
    answer = [0] * (len(enter) + 1)

    i = 0
    for enter_person in enter:
        #입실 퇴실 사이에 있으면 만났음
        leave_index = leave.index(enter_person)
        if i < leave_index:
            for j in range(0, leave_index):
                leave_person = leave[j]
                # if enter.index(leave_person) < i and leave_person < leave[leave_index]:
                #     continue
                # if leave_person in enter[:i]:
                #     continue

                answer[enter[i]] += 1
                answer[leave[j]] += 1

        i += 1


    return answer[1:]

print(solution(	[1, 4, 2, 3], [2, 1, 4, 3]))