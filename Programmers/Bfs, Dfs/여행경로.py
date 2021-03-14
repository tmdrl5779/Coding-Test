def solution(tickets):
    answer = []

    place = list()
    i = 0
    for ticket in tickets:
        if ticket[0] == 'ICN':
            ticket.append(i)
            place.append(ticket)
        i += 1
    place.sort(key=lambda x: x[1])

    for j in place:
        visited = [False] * len(tickets)
        visited[j[2]] = True
        dfs(j, tickets, visited, 1, answer)
        if len(answer) == len(tickets) + 1:
            break
        else:
            answer.clear()

    return answer


def dfs(start, tickets, visited, depth, answer):
    if depth == len(tickets):
        answer.append(start[0])
        answer.append(start[1])
        return

    place = list()
    i = 0
    for ticket in tickets:
        if ticket[0] == start[1]:
            if not visited[i]:
                ticket.append(i)
                place.append(ticket)
        i += 1
    place.sort(key=lambda x: x[1])

    if not place:
        if answer:
            answer.pop()
            visited[start[2]] = False

    for i in place:
        if not visited[i[2]]:
            visited[i[2]] = True
            answer.append(start[0])
            dfs(i, tickets, visited, depth + 1, answer)

