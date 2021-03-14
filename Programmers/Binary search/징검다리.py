import math

# 기분 탐색의 기준은 돌과 돌 사이의 거리
def solution(distance, rocks, n):
    answer = 0
    rocks.sort()
    #마지막 도착지점
    rocks.append(distance)

    start, end = 0,distance

    while start <= end:
        #이전 돌
        prev = 0
        mins = math.inf
        removed_rocks = 0
        mid = (start + end ) // 2

        for rock in rocks:
            #현재 돌과 이전 돌의 거리차이가 mid 보다 작으면, 제거되는 돌의 개수 증가
            if rock - prev < mid:
                removed_rocks +=1
            else:
                #현재- 이전 바위 거리 와 이전에 찾았던 최소 거리 최솟 값 비교
                mins = min(mins,rock-prev)
                #현재 바위를 체크했으므로, 이전 바위는 현재바위가 됨
                prev = rock

#         #제거한 돌 개수가 n보다 많으면, 제거하는 바위의 수를 줄여야함
#         #바위 사이의 최소거리의 기준을 내린다.
        if removed_rocks > n:
            end = mid - 1

#         #제거한 돌 개수가 기준보다 적으면, 제거하는 바위의 수를 늘려야함
#         #바위 사이의 최소거리의 기준을 올린다
        else:
            answer = mins
            start = mid +1


    return answer