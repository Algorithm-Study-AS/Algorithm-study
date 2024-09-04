# n*m 크기의 연구소, 0:빈 칸, 1:벽, 2:바이러스
# 바이러스는 상하좌우로 퍼질 수 있고, 3개의 벽을 세워야 한다.
# 안전 영역 크기의 최댓값

import copy
from collections import deque

n, m = map(int, input().split())
graph = []
answer = 0

for _ in range(n):
    graph.append(list(map(int, input().split())))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs():
    queue = deque()
    temp = copy.deepcopy(graph)

    for i in range(n):
        for j in range(m):
            if temp[i][j] == 2:
                queue.append((i, j))

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue

            if temp[nx][ny] == 0:
                temp[nx][ny] = 2
                queue.append((nx, ny))

    global answer
    count = 0

    for i in range(n):
        count += temp[i].count(0)

    answer = max(answer, count)

def makeWall(count):
    if count == 3:
        bfs()
        return
    
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0: # 벽 세우기 가능
                graph[i][j] = 1 # 벽을 세운다.
                makeWall(count + 1) # 두번째 벽 세우기
                graph[i][j] = 0 # 벽을 허문다. (백트래킹)
    
makeWall(0)
print(answer)