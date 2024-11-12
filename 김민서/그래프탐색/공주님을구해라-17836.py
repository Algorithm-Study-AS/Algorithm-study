# (1,1)에서 출발하여 (n,m)에 위치한 공주를 t시간 이내로 구해야 한다.
# 한 칸을 이동하는데 한 시간이 걸리고, 상하좌우로 이동할 수 있다.
# 그람(2)를 획득할 경우 벽(1)을 부수고 이동할 수 있다.
# 공주를 구할 수 있는 최소 시간을 구해라. (구출 불가 시 fail 출력)

from collections import deque

def bfs(n, m, maps, start, ignore_walls=False):
    inf = float('inf')
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    time = [[inf] * m for _ in range(n)]
    q = deque([start])
    time[start[0]][start[1]] = 0
    
    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m and time[nx][ny] == inf:
                if ignore_walls or maps[nx][ny] != 1:
                    time[nx][ny] = time[x][y] + 1
                    q.append((nx, ny))
    return time


def solution(n, m, t, maps):
    time_without_gram = bfs(n, m, maps, (0, 0))
    direct_time = time_without_gram[n-1][m-1]

    inf = float('inf')
    gram_time = inf

    for i in range(n):
        for j in range(m):
            if maps[i][j] == 2:
                time_to_gram = time_without_gram[i][j]

                # 그람에 도달할 수 있는 경우 -> 그람 이전의 bfs(벽o) + 그람 이후의 bfs(벽x)
                if time_to_gram != inf:
                    time_with_gram = bfs(n, m, maps, (i, j), ignore_walls=True)

                    if time_with_gram[n-1][m-1] != inf:
                        gram_time = time_to_gram + time_with_gram[n-1][m-1]

    answer = min(direct_time, gram_time) # 최소 거리일 때의 시간과 그람을 획득했을 때의 시간 비교
    return answer if answer <= t else "Fail"


def main():
    n, m, t = map(int, input().split())
    maps = [list(map(int, input().split())) for _ in range(n)]

    print(solution(n, m, t, maps)) # 그람을 획득했을 때와 아닐 때를 구분하여 구한 후 최솟값


if __name__ == "__main__":
    main()