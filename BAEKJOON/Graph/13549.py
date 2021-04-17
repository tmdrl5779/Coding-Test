import heapq
import math

n, k = map(int, input().split(' '))
dist = [math.inf] * 100001

dx = [-1, 1, 2]
p_queue = list()

def dijkstra(start):
    dist[start] = 0
    heapq.heappush(p_queue, (dist[start], start))

    while p_queue:
        pop_dist, pop_vertex = heapq.heappop(p_queue)


        if dist[pop_vertex] < pop_dist:
            continue

        if pop_vertex == k:
            return

        for i in range(3):
            if i != 2:
                nx = pop_vertex + dx[i]
                go_dist = 1
            else:
                nx = pop_vertex * dx[i]
                go_dist = 0

            if nx < 0 or nx > 100000:
                continue

            sum_dist = go_dist + pop_dist

            if dist[nx] > sum_dist:
                dist[nx] = sum_dist
                heapq.heappush(p_queue, (sum_dist, nx))


dijkstra(n)
print(dist[k])
