import math
import heapq
import sys

input = sys.stdin.readline

v, e = map(int, input().split())
k = int(input())  # 시작점
dist = [math.inf] * (v + 1)  # 거리 테이블
heap = []
graph = [[] for _ in range(v + 1)]

for _ in range(e):  # 그래프 초기하
    start, end, w = map(int, input().split())
    graph[start].append((w, end))


def dijkstra(start):
    dist[start] = 0  # 시작 가중치 = 0
    heapq.heappush(heap, (dist[start], start))  # 시작점 우선순위 큐에 넣음 (가중치가 맨앞으로)

    while heap:  # 큐에 아무것도 없을때 까지
        current_weight, current = heapq.heappop(heap)  # 큐에서 가장 작은 거리 pop

        if dist[current] < current_weight:  # pop한 노드의 가중치가 이미 저장된 가중치보다 크면 패스
            continue

        for graph_next_weight, next in graph[current]:
            next_weight = current_weight + graph_next_weight  # 이전 노드에서 다음 노드로 가느 가중치

            if next_weight < dist[next]:  # 계산된 가중치 < 다음 노드의 가중치
                dist[next] = next_weight
                heapq.heappush(heap, (next_weight, next))  # 큐에 다음 노드랑 게산된 가중치 넣음


dijkstra(k)
for i in range(1, v + 1):
    if dist[i] == math.inf:
        print("INF")
    else:
        print(dist[i])
