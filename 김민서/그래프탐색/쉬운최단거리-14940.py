# m*n의 지도, 가로/세로로만 움직일 수 있다.
# 0: 이동 불가능, 1: 이동 가능, 2: 목표 지점
# 각 지점에서 목표지점까지의 거리를 출력 (원래 이동 불가능한 경우 0, 원래 가능한데 도달하지 못한 경우 -1)

from collections import deque

def bfs(x, y):
    global n, m, maps

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    distance = [[-1] * m for _ in range(n)]
    distance[x][y] = 0

    q = deque()
    q.append((x, y))

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m and maps[nx][ny] != 0 and distance[nx][ny] == -1:
                distance[nx][ny] = distance[x][y] + 1
                q.append((nx, ny))
    
    for i in range(n):
        for j in range(m):
            if maps[i][j] == 0:
                distance[i][j] = 0

    return distance


def main():
    global n, m, maps

    n, m = map(int, input().split())
    maps = [list(map(int, input().split())) for _ in range(n)]

    for i in range(n):
        for j in range(m):
            if maps[i][j] == 2:
                distance = bfs(i, j)
                break

    for i in range(n):
        print(" ".join(map(str, distance[i])))

if __name__ == "__main__":
    main()