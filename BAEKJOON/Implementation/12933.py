duck = input()
visited = [False] * len(duck)
cnt = 0

if len(duck) % 5 != 0:
    print(-1)
    exit()


def solve(start):
    global cnt
    prev_s = None
    k_cnt = 0
    q_cnt = 0
    for i in range(start, len(duck)):
        if not visited[i] and duck[i] == 'q' and q_cnt == 0:
            visited[i] = True
            prev_s = duck[i]
            q_cnt += 1
            continue
        elif not visited[i] and duck[i] == 'q' and prev_s == 'k':
            visited[i] = True
            prev_s = duck[i]
            continue

        if not visited[i] and duck[i] == 'u' and prev_s == 'q':
            visited[i] = True
            prev_s = duck[i]
            continue

        if not visited[i] and duck[i] == 'a' and prev_s == 'u':
            visited[i] = True
            prev_s = duck[i]
            continue

        if not visited[i] and duck[i] == 'c' and prev_s == 'a':
            visited[i] = True
            prev_s = duck[i]
            continue

        if not visited[i] and duck[i] == 'k' and prev_s == 'c' and k_cnt == 0:
            visited[i] = True
            prev_s = duck[i]
            cnt += 1
            k_cnt += 1
            continue
        elif not visited[i] and duck[i] == 'k' and prev_s == 'c' and k_cnt > 0:
            visited[i] = True
            prev_s = duck[i]
            continue


for i in range(len(duck)):
    if duck[i] == 'q' and not visited[i]:
        solve(i)

if False in visited or cnt == 0:
    print(-1)
else:
    print(cnt)
