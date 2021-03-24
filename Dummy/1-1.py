def solution(program, flag_rules, commands):
    answer = []

    for command in commands:
        command_dict = dict()
        for flag_rule in flag_rules: #flag 사전 등록
            flag_name, flag_argument_type = flag_rule.split()
            command_dict['program'] = program
            if flag_argument_type == 'STRING':
                command_dict[flag_name] = type(str())

            elif flag_argument_type == 'NUMBER':
                command_dict[flag_name] = type(int())

            elif flag_argument_type == 'NULL':
                command_dict[flag_name] = type(None)

        command_split = command.split()
        if command_split[0] != command_dict['program']:
            answer.append(False)
            break

        i = 1
        while i < len(command_split):
            if len(command_split) == 2: # 명령어가 2개일때 -e인지 확인
                if not command_split[1] in command_dict:
                    answer.append(False)
                    break

            if command_split[i] != '-e': # -e 플래그가 아닐때 ( -s, -n )
                flag_argument = command_split[i+1]
                if command_split[i+1] in command_dict: # 플래그가 연속으로 나올때
                    answer.append(False)
                    break
                if flag_argument.isdigit():
                    flag_argument = int(flag_argument)
                if command_dict[command_split[i]] != type(flag_argument):
                    answer.append(False)
                    break
                i += 2
            else: # -e 플래그일때
                if i != len(command_split)-1 : #-e가 맨마지막이 아닐때
                    if not command_split[i+1] in command_dict:
                        answer.append(False)
                        break
                i += 1

            if i == len(command_split)-1:
                answer.append(True)

    return answer

print(
solution(		"line", ["-s STRING", "-n NUMBER", "-e NULL"], ["line -s 123 -n HI", "line fun"])
)