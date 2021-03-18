def solution(info, query):
    answer = []
    # 0:개발언어, 1:직군, 2:경력, 3:소울푸드, 4:점수
    score = dict()

    for information in info:
        temp = information.split(' ')
        if int(temp[4]) in score:
            score[int(temp[4])].append(temp[:4])
        else:
            score[int(temp[4])] = [temp[:4]]
    score = sorted(score.items())

    for commands in query:
        command = ''.join(commands.split('and')).split()
        left = 0
        right = len(score) - 1
        target = int(command[-1])
        while left <= right:
            mid = (left+right) // 2
            if target > score[mid][0]:
                left = mid + 1
            elif target <= score[mid][0]:
                right = mid - 1
        count = 0

        for i in range(left, len(score)):
            for item in score[i][1]:
                if (item[0] == command[0] or command[0] == '-') and (item[1] == command[1] or command[1] == '-') and (item[2] == command[2] or command[2] == '-') and (item[3] == command[3] or command[3] == '-'):
                    count += 1
        answer.append(count)

    return answer


solution(["java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150",
          "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"],
         ["java and backend and junior and pizza 100", "python and frontend and senior and chicken 200",
          "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100",
          "- and - and - and - 150"])
