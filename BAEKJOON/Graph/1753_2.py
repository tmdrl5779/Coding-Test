import heapq
import math
import sys

input = sys.stdin.readline

v, e = map(int, input().split())
k = int(input())
dist = [math.inf] * (v + 1)
queue = []
graph = [[] for _ in range(v + 1)]

for _ in range(e):
    start, end, w = map(int, input().split())
    graph[start].append((end, w))


def dijkstra(start):
    dist[start] = 0
    heapq.heappush(queue, (dist[start], start))

    while queue:
        pop_weight, pop_vertex = heapq.heappop(queue)  # 현재 노드

        if dist[pop_vertex] < pop_weight:
            continue

        for next_vertex, next_weight in graph[pop_vertex]:  # 현재 노드에서 이어진 노드들
            next_cal_weight = next_weight + pop_weight

            if next_cal_weight < dist[next_vertex]:
                dist[next_vertex] = next_cal_weight
                heapq.heappush(queue, (next_cal_weight, next_vertex))


dijkstra(k)
for i in range(1, v + 1):
    if dist[i] == math.inf:
        print('INF')
    else:
        print(dist[i])
