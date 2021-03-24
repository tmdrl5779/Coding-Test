def solution(table, languages, preference):
    answer = ''
    max_point = 0
    max_index = 0
    table.sort()
    for i in range(len(table)):
        point = 0

        fields = (table[i].split())[1:]
        for j in range(len(languages)):
            if languages[j] in fields:
                point += (5-fields.index(languages[j])) * preference[j]
        if max_point < point:
            max_point = point
            max_index = i

    answer = (table[max_index].split())[0]
    return answer

print(
solution(		["SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"], ["JAVA", "JAVASCRIPT"], [7, 5])
)